#include <stdio.h>

// ���� ������ ����ü �����ϱ� (��� �Լ����� ����� �� �ִ�)

// ����ü �����  
// ����ü product�� ���� ���ο� �̸� "Product" �� �ο��Ѵ�. 
typedef struct product {
	
	long pNo;
	char pName[21];
	int price;
	
} Product;  // Product�� �������� �ڷ����� �ȴ�.

// ����ü ���� ���� 
Product p; // Product Ÿ���� ���� p


void a(){
	//�������� ��밡�� 
	
	printf("��ǰ��ȣ �Է� >>> ") ; scanf("%d" , &p.pNo);
	printf("��ǰ�� �Է� >>> ") ; scanf("%s" , p.pName); // pName�� �迭  
	printf("��ǰ���� �Է� >>> ") ; scanf("%d" , &p.price);
	
	
} 



void b(){
	//�������� ��밡�� 
	printf("��ǰ��ȣ :  %d\n", p.pNo);
	printf("��ǰ�� :  %s\n", p.pName);
	printf("��ǰ���� :  %d\n", p.price);
}


#define LENGTH 10
// ����ü ���� ���� 
Product products[LENGTH]; 

void c(){

 int i;
 for (i=0; i < LENGTH; i++){
 	printf("%d��° ��ǰ ���� �Է�\n", i +1);
	printf("��ǰ��ȣ   �Է� >>> ") ; scanf("%d" , &products[i].pNo);
	printf("��ǰ�� �Է� >>> ") ; scanf("%s" , products[i].pName); // pName�� �迭  
	printf("��ǰ���� �Է� >>> ") ; scanf("%d" , &products[i].price);
 	
 }
 

}

void d(){
	int i;
	
	for (i=0; i<LENGTH; i++){
		printf("%d��° ��ǰ, ��ȣ : %d, �̸� : %s , ���� : %d\n", i +1, products[i].pNo, products[i].pName, products[i].price);
	}
}




int main (){
	
	//a();
	//b();
	c();  //��ǰ�� 3���� �Է� ���� �� �ִ� �Լ�  Product product[3]
	d(); // ��ǰ 3���� ����ϴ� �Լ�  
	
	return 0 ;
}
