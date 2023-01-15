/*#include <stdio.h>

int arr[2187][2187];
int result[3] = { 0 };

void divide(int row, int col, int num);

int main()
{
	int input;
	scanf_s("%d", &input);

	int num;
	for (int i = 0; i < input; i++)
	{
		for (int j = 0; j < input; j++)
		{
			scanf_s("%d", &num);
			arr[i][j] = num;
		}
	}

	divide(0, 0, input);
	printf("\n\n%d\n%d\n%d", result[0], result[1], result[2]);

	return 0;
}

void divide(int row, int col, int num)
{
	int n = arr[row][col], cnt = 0;
	int size = num / 3;

	for (int i = 0; i < 3; i++)
	{
		for (int j = 0; j < 3; j++)
		{
			if (n != arr[i][j])
			{
				divide(row + size * i, col + size * j, size);
				cnt = 0;
			}
			else
			{
				cnt = 1;
			}
		}
	}
	if (n == 1)
		result[arr[row][col] + 1]++;

	result[arr[row][col] + 1] += cnt;
}*/
#include <stdio.h>

int arr[2187][2187];
int result[3] = { 0 };

int check(int col, int row, int num);
void divide(int row, int col, int num);

int main()
{
	int input;
	scanf_s("%d", &input);

	int num;
	for (int i = 0; i < input; i++)
	{
		for (int j = 0; j < input; j++)
		{
			scanf_s("%d", &num);
			arr[i][j] = num;
		}
	}

	divide(0, 0, input);
	printf("\n\n%d\n%d\n%d", result[0], result[1], result[2]);

	return 0;
}

int check(int row, int col, int num)
{
	int n = arr[row][col];

	for (int i = row; i < row + num; i++)
	{
		for (int j = col; j < col + num; j++)
		{
			if (n != arr[i][j])
			{
				return 0;
			}
		}
	}
	return 1;
}

void divide(int row, int col, int num)
{
	if (check(row, col, num))
		result[arr[row][col] + 1]++; //arr에 -1,0,1 중에 담겨있을건데 종이에 있을 숫자에 해당하는 인덱스값 1 더해주는 과정
	else
	{
		int size = num / 3;

		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				divide(row + size * i, col + size * j, size);
			}
		}
	}
}