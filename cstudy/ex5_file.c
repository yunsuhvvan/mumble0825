#include <stdio.h>
//wt  fputc
void w1(){
	
	FILE * f = fopen("text1.txt", "wt"); // wt모드 : write + text (텍스트 파일을 만들겠다.)
	
	if(f == NULL){
		fprintf(stderr, "file open error\n"); // stderr ; 표준 에러 스트림 (에러메시지 출력) 
		return; 
	} 
	
	// fputc() 함수, 파일에 한 글자만 보낼 때 
	fputc('T', f);
	fputc('a', f);
	
	fclose(f);
	
} 


//at fputs
void w2(){
	FILE * f = fopen("text1.txt", "at");   // at 모드 : append + text  ( 기존 텍스트 파일에 내용을 추가한다. 파일이 없으면 새로 만든다.)
	
	if (f == NULL){
		fprintf(stderr, "file open error\n");
		return;
	}  
// fputs 파일에 문자열을 보낼때
  	fputs("nos", f);
	  
	  fclose(f);
	   

	
}


void w3(){
	
	
	char name[] = "민경태";
	int age = 44;
	
	
	FILE  * f = fopen("text2.txt", "wt");
	
	if (f == NULL){
	
		fprintf(stderr, "file open error\n");
		return;
	}
	//fprintf() 함수, 파일들 대상으로 printf()사용
	fprintf(f, "이름 : %s, 나이 : %d살\n", name , age);
	
	fclose(f);
	 
}
//rt
void r(){
	int ch; 
	FILE * f = fopen("text1.txt", "rt"); // rt모드 read +text 텍스트 파일 읽기
	 if (f ==NULL){
	 	fprintf(stderr, "file open error\n");
	 	return;
	 } 

	// fgetc()함수, 피일에서 한 글자만 읽을 때
	// 읽어 들인 문자는 int에 저장 

	// 무한루프로 구성 
	while (1) { // 무한루프 ,1 은 TRUE를 의미함 

		ch = fgetc(f);
		if(ch == EOF){ //END OF FILE  파일의 끝을 알리는 문자  
			break;
		}
		printf("%c", ch);
		
	} 
	
	fclose(f);


}



int main (){
	r();
	
}
