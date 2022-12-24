#include <stdio.h>
#include <stdlib.h>

int main()
{
	int num = 0;
	int arr2[10000];

	scanf_s("%d", &num);
	int* arr = (int*)malloc(num * sizeof(int));

	for (int i = 0; i < num; i++)
	{
		scanf_s("%d", &arr[i]);
	}
	int idx = 0;
	for (int i = 0; i < num; i++)
	{
		if (arr[i] != 0)
		{
			arr2[idx] = arr[i];
			idx++;
		}
	}
	idx = 0;
	for (int i = 0; i < num; i++)
	{
		if (arr[i] == 0)
		{
			arr2[idx] = 0;
			idx--;
		}
		else
			idx++;
	}
	int sum = 0;
	for (int i = 0; i < idx; i++)
		sum += arr2[i];
	printf("%d", sum);
	return 0;
}