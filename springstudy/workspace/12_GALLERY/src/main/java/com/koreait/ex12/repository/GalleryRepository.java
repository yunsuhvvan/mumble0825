package com.koreait.ex12.repository;

import java.util.List;

import com.koreait.ex12.domain.Gallery;

public interface GalleryRepository {
		
	
	//GalleryRepository는 gallery.xml과 직결됨
	// method 이름 =  각 쿼리문 id
	// 반환타입    =  resultType
	// 매개변수    =  parameterType
	public List<Gallery> selectGalleryList();
	public Gallery selectGalleryByNo(Long no);
	public int insertGallery(Gallery gallery);
	public int updateGallery(Gallery gallery);
	public int deleteGallery(Long no);
	
}
