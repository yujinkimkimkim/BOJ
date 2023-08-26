package baekjoon;

import java.util.*;
import java.io.*;

public class b7453 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int A[] = new int[n];
		int B[] = new int[n];
		int C[] = new int[n];
		int D[] = new int[n];
		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			A[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
			D[i] = Integer.parseInt(st.nextToken());
		}
		
		int AB[] = new int[n*n];
		int CD[] = new int[n*n];
		
		int idx = 0;
		for(int i = 0 ; i < n; i++) {
			for(int j = 0 ; j < n ; j++) {
				AB[idx] = A[i] + B[j];
				CD[idx++] = C[i] + D[j];
			}
		}
		Arrays.sort(AB);
		Arrays.sort(CD);
		
		long ans = 0;
		int left = 0;
		int right = n*n-1;

		while(left < n*n && right >= 0) {
			int tmp = AB[left] + CD[right];
			if(tmp < 0) {
				left++;
			} else if(tmp > 0) {
				right--;
			} else {
				long leftCnt = 1;
				long rightCnt = 1;
				while(left+1 < n*n && AB[left]==AB[left+1]) {
					left++;
					leftCnt++;
				}
				while(right-1 >= 0 && CD[right]==CD[right-1]) {
					right--;
					rightCnt++;
				}
				ans += leftCnt*rightCnt;
				right--;
			}
		}
		bw.write(ans+"");
		bw.close();
	}

}
