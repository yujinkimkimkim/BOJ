package baekjoon;

import java.util.*;
import java.io.*;

public class b2357 {
	static int minTree[];
	static int maxTree[];
	static int arr[];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1];
		minTree = new int[n*4];
		maxTree = new int[n*4];
		for(int i = 1 ; i <= n ;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		minInit(1,n,1);
		maxInit(1,n,1);
		for(int i = 0 ; i < m;i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			bw.write(findMin(1,n,1,left,right)+" "+findMax(1,n,1,left,right)+"\n");
		}
		bw.close();
		
	}
	
	public static int minInit(int s, int e, int n) {
		if(s == e)
			return minTree[n] = arr[s];
		
		int mid = (s + e)/2;
		return minTree[n] = Math.min(minInit(s, mid, n*2), minInit(mid+1, e, n*2+1));
	}
	
	public static int maxInit(int s, int e, int n) {
		if(s == e)
			return maxTree[n] = arr[s];
		
		int mid = (s + e)/2;
		return maxTree[n] = Math.max(maxInit(s, mid, n*2), maxInit(mid+1, e, n*2+1));
	}
	
	public static int findMin(int s, int e, int n, int left, int right) {
		if(right < s || left > e)
			return Integer.MAX_VALUE;
		
		if(left <= s && right >= e)
			return minTree[n];
		
		int mid = (s+e)/2;
		return Math.min(findMin(s, mid, n*2, left, right), findMin(mid+1, e, n*2+1, left, right));
	}
	
	public static int findMax(int s, int e, int n, int left, int right) {
		if(right < s || left > e)
			return Integer.MIN_VALUE;
		
		if(left <= s && right >= e)
			return maxTree[n];
		
		int mid = (s+e)/2;
		return Math.max(findMax(s, mid, n*2, left, right), findMax(mid+1, e, n*2+1, left, right));
	}
}
