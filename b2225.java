package baekjoon;
import java.util.*;
import java.io.*;

public class b2225 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int dp[][] = new int[k+1][n+1];

		for(int i = 1 ; i <= k ; i++)
		{
			for(int j = 1 ; j <= n ; j++)
			{
				if(i == 1)
				{
					dp[i][j] = 1;
				}
				else if(j == 1)
				{
					dp[i][j] = i;
				}
				else
				{
					dp[i][j] = dp[i-1][j] + dp[i][j-1];
				}
			}
		}
		System.out.println(dp[k][n] % 1000000000);
	}

}
