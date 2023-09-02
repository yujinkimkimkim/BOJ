package baekjoon;

import java.util.*;
import java.io.*;

public class b2252 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int indegree[] = new int[n+1];
		
		ArrayList<Integer>list[] = new ArrayList[n+1];
		for(int i = 1; i <= n ;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			indegree[b]++;
		}
		
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1 ; i <= n ; i++) {
			if(indegree[i] == 0) {
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			bw.write(tmp+" ");

			for(int i = 0 ; i < list[tmp].size(); i++) {
				int next = list[tmp].get(i);
				indegree[next]--;
				
				if(indegree[next] == 0) {
					q.offer(next);
				}
			}
		}
		bw.close();
	}
	
}
