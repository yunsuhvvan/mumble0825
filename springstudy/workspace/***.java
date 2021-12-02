@Autowired

ctx 없이 bean  생성하기

@injection, @Resource, @Autowired와 같은 애너테이션 중 하나를 사용한다.
 
 @Autowired
  1) 객체 타입이 일치하는 객체를 찾아서 알아서 생성.
  2) 필드, 생성자, setter를 대상으로함.
  3) 필드는 필드 자체에 생성, 생성자나 setter는 매개변수에 생성

1. 필드에 @Autowired 지정하기
   - 필드마다 붙여야한다. 필드가 10개면 10개의 @Autowired가 필요하다.
    ex) @Autowired
        private Board myBoard; // ★반환타입이 일치하는(=Board) bean을 찾아서 가져온다 dependency injection★
   
2. 생성자에 @Autowired 지정하기
   - 생성자는 @Autowired를 생략해도 된다
  private Board myBoard;
  
  @Autowired // 생략할 수 있다.
  public BoardController(Board myBoard){  //★ 매개변수 있는 생성자를 만들면 자동으로 주입된다.★
      super();
      this.myBoard = myBoard;
  }
  
  
 3. setter에 @Autowired 지정하기
    - @Autowired를 꼭 적어야한다.
    setter 메소드명을 마음대로 작성해도 된다.

  private Board myBoard;
  public Board getMyBoard(){
    return myBoard;
  }
  @Autowired  // 생략할 수 없다
public void setBoard(Board myBoard){ //★ 매개변수로 자동 주입된다★
    this.myBoard = myBoard; 
}
  
 ******************************************************************************************************************************
