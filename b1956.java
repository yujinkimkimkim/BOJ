package baekjoon;
import java.io.*;
import java.util.*;

public class b1956 {
	static final int INF = 10000;
	static Queue <Integer> queue = new LinkedList<>();
	static boolean visited[];
	static int arr[][];
	static int v;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		arr = new int[v][v];
		visited = new boolean[v];
		for(int i = 0 ; i < v ; i++)
		{
			Arrays.fill(arr[i], INF);
		}
		for(int i = 0 ; i < v ; i++)
		{
			arr[i][i] = 0;
		}
		for(int i = 0 ; i < e ; i++)
		{
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken())-1;
			int col = Integer.parseInt(st.nextToken())-1;
			int cost = Integer.parseInt(st.nextToken());
			
			arr[row][col] = cost;
		}
		
		for(int i = 0 ; i < v ; i++)
		{
			for(int j = 0 ; j < v ; j++)
			{
				for(int k = 0 ; k < v 	; k++)
				{
					arr[j][k] = Math.min(arr[j][k], arr[j][i]+arr[i][k]);
				}
			}
		}

		int ans = INF;
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
				if(i == j)
					continue;
                if (arr[i][j] != INF && arr[j][i] != INF) {
                    ans = Math.min(ans, arr[i][j] + arr[j][i]);
                }
            }
        }
        ans = ans == INF ? -1 : ans;
        
		bw.write(ans+"");
		bw.close();
		
	}
}
