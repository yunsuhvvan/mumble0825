#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

typedef struct student
{
	char name[30];
	int kor, eng, math;
	double avg;

}Student;



Student std[20];
Student std_dest[20];
Student temp;
int len = 3;


void inputInformation(){
		int i=0;

	printf("�л� 3���� ������ �Է��ϼ���.\n");

	for (i = len; i < len + 1; i++)
	{
		printf("�̸�: ");
		scanf("%[^\n]s", std[i].name);
		do {
			printf("����: ");
			scanf("%d", &std[i].kor);
			if (std[i].kor < 0 || std[i].kor > 100)
			{
				printf("�Է� ���� ������ ���Է��ϼ���.\n");
			}
		} while (std[i].kor < 0 || std[i].kor > 100);

		do {
			printf("����: ");
			scanf("%d", &std[i].eng);
			if (std[i].eng < 0 || std[i].eng > 100)
			{
				printf("�Է� ���� ������ ���Է��ϼ���.\n");
			}
		} while (std[i].eng < 0 || std[i].eng > 100);

		do {
			printf("����: ");
			scanf("%d", &std[i].math);
			if (std[i].math < 0 || std[i].math > 100)
			{
				printf("�Է� ���� ������ ���Է��ϼ���.\n");
			}
		} while (std[i].math < 0 || std[i].math > 100);

		std[i].avg = (std[i].kor + std[i].eng + std[i].math) / 3;
		
		}
		++len;

	
	printf("\n\n");
	
	
}
	
	
	void generateFile(){
		
			
	char name[30];
	int kor, eng, math;
	double avg;
	
	FILE  * f = fopen("score.scv", "wt");
	
	if (f == NULL){
	
		fprintf(stderr, "file open error\n");
		return;
	}

	fprintf(f, "�̸� : %s, ���� : %d��, ���� : %d��, ���� : %d�� , ��� : %1lf ��\n" , name , kor, eng, math ,avg);
	
	fclose(f);
	 
		
	}
int main(){
	
	inputInformation();
	generateFile();
	
	return 0;
}
