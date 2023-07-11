package baekjoon;
import java.util.*;
import java.io.*;

class edge implements Comparable<edge>
{
	int start;
	int end;
	int cost;
	
	public edge(int start, int end, int cost)
	{
		this.start = start;
		this.end = end;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(edge obj)
	{
		return obj.cost >= this.cost ? -1 : 1;
	}
}
public class b1197 {
	static ArrayList <edge> list;
	static int[] parent;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		parent = new int [V+1];
		
		for(int i = 1 ; i <= V ; i++)
			parent[i] = i;
		
		list = new ArrayList<edge>(); // ArrayList √ ±‚»≠
		for(int i = 0 ; i < E ; i++)
		{
			st = new StringTokenizer(br.readLine());
			list.add(new edge(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		Collections.sort(list);
		
		int sum = 0;
		for(edge i : list)
		{
			if(union(i.start, i.end))
				sum += i.cost;
		}
		bw.write(sum+"");
		bw.close();
	}
	public static int find(int n)
	{
		if(parent[n] == n)
			return n;
		return parent[n] = find(parent[n]);
	}
	public static boolean union(int n, int m)
	{
		int nRoot = find(n);
		int mRoot = find(m);
		
		if(nRoot != mRoot)
		{
			parent[mRoot] = nRoot;
			return true;
		}
		else
			return false;
	}
}
