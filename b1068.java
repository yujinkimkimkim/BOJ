package baekjoon;
import java.util.*;
import java.io.*;

public class b1068 {
	static int arr[];
	static int n;
	static boolean visited[];
	static int cnt = 0;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		visited = new boolean[n];
		
		int root = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++)
		{
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[i] == -1)
				root = i;
		}
		delete(Integer.parseInt(br.readLine()));
		cnt = 0;
		dfs(root);
		
		bw.write(cnt+"");
		bw.close();
		
	}
	static public void delete(int num)
	{
		arr[num] = -999;
		for(int i = 0 ; i < n ; i++)
		{
			if(arr[i] == num)
			{
				arr[i] = -999;
				delete(i);
			}
		}
	}
	static public void dfs(int start)
	{
		boolean check = true;
		visited[start] = true;
		
		for(int i = 0 ; i < n ; i++)
		{
			if(visited[i] != true && arr[i] == start)
			{
				check = false;
				dfs(i);
			}
		}
		
		if(check)
			cnt++;
	}
}
