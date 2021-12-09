package com.koreait.ex12.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Matcher;

import javax.servlet.http.HttpServletResponse;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
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
		gallery.setIp(multipartRequest.getRemoteAddr());											// 이게 IP가 된다..
		
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
	public int updateGallery(Gallery gallery) {
		return 0;
	}

	@Override
	public int deleteGallery(Long no) {
		return 0;
	}
	
	@Override
	public void message(int result, HttpServletResponse response, String success, String fail, String path) {
		GalleryService.super.message(result, response, success, fail, path);
	}

}
