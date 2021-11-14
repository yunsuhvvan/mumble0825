package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.ProductDto;
import mybatis.config.DBService;

public class ProductDao {

	private SqlSessionFactory factory;
	private static ProductDao instance;
	
	private ProductDao() {
		factory = DBService.getInstance().getFactory();
	}
	public static ProductDao getInstance() {
		if(instance == null) {
			instance = new ProductDao();
		}
		return instance;
	}
	
	
	//1. 제품 추가
	
	public int insert (ProductDto dto) {
		SqlSession ss = factory.openSession(false);
		int result =  ss.insert("dao.product.insert", dto);
		if(result > 0 ) ss.commit();
		ss.close();
		return result;
		
	}
	
	//2. 제품 목록
	
	public List<ProductDto> selectList(){
		SqlSession ss = factory.openSession();
		List<ProductDto> result = ss.selectList("dao.product.selectList");
		ss.close();
		return result;
				
				
	}
	
	// 3. 중복체크
	
	public boolean nameCheck(String name) {
		SqlSession ss = factory.openSession();
		ProductDto dto = ss.selectOne("dao.product.nameCheck", name);
		ss.close();
		return dto==null;
		
	}
	
	//4. 마지막 제품명
	
	public ProductDto lastName() {
		SqlSession ss = factory.openSession();
		ProductDto dto = ss.selectOne("dao.product.lastName");
		ss.close();
		return dto;
	}
	
	
	
	
	
	
	
}
