package baekjoon;

import java.util.*;
import java.io.*;

class node9 implements Comparable<node9>{
	int idx;
	int cost;
	int cnt;
	public node9(int idx, int cost, int cnt){
		// TODO Auto-generated constructor stub
		this.idx = idx;
		this.cost = cost;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(node9 o) {
		return cost - o.cost;
	}
}
public class b1162 {
	static int INF = Integer.MAX_VALUE;
	static ArrayList<ArrayList<node9>> graph;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<ArrayList<node9>>();
		
		for(int i = 0 ; i <= n+1 ; i++) {
			graph.add(new ArrayList<>());
		}
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph.get(start).add(new node9(end, cost,0));
			graph.get(end).add(new node9(start, cost,0));
		}
		
		bw.write(dijkstra(1,n,k)+"");
		bw.close();
	}
	static int dijkstra(int start, int end, int k)
	{
		PriorityQueue<node9> q = new PriorityQueue<>();
		int dist[][] = new int[end+1][end+1];
		for (int i = 0 ; i <= end ; i++)
			Arrays.fill(dist[i], INF);
		
		dist[start][0] = 0;
		
		q.offer(new node9(start, 0,0));
		
		while (!q.isEmpty()){
			node9 now = q.poll();
			if (dist[now.idx][now.cnt] < now.cost) 
				continue;

			for (node9 i : graph.get(now.idx)) {
				int temp = dist[now.idx][now.cnt] + i.cost;
				if (temp < dist[i.idx][now.cnt]) {
					dist[i.idx][now.cnt] = temp;
					q.offer(new node9(i.idx, temp, now.cnt));
				}
				
				if(now.cnt < k && dist[i.idx][now.cnt+1] > dist[now.idx][now.cnt]) {
					dist[i.idx][now.cnt+1] = dist[now.idx][now.cnt];
					q.offer(new node9(i.idx, dist[i.idx][now.cnt+1], now.cnt+1));
				}
			}
		}
		return Arrays.stream(dist[end]).min().getAsInt();

	}
}
