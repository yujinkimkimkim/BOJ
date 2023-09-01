package baekjoon;

import java.util.*;
import java.io.*;

public class b16724 {
	static boolean visited[][];
	static boolean finished[][];
	static int ans = 0;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][m];
		visited = new boolean[n][m];
		finished = new boolean[n][m];
		ans = 0;
		for(int i = 0 ; i < n; i++) {
			String tmp = br.readLine();
			for(int j = 0 ; j < m ; j++) {
				if(tmp.charAt(j)=='U')
					arr[i][j] = 0;
				else if(tmp.charAt(j)=='D')
					arr[i][j] = 1;
				else if(tmp.charAt(j)=='L')
					arr[i][j] =2;
				else
					arr[i][j] = 3;
			}
		}
		
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ;j++) {
				if(!visited[i][j])
					dfs(i,j, arr);
			}
		}
		bw.write(ans+"");
		bw.close();
	}
	public static void dfs(int row, int col, int[][] arr) {
		int dirY[] = {-1,1,0,0};
		int dirX[] = {0,0,-1,1};
		
		visited[row][col] = true;
		int nx = col + dirX[arr[row][col]];
		int ny = row + dirY[arr[row][col]];

		
		if(!visited[ny][nx])
			dfs(ny, nx, arr);
		else {
			if(!finished[ny][nx])
				ans++;
		}
		finished[row][col] = true;
	}
}
