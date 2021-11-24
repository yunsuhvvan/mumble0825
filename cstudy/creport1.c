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

	printf("학생 3명의 정보를 입력하세요.\n");

	for (i = len; i < len + 1; i++)
	{
		printf("이름: ");
		scanf("%[^\n]s", std[i].name);
		do {
			printf("국어: ");
			scanf("%d", &std[i].kor);
			if (std[i].kor < 0 || std[i].kor > 100)
			{
				printf("입력 오류 성적을 재입력하세요.\n");
			}
		} while (std[i].kor < 0 || std[i].kor > 100);

		do {
			printf("영어: ");
			scanf("%d", &std[i].eng);
			if (std[i].eng < 0 || std[i].eng > 100)
			{
				printf("입력 오류 성적을 재입력하세요.\n");
			}
		} while (std[i].eng < 0 || std[i].eng > 100);

		do {
			printf("수학: ");
			scanf("%d", &std[i].math);
			if (std[i].math < 0 || std[i].math > 100)
			{
				printf("입력 오류 성적을 재입력하세요.\n");
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

	fprintf(f, "이름 : %s, 국어 : %d점, 수학 : %d점, 영어 : %d점 , 평균 : %1lf 점\n" , name , kor, eng, math ,avg);
	
	fclose(f);
	 
		
	}
int main(){
	
	inputInformation();
	generateFile();
	
	return 0;
}
