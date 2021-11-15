package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.Product;
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
	
	//1. 제품 목록 
	
	public List<Product> selectList(){
		SqlSession ss= factory.openSession();
		List<Product> list = ss.selectList("dao.product.selectList");
		ss.close();
		return list;
	}
	
	// 2. 제품명 중복 체크
	
	public boolean nameCheck(String name) {  //반환을 true or false로
		SqlSession ss = factory.openSession();
		Product product = ss.selectOne("dao.product.nameCheck" , name); //반환타입 Product.. DTO....
		ss.close();
		return product == null;  //  name이 참조형이라서 NULL로 유무를 따지는..??
	}
	
	// 3. 제품 등록 
	public int insert(Product product) {
		SqlSession ss = factory.openSession(false);
		int result = ss.insert("dao.product.insert", product);
		if(result>0) ss.commit(); //까먹지 말기..
		ss.close();
		return result;
	}
	
	
	//4. 마지막 상품 체크
	public Product lastCheck() {
		SqlSession ss = factory.openSession();
		Product product = ss.selectOne("dao.product.lastCheck");   //DB로부터 가져오는 제품
		ss.close();
		return product;
		
	}
	
	// 5. 제품 삭제
	
	public int delete(Long pno) {
		SqlSession ss = factory.openSession(false);
		int result = ss.delete("dao.product.delete" , pno);
		if(result>0) ss.commit();
		ss.close();
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
