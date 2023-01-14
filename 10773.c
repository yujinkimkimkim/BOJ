#include <stdio.h>
#define MAX 100000
void pop(void);
void push(int data);

int arr[MAX], top = -1;

int main()
{
	int input, data, sum = 0;
	scanf_s("%d", &input);

	for (int i = 0; i < input; i++)
	{
		scanf_s("%d", &data);
		if (data != 0)
			push(data);
		else
			pop();
	}
	for (int i = 0; i <= top; i++)
		sum += arr[i];
	printf("%d", sum);
	return 0;
}

void pop(void)
{
	if (top < 0)
		return;
	arr[top--] = 0;
}

void push(int data)
{
	if (top == MAX - 1)
		return;
	arr[++top] = data;
}

/*
top를 -1로 시작하고 push하면 전위연산자로 해서
입력을 받았을 때 push 함수 호출 안 하면 top는 전 인덱스 값 유지하게 한 거랑
arr 인덱스 값 변수로 처리한 거 
*/