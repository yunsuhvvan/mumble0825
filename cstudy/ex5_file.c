#include <stdio.h>
//wt  fputc
void w1(){
	
	FILE * f = fopen("text1.txt", "wt"); // wt��� : write + text (�ؽ�Ʈ ������ ����ڴ�.)
	
	if(f == NULL){
		fprintf(stderr, "file open error\n"); // stderr ; ǥ�� ���� ��Ʈ�� (�����޽��� ���) 
		return; 
	} 
	
	// fputc() �Լ�, ���Ͽ� �� ���ڸ� ���� �� 
	fputc('T', f);
	fputc('a', f);
	
	fclose(f);
	
} 


//at fputs
void w2(){
	FILE * f = fopen("text1.txt", "at");   // at ��� : append + text  ( ���� �ؽ�Ʈ ���Ͽ� ������ �߰��Ѵ�. ������ ������ ���� �����.)
	
	if (f == NULL){
		fprintf(stderr, "file open error\n");
		return;
	}  
// fputs ���Ͽ� ���ڿ��� ������
  	fputs("nos", f);
	  
	  fclose(f);
	   

	
}


void w3(){
	
	
	char name[] = "�ΰ���";
	int age = 44;
	
	
	FILE  * f = fopen("text2.txt", "wt");
	
	if (f == NULL){
	
		fprintf(stderr, "file open error\n");
		return;
	}
	//fprintf() �Լ�, ���ϵ� ������� printf()���
	fprintf(f, "�̸� : %s, ���� : %d��\n", name , age);
	
	fclose(f);
	 
}
//rt
void r(){
	int ch; 
	FILE * f = fopen("text1.txt", "rt"); // rt��� read +text �ؽ�Ʈ ���� �б�
	 if (f ==NULL){
	 	fprintf(stderr, "file open error\n");
	 	return;
	 } 

	// fgetc()�Լ�, ���Ͽ��� �� ���ڸ� ���� ��
	// �о� ���� ���ڴ� int�� ���� 

	// ���ѷ����� ���� 
	while (1) { // ���ѷ��� ,1 �� TRUE�� �ǹ��� 

		ch = fgetc(f);
		if(ch == EOF){ //END OF FILE  ������ ���� �˸��� ����  
			break;
		}
		printf("%c", ch);
		
	} 
	
	fclose(f);


}



int main (){
	r();
	
}
