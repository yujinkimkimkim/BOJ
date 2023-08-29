package baekjoon;

import java.util.*;
import java.io.*;

public class b1355 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int lc = Integer.parseInt(st.nextToken());
		int lh = Integer.parseInt(st.nextToken());
		int cake[][] = new int[lc*4][lc*4];
		
		for(int i = 0 ; i < lc*4 ; i++)
			Arrays.fill(cake[i], 1);
		
		int h = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < h ; i++) {
			int tmp = -Integer.parseInt(st.nextToken())*2+lc*2;
			for(int j = 0 ; j < lc*4 ; j++) {
				cake[tmp-1][j] = 0;
			}
		}
		
		int v = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < v; i++) {
			int tmp = -Integer.parseInt(st.nextToken())*2+lc*2;
			for(int j = 0 ; j < lc*4 ;j++) {
				cake[j][tmp-1] = 0;
			}
		}
		
		int tmp1 = lc - lh;
		int tmp2 = lc + lh;
		for(int i = tmp1*2 ; i < tmp2*2 ;i++) {
			for(int j = tmp1*2 ; j < tmp2*2 ;j++) {
				cake[i][j] = 0;
			}
		}
		
		for(int i = 0 ; i < lc*4 ; i++) {
			for(int j = 0 ; j < lc*4 ; j++) {
				System.out.print(cake[i][j]);
			}
			System.out.println();
		}
		int ans = 0;
		for(int i = 0 ; i < lc*4 ; i++) {
			for(int j = 0 ; j < lc*4; j++) {
				if(cake[i][j]==1) {
					ans++;
					dfs(i,j,cake,lc);
				}
			}
		}
		
		bw.write(ans+"");
		bw.close();
	}
	public static void dfs(int row, int col, int[][] a, int lc) {
		int dirX[] = {-1,-1,-1,1,1,1,0,0};
		int dirY[] = {-1,1,0,1,-1,0,-1,1};
		
		for(int i = 0 ; i < 8 ; i++) {
			int nx = col + dirX[i];
			int ny = row + dirY[i];
			if(nx >= 0 && nx < lc*4 && ny >= 0 && ny < lc*4) {
				if(a[ny][nx] == 1) {
					a[ny][nx] = 0;
					dfs(ny, nx, a, lc);
				}
			}
		}
	}
}
