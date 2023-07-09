package baekjoon;
import java.util.*;
import java.io.*;

public class b11404 {
	static final int INF = 999999;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int arr[][] = new int[n][n];
		
		
		for(int i = 0 ; i < n ; i++)
		{
			Arrays.fill(arr[i], INF);
		}
		
		for(int i = 0 ; i < n ; i++)
		{
			arr[i][i] = 0;
		}
		
		StringTokenizer st;
		for(int i = 0 ; i < m ; i++)
		{
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken())-1;
			int col = Integer.parseInt(st.nextToken())-1;
			int cost = Integer.parseInt(st.nextToken());
			
			arr[row][col] = Math.min(arr[row][col], cost);
		}
		
		for(int i = 0 ; i < n ; i++)
		{
			for(int j = 0 ; j < n ; j++)
			{
				for(int k = 0 ; k < n ; k++)
				{
					arr[j][k] = Math.min(arr[j][k], arr[j][i]+arr[i][k]);
				}
			}
		}
		
		for(int i = 0 ; i < n; i++)
		{
			for(int j = 0 ; j < n ; j++)
			{
				if(arr[i][j] == INF)
					bw.write(0+" ");
				else
					bw.write(arr[i][j]+" ");
			}
			bw.write("\n");
		}
		bw.close();
	}

}
