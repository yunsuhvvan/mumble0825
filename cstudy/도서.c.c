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


		
		printf(":::������� ���α׷�:::\n");
		printf("1. �������� ���\n");
		printf("2. �������� ��ȸ\n");
		printf("3. ��ü���� ���\n");
		printf("0. ���α׷� ����\n");
		 printf("�޴�����(1,2,3,0)>>> ");
     	
    
   		    

}

void addBook() {
    int i;
 for (i=0; i < LENGTH; i++){
 	if (i >= LENGTH){
 		printf("���̻� ������ �� �����ϴ�.");	
		 } else {
		printf("���� ��ȣ �Է� >>> ") ; scanf("%d" , &books[i].bookNo);
		printf("���� ���� �Է� >>> ") ; scanf("%s" , books[i].title);
		printf("���� ���� �Է� >>> ") ; scanf("%s" ,books[i].author);
	 } 
	
}
}

void query(){
	
	if(!(1001 <= bookNo && bookNo <= 9999)){
		print("�ش� ������ ã�� �� �����ϴ�") 
	} else {
		printf("��ȸ�� å ��ȣ �Է� >>>"); scanf("%d", &books[i].bookNo);
		printf("��ȸ ��� : %s,%s", books[i].title, books[i].author);
	}
	
}


void printBook() {
	int i;
	for(i = 0 ; i < books[i].bookNo; i++] 
	printf("%d ,%s ,%s\n", books[i].bookNo,books[i].title,books[i].title);
	if(i != books[i].bookNo){
		printf("����� ������ ã�� �� �����ϴ�.")
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
						printf("���α׷� ����"); return;
					default: printf("�۾��� 1,2,3,0 �� �ϳ��Դϴ�."); 
					
				}
				
			}
return 0 ;

} 

