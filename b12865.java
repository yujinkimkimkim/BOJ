package baekjoon;
import java.util.*;
import java.io.*;

public class b12865 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int arr[][] = new int[n+1][2];
		for(int i = 1 ; i <= n ; i++)
		{
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int dp[][] = new int[n+1][k+1];
		for(int i = 0 ; i < n ; i++)
		{
			for(int j = 1 ; j <= k ; j++)
			{
				if(arr[i][0] <= j)
					dp[i+1][j] = Math.max(arr[i][1]+dp[i][j-arr[i][0]], dp[i][j]);
				else
					dp[i+1][j] = dp[i][j];
			}
		}
		for(int i = 1 ; i <= n ; i++)
		{
			for(int j = 1 ; j <= k ;j++)
				System.out.print(dp[i][j]);
			System.out.println();
		}
		bw.write(dp[n][k]+"");
		bw.close();
	}

}
