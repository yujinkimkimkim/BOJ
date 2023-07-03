package baekjoon;
import java.io.*;
import java.util.*;

public class b2447 {
	static char[][] arr;
	 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
 
		arr = new char[N][N];
		for(int i = 0 ; i < N ; i++)
			Arrays.fill(arr[i], '*');
		
		for(int k = 0 ; k < Math.cbrt(N); k++)
		{   
			for(int i = 0 ; i < N ; i++)
			{
				for(int j = 0 ; j < N ; j++)
				{
				
				if((int)(i / Math.pow(3, k)) % 3== 1 && (int)(j / Math.pow(3, k)) % 3 == 1)
					arr[i][j] = ' ';					
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j]);
			}
			sb.append('\n');
		}
		System.out.print(sb);
		
		
	}
}
