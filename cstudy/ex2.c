#include<stdio.h>

int main() {
	
	char   a;  // ������(garbage) ���� 
	int    b;
	double c;
	char str[11];
	
	printf("���� �Է� >>> ");
	scanf("%c", &a);  // �Ϲ� ������ '&������'
	 
	printf("���� �Է� >>> ");
	scanf("%d", &b);
	
	printf("�Ǽ� �Է� >>> ");
	scanf("%lf", &c);
	
	printf("���ڿ� �Է� >>> ");
	scanf("%s", str);  // �迭�� '�迭��' �Ǵ� '&�迭��[0]' , �߰��� ������ ���� �� �� 
	// ���� �Է��� ������ �͵� 
	// gets(str);
	// fgets(str, sizeof(str), stdin); 
	
	printf("�� �濡 ��� : %c, %d, %lf, %s\n", a, b, c, str);

	return 0;
	
} 
