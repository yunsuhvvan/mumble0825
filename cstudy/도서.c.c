#include <stdio.h>

#define LENGTH 10
typedef struct book {
	 int bookNo;
	 char title[30];
	 char author[30];
	 int num;
}Book;


Book books[LENGTH];

void menu(){


		
		printf(":::도서등록 프로그램:::\n");
		printf("1. 도서정보 등록\n");
		printf("2. 도서정보 조회\n");
		printf("3. 전체도서 목록\n");
		printf("0. 프로그램 종료\n");
		 printf("메뉴선택(1,2,3,0)>>> ");
     	
    
   		    

}

void addBook() {
    int i;
 for (i=0; i < LENGTH; i++){
 	if (i >= LENGTH){
 		printf("더이상 저장할 수 없습니다.");	
		 } else {
		printf("도서 번호 입력 >>> ") ; scanf("%d" , &books[i].bookNo);
		printf("도서 제목 입력 >>> ") ; scanf("%s" , books[i].title);
		printf("도서 저자 입력 >>> ") ; scanf("%s" ,books[i].author);
	 } 
	
}
}

void query(){
	
	if(!(1001 <= bookNo && bookNo <= 9999)){
		print("해당 도서를 찾을 수 없습니다") 
	} else {
		printf("조회할 책 번호 입력 >>>"); scanf("%d", &books[i].bookNo);
		printf("조회 결과 : %s,%s", books[i].title, books[i].author);
	}
	
}


void printBook() {
	int i;
	for(i = 0 ; i < books[i].bookNo; i++] 
	printf("%d ,%s ,%s\n", books[i].bookNo,books[i].title,books[i].title);
	if(i != books[i].bookNo){
		printf("저장된 도서를 찾을 수 없습니다.")
	}
}


int main(){
	
			while (1) {
				menu();
				int num;
				switch(num){
					case 1:
						addBook(); break;
					case 2:
						queryBook(); break;
					case 3:
						printBook(); break;
					case 0:
						printf("프로그램 종료"); return;
					default: printf("작업은 1,2,3,0 중 하나입니다."); 
					
				}
				
			}
return 0 ;

} 

