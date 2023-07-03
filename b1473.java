package baekjoon;
import java.util.*;
import java.io.*;

public class b1473 {
	static int arr[][];
	static int n;
	static int m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		
		arr = new int[n+1][m+1];
		
		for(int i = 0 ; i < k ; i++)
		{
			st = new StringTokenizer(br.readLine());
			arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		}
		int max = 0;
		for(int i = 1 ; i <= n ; i++)
		{
			for(int j = 1 ; j <= m ; j++)
			{
				if(arr[i][j]!=1)
					continue;
				
				max = Math.max(bfs(i,j), max); 
			}
		}
		bw.write(max+"");
		bw.close();
	}
	public static int bfs(int x, int y)
	{
		int cnt = 1;
		int dirX[] = {-1, 1, 0 ,0};
		int dirY[] = {0, 0, -1, 1};
		
		Queue <Integer> queueX = new LinkedList<>();
		Queue <Integer> queueY = new LinkedList<>();
		queueX.offer(x);
		queueY.offer(y);
		
		int curX, curY;
		arr[x][y] = 0;
		
		while(!queueX.isEmpty() && !queueY.isEmpty())
		{
			curX = queueX.poll();
			curY = queueY.poll();
			for(int i = 0 ; i < 4 ; i++)
			{
				int preX = curX + dirX[i];
				int preY = curY + dirY[i];
				if(preX <= 0 || preX > n || preY <= 0 || preY > m)
					continue;
				if(arr[preX][preY] == 1)
				{
					cnt++;
					arr[preX][preY] = 0;
					queueX.offer(preX);
					queueY.offer(preY);
				}
			}
		}
		return cnt;
	}
}
