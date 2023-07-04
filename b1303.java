package baekjoon;
import java.util.*;
import java.io.*;

public class b1303 {
	static int n, m;
	static char arr[][];
	static boolean visited[][];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new char[n][m];
		visited = new boolean[n][m];
		for(int i = 0 ; i < n ; i++)
		{
			arr[i] = br.readLine().toCharArray();
		}
		int W = 0, B = 0;
		for(int i = 0 ; i < n ; i++)
		{
			for(int j = 0 ; j < m ; j++)
			{
				if (visited[i][j] != true) 
				{
                    int count = dfs(i, j, arr[i][j]);
                    if (arr[i][j] == 'W') 
                    {
                        W += count * count;
                    } 
                    else 
                    {
                        B += count * count;
                    }
                }
			}
		}
		bw.write(W+" "+B);
		bw.close();
		
	}
	public static int dfs(int x, int y, char target)
	{
		visited[x][y] = true;
		int dirX[] = {-1, 1, 0, 0};
		int dirY[] = {0, 0, -1, 1};
		
		int cnt = 1;
		for(int i = 0 ; i < 4 ; i++)
		{
			int nx = x + dirX[i];
			int ny = y + dirY[i];
			if(nx < 0 || nx >= n || ny < 0 || ny >= m)
				continue;
			if(visited[nx][ny] != true && arr[nx][ny] == target)
			{
				visited[nx][ny] = true;
				cnt += dfs(nx, ny, target);
			}
		}
		return cnt;
	}
}
