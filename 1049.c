#include <stdio.h>

int main()
{
	int min = 1000, N, M, package, one, temp;
	int minOne = 1000, minPackage = 1000;

	scanf_s("%d %d", &N, &M);

	for (int i = 0; i < M; i++)
	{
		scanf_s("%d %d", &package, &one);
		minOne = minOne <= one ? minOne : one;
		minPackage = minPackage <= package ? minPackage : package;
	}

	for (int i = 0; i < N / 6; i++)
	{
		temp = minPackage * i + minOne * (N - 6 * i);
		if (temp <= minPackage * ((N / 6) + 1))
			min = min < temp ? min : temp;
		else
			min = min < minPackage* ((N / 6) + 1) ? min : minPackage * ((N / 6) + 1);
	}

	printf("%d", min); 

	return 0;
}