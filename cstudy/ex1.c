#include<stdio.h>  // ǥ�� ����� ������� (ǥ�� ����� �Լ� ��� ���ؼ�)

// �� �ʿ��� �Լ� : main() �Լ�
int main() {
	
	// ����
	// 1. C�� String�� ����. char[] ����Ѵ�.
	// 2. ���� ������ �� �Լ� ���ۺο� �ִ´�. (�߰��� ������ �� ����.) 
	// 3. char ������ 1byte�̴�. �ѱ� ������ �Ұ����ϴ�. (Java�� 2byte) 
	
	char   a = 'T';
	int    b = 10;
	double c = 1.5;
	char str[6] = "hello";  // �ݵ�� �迭 ũ��� �ּ� �����Ϸ��� ���ڿ� ũ�� + 1 
	
	printf("����: %c\n", a);
	printf("����: %d\n", b);
	printf("�Ǽ�: %f\n", c);    // �Ҽ� 6�ڸ� , %f : float
	printf("�Ǽ�: %.1f\n", c);  // �Ҽ� 1�ڸ� 
	printf("�Ǽ�: %lf\n", c);   // �Ҽ� 6�ڸ� , %lf : long float -> double 
	printf("�Ǽ�: %.2lf\n", c); // �Ҽ� 2�ڸ� 
	printf("�Ǽ�: %g\n", c);
	
	printf("���ڿ�: %s\n", str);  // �迭�� �̸����� ��ü ���� ��� 
	
	return 0;  // ���� ���Ḧ �ǹ� (������ ���� return -1;)
	
}
