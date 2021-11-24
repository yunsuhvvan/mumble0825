package common;

public class Page {

	private int totalRecord;   // 전체 게시글 수 (DB에서 가져 옴)
	private int totalPage;     // 전체 페이지 수  (totalRecord, recordPerPage로 "계산")
	private int recordPerPage = 3; //  한 페이지당 표시하는 게시글 갯수 (여기서 정한다.)
	
	/**********************************************
	 *  // For Example//					   ****
	 *  - 전체 11개 게시글					   ****
	 *  - 한 페이지당 3개 게시글			   ****
	 *  page =1, beginRecord =1, endRecord =3  ****
	 *  page =2, beginRecord =4, endRecord =6  ****
	 *  page =3, beginRecord =7, endRecord =9  ****
	 *  page =4, beginRecord =10, endRecord =11****
	 **********************************************/
	private int page;  			// 현재 페이지 번호 (파라미터로 받아옴)
	private int beginRecord;    // 각 페이지에 표시되는 시작 게시글 번호 (page, recordPerPage로 계산)
	private int endRecord;    	// 각 페이지에 표시되는 종료 게시글 번호 (beginRecord, recordPerPage, totalRecord로 계산)
	
	/****************************************************************
	 *  -전체 12 페이지 											*
	 *  - 한 블록당 5개	 페이지										*
	 * 1block < 1 2 3 4  5 > - page=1~5   beginPage =1, endPage= 5  *	
	 * 2block < 6 7 8 9 10 > - page=6~10  beginPage =6, endPage= 10 *
	 * 3block < 11 12 >   	 - page=11~15 beginPage =11,endPage= 12 *
	 ****************************************************************/
	private int pagePerBlock = 5;  // 한 블록에 표시하는 페이지 갯수(여기서 정함)
	private int beginPage;		   // 각 블록에 표시하는 시작 페이지 번호 (page, pagePerBlock로 계산)
	private int endPage;		   // 각 블록에 표시하는 종료 페이지 번호 (beginPage, pagePerBlock, totalPage로 계산)
	
	
	
	
	
	
	
	
	
	public int getPagePerBlock() {
		return pagePerBlock;
	}
	public void setPagePerBlock(int pagePerBlock) {
		this.pagePerBlock = pagePerBlock;
	}
	public int getBeginPage() {
		return beginPage;
	}
	public void setBeginPage() {  // 수정
		beginPage = ((page - 1) / pagePerBlock) *pagePerBlock + 1;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage() {   // 수정
		endPage =  beginPage + pagePerBlock -1;
		if(totalPage < endPage ) {
			endPage = totalPage;
		}
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getBeginRecord() {
		return beginRecord;
	}
	public void setBeginRecord() {   // 수정
		beginRecord = (page -1) * recordPerPage + 1 ;
	}
	public int getEndRecord() {
		return endRecord;
	}
	public void setEndRecord() {      // 수정
		endRecord = beginRecord + recordPerPage - 1 ; 
		if( totalRecord < endRecord) {    // 마지막 페이지일 경우에 문제가 생길 수 있기 때문에
			endRecord = totalRecord;
		}
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage() {  // 수정
		totalPage =  totalRecord / recordPerPage;
		if(totalRecord % recordPerPage != 0) {
			totalPage ++;
		}
	}
	public int getRecordPerPage() {
		return recordPerPage;
	}
	public void setRecordPerPage(int recordPerPage) {
		this.recordPerPage = recordPerPage;
	}
	
	
	
	
}
