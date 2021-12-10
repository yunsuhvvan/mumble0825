package com.koreait.ex12.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.koreait.ex12.service.GalleryService;

@Controller
@RequestMapping("gallery")
public class GalleryController {
	
	
	
	private GalleryService service;
	// 생성자를 이용한 @Autowired
	// 생성자의 매개변수에 걸린다. 
	// 만들어야하는 Bean이 두개 이상이면 @Autowired를 2번이상 해야 하는데 field가 여러개일때는 생성자를 쓰는게 좋겠따.
	public GalleryController(GalleryService service) { 
		super();
		this.service = service;
	}

	@GetMapping(value = "selectGalleryList")
	public String selectGalleryList(Model model) {
		model.addAttribute("list", service.selectGalleryList() );
		return "gallery/list";
	}
	
	@GetMapping(value = "insertPage")
	public String insertPage() {
		return "gallery/insert";
	}
	
	@PostMapping("insertGallery")
	public void insertGallery(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) {                 //bean(file이 들어가있어서) , requestParam도 안된다
		service.insertGallery(multipartRequest,response);
	}
	
	@GetMapping(value = "selectGalleryByNo")
	public String selectGalleryByNo (@RequestParam("no") Long no, Model model) {
		model.addAttribute("gallery", service.selectGalleryByNo(no));
		return "gallery/detail";
	}
	
	@PostMapping(value = "download")
	public void download(HttpServletRequest request, HttpServletResponse response) { //흠.....
		service.download(request, response);
	}
	
	@PostMapping(value = "updateGallery")
	public void updateGallery(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) {
		service.updateGallery(multipartRequest,response);
	}
	
	@PostMapping(value = "deleteGallery")
	public void deleteGallery(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) {
		service.deleteGallery(multipartRequest,response);
	}
}
