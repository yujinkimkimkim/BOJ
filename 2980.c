#include <stdio.h>

int main()
{
	int N, L, sum = 0, D, R, G, pre = 0;

	scanf_s("%d %d", &N, &L);

	for (int i = 0; i < N; i++)
	{
		scanf_s("%d %d %d", &D, &R, &G);

		sum += D - pre;
		pre = D;

		int num = sum % (R + G);
		if (num < R)
			sum += R - num;
	}
	sum += L - pre;
	printf("%d", sum);
	return 0;
}