package java1;
import java.util.*;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class study {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		for(int i = 0 ; i < n ; i++)
		{
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int t = (int)Math.round(n * 0.15);

		double sum = 0;
		for (int i = t; i < n-t ; i++)
		{
            sum += arr[i];
       }

		System.out.print((int)Math.round(sum / (n - 2 * t)));
		br.close();
	};
}
