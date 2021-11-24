#include <stdio.h>

// 전역 변수로 구조체 선언하기 (모든 함수에서 사용할 수 있다)

// 구조체 만들기  
// 구조체 product을 만들어서 새로운 이름 "Product" 을 부여한다. 
typedef struct product {
	
	long pNo;
	char pName[21];
	int price;
	
} Product;  // Product는 이제부터 자료형이 된다.

// 구조체 변수 선언 
Product p; // Product 타입의 변수 p


void a(){
	//전역변수 사용가능 
	
	printf("제품번호 입력 >>> ") ; scanf("%d" , &p.pNo);
	printf("제품명 입력 >>> ") ; scanf("%s" , p.pName); // pName은 배열  
	printf("제품가격 입력 >>> ") ; scanf("%d" , &p.price);
	
	
} 



void b(){
	//전역변수 사용가능 
	printf("제품번호 :  %d\n", p.pNo);
	printf("제품명 :  %s\n", p.pName);
	printf("제품가격 :  %d\n", p.price);
}


#define LENGTH 10
// 구조체 변수 선언 
Product products[LENGTH]; 

void c(){

 int i;
 for (i=0; i < LENGTH; i++){
 	printf("%d번째 제품 정보 입력\n", i +1);
	printf("제품번호   입력 >>> ") ; scanf("%d" , &products[i].pNo);
	printf("제품명 입력 >>> ") ; scanf("%s" , products[i].pName); // pName은 배열  
	printf("제품가격 입력 >>> ") ; scanf("%d" , &products[i].price);
 	
 }
 

}

void d(){
	int i;
	
	for (i=0; i<LENGTH; i++){
		printf("%d번째 제품, 번호 : %d, 이름 : %s , 가격 : %d\n", i +1, products[i].pNo, products[i].pName, products[i].price);
	}
}




int main (){
	
	//a();
	//b();
	c();  //제품을 3개를 입력 받을 수 있는 함수  Product product[3]
	d(); // 제품 3개를 출력하는 함수  
	
	return 0 ;
}
