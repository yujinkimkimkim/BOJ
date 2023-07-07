package baekjoon;
import java.util.*;
import java.io.*;

public class b24391 {
	static int parent[];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		parent = new int[n+1];
		
		for(int i = 1 ; i <= n ;i++)
			parent[i] = i;
		
		for(int i = 0 ; i < m ; i++)
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			Union(a, b);
		}
		st = new StringTokenizer(br.readLine());
		int a[] = new int[n];
		for(int i = 0 ; i < n ; i++)
		{
			a[i] = Integer.parseInt(st.nextToken());
		}
		int cnt = 0;
		for(int i = 0 ; i < n-1 ; i++)
		{
			if(Find(a[i]) != Find(a[i + 1]))
				cnt++;
		}
		bw.write(cnt+"");
		bw.close();
	}
	static public int Find(int a)
	{
		if (a == parent[a])
			return a;
		return parent[a] = Find(parent[a]);
	}

	public static void Union(int a, int b)
	{
		int pa = Find(a), pb = Find(b);
		parent[pa] = pb;
	}
}
