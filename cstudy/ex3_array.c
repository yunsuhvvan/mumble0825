#include <stdio.h>


// 함수는 반드시 호출 (실행) 하기 전에 만들어져  있어야한다.
 void a(){
 	

 	
 	// 배열 선언
	int arr[3];
	
	// C에서 배열 길이는 계산해서 구한다.
	printf("배열 크기: %d바이트\n  ", sizeof(arr));
	printf("요소 크기: %d바이트\n ", sizeof(int));
	printf("배열 길이: %d 개\n ", sizeof(arr)/ sizeof(int));
	
 }

 void b(){
 	
 	// 배열 선언
	 int arr[3];
	 
	 // 배열 길이 
	 int length = sizeof(arr) / sizeof(int);
	// 배열 인덱스 선언
	int i; 
	 // 배열 요소
	 for ( i = 0; i <length; i++){
	 	printf("%d\n", arr[i]);
	 } 
 	
 }

 void c(){
 	
 	//배열 +길이 +인덱스 선언
	 int arr[3];
	 int i;
	 int length = sizeof(arr)/ sizeof(int);
	 
	 // 입력 및 출력
	 for (i =0 ; i <length; i++){
	 	printf("%d번째 요소를 입력하시오 >>>", i+1);
	 	scanf("%d", &arr[i]); // scanf() 사용시 & 필요 
	 } 
	  
	  for (i =0; i <length; i++){
	  	printf("%d번째 요소 = %d\n", i +1, arr[i]);
	  }
 }

 void quiz1(){
 	
   	// 5개의 정수를 입력 받아서 배열에 저장한다. 
	 //  저장된 요소가 홀수이면 0으로 바꾸시오
	 //전체 출력하시오.
	 
	 int arr[5];
	 int i;
	 int length = sizeof(arr)/sizeof(int);
	 
	 for (i = 0; i<length;  i++){
	 	printf("%d번째 요소 입력 >>>", i +1);
	 	scanf("%d", & arr[i]);
	 	if (arr[i] % 2 ==1){
	 		arr[i] = 0;
		 }
	 }
	  for ( i =0; i < length; i++ ){
	  	printf("%d번째 요소 = %d\n" ,  i + 1 , arr[i]);
	  }
 }

 void d(){
 	
 	int length = 3; // 변수 
	int arr[length]; // 변수는 배열의 길이가 될 수 없음.
	 
	
	
	
	 
 }


#define LENGTH 3 // pre-processor 가 미리처리..
	 				 // 앞으로 LENGTH 가 나타나면 3으로 바꿔서 컴파일 할 것.
					  // 단순치환 역할
 void d2(){
 	
 	int arr[LENGTH];  // 컴파일 시 int arr[3]; 모습으로 변환 됨. 그래서 문제가 없음 
 	int i ;
	 for (i = 0; i < LENGTH; i++) {
	 	printf("%d\n", arr[i]);
	 } 
 	
 	
 	
 	
 }


 void str1(){
 	
 	// 문자열 저장을 위한 char 타입의 배열은 수치형 배열과 다르다.
	 char str[6] =  "hello"; //  "문자열"  + "널문자" 의 크기가 필요
	 printf("%s",  str); 
 }


 void str2(){
 	
 	char str[6]; //영문 기준 최대 5자 가능
	 printf("문자열 입력 >>> ");
	 scanf("%s", str); // 배열은 &를 scanf에서 사용하지 않는다. 
	 printf("입력된 문자열은 %s이다. \n", str);
 }


 void str3(){
 	
 	char * str = "hello"; // 문자열 포인터
	 printf("%s", str) ;
 	
 }
 
 
 void str4() {
 	
 	char * str[3]; // 문자열을 3개 저장할 수 있다.
	 str[0] = "hello";
	 str[1] = "my";
	 str[2] = "c";
	
	
	 printf("%s %s %s\n", str[0] , str[1], str[2]); 
 }


 void quiz2(){
 	// 이름, 나이, 키 몸무게를 입력 받아서 출력하시오
	 //문자열 정수 실수 실수 
	 
	 char name[21];
	 int age;
	 double height;
	 double weight;
	 
	 
	 printf("이름 입력 >>> ");
	 scanf("%s", name); 
	 	 
	 printf("나이 입력 >>> ");
	 scanf("%d", &age); 
	
		 
	 printf("키 입력 >>> ");
	 scanf("%lf", &height);
	 
	 printf("몸무게 입력 >>> ");
	 scanf("%lf", &weight);     // double의 scanf()는 %lf만 가능. %f는 불가능 
	 
	 
	  
	
	
	
	 printf(" 이름 : %s\n", name);
	  printf(" 나이 : %d살\n", age);
	   printf(" 키 : %lfcm\n", height);
	    printf("몸무게 : %fkg\n", weight);  // double의 printf는 %f , %lf 둘다 가능.
		
		 
	 
 	
 }
int main() {
	
	/*
	if (조건식) {
	return -1;  비정상 종료 처리 
	}
	*/
	 quiz2();
	 
	return 0;
}


 
