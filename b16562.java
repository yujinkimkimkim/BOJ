package baekjoon;
import java.util.*;
import java.io.*;

public class b16562 {
	static int arr[];
	static int friend[][];
	static boolean visited[];
	static int n;
	static Queue<Integer> queue = new LinkedList<>();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1];
		visited = new boolean[n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1 ; i <= n ; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		friend = new int[n+1][n+1];
		for(int i = 0 ; i < m ; i++)
		{
			st = new StringTokenizer(br.readLine());
			int tempX = Integer.parseInt(st.nextToken());
			int tempY = Integer.parseInt(st.nextToken());
			friend[tempX][tempY] = 1;
			friend[tempY][tempX] = 1;
		}
		int sum = 0;
		for(int i = 1 ; i <= n ; i++)
		{
			if(visited[i] != true)
			{
				sum += bfs(i);
			}
		}
		
		if(sum <= k)
			bw.write(sum+" ");
		else
			bw.write("Oh no");
		bw.close();
	}
	static int bfs(int x)
	{
		visited[x] = true;
		queue.offer(x);
		int fee = arr[x];
		while(!queue.isEmpty())
		{
			int cur = queue.poll();
			
			for(int i = 1 ; i <= n ; i++)
			{
				if(visited[i] != true && friend[cur][i] == 1)
				{
					visited[i] = true;
					queue.offer(i);
					fee = Math.min(fee, arr[i]);
				}
			}
		}
		return fee;
	}
}
