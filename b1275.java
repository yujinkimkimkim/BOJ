package baekjoon;

import java.util.*;
import java.io.*;

public class b1275 {
	static long tree[];
	static long arr[];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		tree = new long[n*4];
		arr = new long[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1 ; i <= n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		init(1, n, 1);
		
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			long b = Integer.parseInt(st.nextToken());
			
			if(x > y)
				swap(x, y);
			sb.append(prefixSum(1, n, 1, x, y)+"\n");
			
			update(1, n, 1, a, b);
			arr[a] = b;
		}
		bw.write(sb.toString());
		bw.close();
	}
	public static long init(int s, int e, int n) {
		if(s == e)
			return tree[n] = arr[s];
		
		int mid = (s+e) / 2;
		return tree[n] = init(s, mid, n*2) + init(mid+1, e, n*2+1);
	}
	public static long prefixSum(int s, int e, int n, int l, int r) {
		if(e < l || r < s)
			return 0;
		if(l <= s && e <= r)
			return tree[n];
		int mid = (s+e)/2;
		return prefixSum(s, mid, n*2, l, r) + prefixSum(mid+1, e, n*2+1, l, r);
	}
	public static long update(int s, int e, int n, int idx, long val) {
		if(idx < s || idx > e)
			return 	tree[n];
		if(s == e)
			return tree[n] = val;
		
		int mid = (s+e)/2;
		return tree[n] = update(s, mid, n*2, idx, val) + update(mid+1, e, n*2+1, idx, val);
	}
	public static void swap(int a, int b) {
		int tmp = a;
		a = b;
		b = tmp;
	}
}
