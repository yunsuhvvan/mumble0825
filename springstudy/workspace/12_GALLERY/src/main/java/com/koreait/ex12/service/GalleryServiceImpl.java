package com.koreait.ex12.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Matcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.koreait.ex12.domain.Gallery;
import com.koreait.ex12.repository.GalleryRepository;

import net.coobird.thumbnailator.Thumbnails;

public class GalleryServiceImpl implements GalleryService {

	@Autowired   // 이게 없으면 NullPointerException이 발생한다... 바보냐?
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<Gallery> selectGalleryList() {
		GalleryRepository repository = sqlSession.getMapper(GalleryRepository.class);
		return repository.selectGalleryList();
	}
	
	@Override
	public void insertGallery(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) {
		
		// ★첨부파일 처리 : 서버에 파일저장 + DB에 정보 저장
		
		// ★ DB로 보낼 Gallery gallery
		Gallery gallery = new Gallery();
		gallery.setWriter(multipartRequest.getParameter("writer"));
		gallery.setTitle(multipartRequest.getParameter("title"));
		gallery.setContent(multipartRequest.getParameter("content"));
		Optional<String> opt = Optional.ofNullable(multipartRequest.getHeader("X-Forwarded-For"));  // 거쳐온 주소가Null이면 
		gallery.setIp(opt.orElse(multipartRequest.getRemoteAddr()));											// 이게 IP가 된다..
		
		try {
			
			MultipartFile file = multipartRequest.getFile("file");  //insert.jsp의 파라미터..?
			if(file != null && !file.isEmpty()) { // 둘다 필요 , 한마디로 첨부가 있으면,,,
				
				// ★ UUID :  Universal Unique IDentifier - 범용 고유 식별자 , 하이픈 제외하면 32자리.(인코딩,중복저장 문제 해결)
				// UUID를 파일명으로 사용하면,
				// 1. 파일명 인코딩해결
				// 2. 파일명 중복저장 해결
				
				// ★첨부파일의 본래 이름 : origin
				String origin = file.getOriginalFilename();
				String extName = origin.substring(origin.lastIndexOf("."));       // 첨부파일의 확장자 (".jpg" , ".jpeg" , ".gif" , ".png")
				String uuid = UUID.randomUUID().toString().replaceAll("-", "");   // 랜덤으로 UUID를 받고 "-"을 찾아서 , " " 빈문자열로 바꾸겠다..
				
				// 저장될 파일명 (saved) 결정
				String saved = uuid + extName;
				
				// ★ 저장될 경로
				// resources/upload/2021/12/09
				String sep = Matcher.quoteReplacement(File.separator);
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String path	= "resources" + sep + "upload" + sep + sdf.format(new Date()).replaceAll("-", sep);     
				// new Date -> util..  // "-"를 file.separator (경로구분하는것으로) 바꾸고
				//File.separator를 쓰는이유 : OS마다 경로구분자가 다르기때문에  자동으로 결정해달라고 사용하는 것임..
				
				String realPath = multipartRequest.getServletContext().getRealPath(path); //실제로 저장될 경로가 만들어진다 
				
				// ★ 저장 될 경로에 디렉터리 만들기
				//없으면 새로 만들어야한다.
				File dir = new File(realPath); // realPath에 연결
				
				if(dir.exists() == false) {
					dir.mkdirs();
				}
				// ★ 첨부파일 서버에 업로드 (예외 처리 필요)
				File uploadFile = new File(dir, saved); // new File(경로,파일) 순서 지켜주기!
				file.transferTo(uploadFile); 		// 업로드 진행ing... 코드
				
				
				// ★ 썸네일 이미지 생성 (예외 처리 필요)
				Thumbnails.of(uploadFile)   			// 우리가 올리는 파일전달하기
				.size(100, 100)
				.toFile(new File(realPath, "s_" + saved));   // 어디로 내보낼거냐~...
				
				
				// 첨부가 있으면 DB에 path, origin, saved 저장
				gallery.setOrigin(origin);
				gallery.setSaved(saved);
				gallery.setPath(path);
				
				// ★ 첨부가 없으면
			} else {
				// ★ 첨부가 없으면 path, origin, saved 빈 문자열 처리
				gallery.setOrigin("");
				gallery.setSaved("");
				gallery.setPath("");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		GalleryRepository repository = sqlSession.getMapper(GalleryRepository.class);
		int result =  repository.insertGallery(gallery);  //DB에 넣는...
		message(result, response, "등록성공", "등록실패", "/ex12/gallery/selectGalleryList");
	}

	@Override
	public Gallery selectGalleryByNo(Long no) {
		GalleryRepository repository = sqlSession.getMapper(GalleryRepository.class);
		return repository.selectGalleryByNo(no);
	}

	@Override
	public void download(HttpServletRequest request, HttpServletResponse response) {
		
//		request.setCharacterEncoding("UTF-8");
		
		//다운로드 할 파일 정보
		String path = request.getParameter("path");
		String realPath = request.getServletContext().getRealPath(path);  // 실제 서버상의 경로
		System.out.println("서버상의 경로"+realPath.toString());	
		
		//realPath 확인해보기
		
		String saved = request.getParameter("saved");
		// 사용자들이 다운로드 할 때 생성될  파일 이름
		String origin = request.getParameter("origin");
		
		
		
		// 다운로드 할 File
		File file = new File(realPath, saved);
		/*
		 다운로드란?
		 다운로드 할 File을 읽어서			-InputStream
		 사용자에게 그대로 응답하는 것		-OutputStream
		*/
		
		BufferedInputStream bis =  null;
		BufferedOutputStream bos = null;
		try {
			// 다운로드를 처리할 수 있는 response로 만들기
			response.setHeader("Content-Type", "application/x-msdownload");  			   // http의 타입 ex)text/html;처럼
			response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(origin, "UTF-8").replaceAll("\\+", " "));  // 사용자들이 다운로드를 받으면 origin을 보여주는 코드
			response.setHeader("Content-Length", file.length() + "");                    // 파일의 크기를 byte수로..
			
			bis = new BufferedInputStream(new FileInputStream(file)); 	   				// 다운로드 할 파일.
			bos = new BufferedOutputStream(response.getOutputStream());    			   // 사용자에게 보내주기 위해서..
			
			// 스프링의 파일 복사
			FileCopyUtils.copy(bis, bos);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(bos != null) bos.close();
				if(bis != null) bis.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	@Override
	public void updateGallery(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) {
		
		// ★ DB로 보낼 Gallery gallery
		Gallery gallery = new Gallery();
		gallery.setNo(Long.parseLong(multipartRequest.getParameter("no")));
		gallery.setTitle(multipartRequest.getParameter("title"));
		gallery.setContent(multipartRequest.getParameter("content"));
		
		try {
			//기존의 첨부파일 정보
			String path = multipartRequest.getParameter("path");
			String realPath = multipartRequest.getServletContext().getRealPath(path);
			String origin = multipartRequest.getParameter("origin");
			String saved = multipartRequest.getParameter("saved");
			
			// 변경할 첨부파일
			MultipartFile newFile = multipartRequest.getFile("newFile");
			
			//변경할 첨부가 있으면 // 새로운 첨부, 새로운 썸네일, 새로운 내용
			if( newFile !=null && newFile.isEmpty() == false) {
				
			// 기존의 첨부파일 정보 지우기 realPath,saved를 이용해서..
			File file = new File(realPath, saved);
			if(file != null && file.exists()) {
				file.delete();
			}
			File thumb = new File(realPath, "s_" + saved);
			if(thumb != null && thumb.exists()) {
				thumb.delete();
			}
			
			// 새로운 첨부파일 , 썸네일 저장하기
			// ★첨부파일의 본래 이름 : origin
			// **기존 첨부가 없는 경우 path가 없어서 새로 생성해야 함**
			
			// 기존 첨부가 없는 경우 최초작성일을 기준으로 경로를 생성한다.
			if(path.isEmpty()) {
				String created = multipartRequest.getParameter("created");
				String sep = Matcher.quoteReplacement(File.separator);
			    path	= "resources" + sep + "upload" + sep + created.replaceAll("-", sep);     
				realPath = multipartRequest.getServletContext().getRealPath(path); 
							
			File dir = new File(realPath); // realPath에 연결
				if(dir.exists() == false) {
					dir.mkdirs();
				}
			}
			
			
			String newOrigin = newFile.getOriginalFilename();
			String extName = newOrigin.substring(newOrigin.lastIndexOf("."));       // 첨부파일의 확장자 (".jpg" , ".jpeg" , ".gif" , ".png")
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");   // 랜덤으로 UUID를 받고 "-"을 찾아서 , " " 빈문자열로 바꾸겠다..
			
			String newSaved = uuid + extName;
			
			File uploadFile = new File(realPath, newSaved); 
			newFile.transferTo(uploadFile); 		
			
			Thumbnails.of(uploadFile)   		
			.size(100, 100)
			.toFile(new File(realPath, "s_" + newSaved));  
			
			gallery.setOrigin(newOrigin);
			gallery.setSaved(newSaved);
			gallery.setPath(path);
				
				
			}
			// 변경할 첨부가 없으면, 기존의 첨부를 그대로 사용하겠다.
			else {
				gallery.setOrigin(origin);
				gallery.setSaved(saved);
				gallery.setPath(path);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		GalleryRepository repository = sqlSession.getMapper(GalleryRepository.class);
		int result = repository.updateGallery(gallery);
		message(result, response, "수정성공", "수정실패", "/ex12/gallery/selectGalleryByNo?no=" + multipartRequest.getParameter("no"));
		
		
	}

	@Override
	public void deleteGallery(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) {
	
		// 첨부 삭제
		String path = multipartRequest.getParameter("path");
		String realPath = multipartRequest.getServletContext().getRealPath(path);
		String saved= multipartRequest.getParameter("saved");
		
		File file = new File(realPath, saved);
		if(file != null) {  // 널이 아닐때를 먼저 검사해야 NullpointerException을 방지할 수 있다..!!
			if(file.exists()) {
				file.delete(); // 저장되어있던 파일의 경로, 이름을 찾아 확인해보고 있으면 지우는 코드 // DB와는 상관없는 작업..
			}
		}
		// 섬네일 지우기
		File thumbnail = new File(realPath, "s_"+saved);
		if(thumbnail !=null && thumbnail.exists()) {
			thumbnail.delete();
		}
		// DB 삭제
		Long no = Long.parseLong(multipartRequest.getParameter("no"));
		GalleryRepository repository = sqlSession.getMapper(GalleryRepository.class);
		int result = repository.deleteGallery(no);
		message(result, response, "삭제성공", "삭제실패", "/ex12/gallery/selectGalleryList");
	}
	
	@Override
	public void message(int result, HttpServletResponse response, String success, String fail, String path) {
		GalleryService.super.message(result, response, success, fail, path);
	}
	

}
