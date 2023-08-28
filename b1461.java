package baekjoon;

import java.util.*;
import java.io.*;

public class b1461 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((p1, p2) -> p2 - p1);
        PriorityQueue<Integer> nq = new PriorityQueue<>((p1, p2) -> p2 - p1);
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if(tmp < 0)
				nq.offer(Math.abs(tmp));
			else
				pq.offer(tmp);
		}
		
		int maxNum = 0;
        if (pq.isEmpty()) {
        	maxNum = nq.peek();
        } else if (nq.isEmpty()) {
        	maxNum = pq.peek();
        } else {
        	maxNum = Math.max(pq.peek(), nq.peek());
        }
        
        int ans = cal(pq, m);
        ans += cal(nq, m);
        ans -= maxNum;
        bw.write(ans + "");
        bw.close();
	}
	public static int cal(PriorityQueue<Integer> q, int m) {
		int ans = 0;

        while (!q.isEmpty()) {
            int tmp = q.poll();
            for (int i = 0; i < m - 1; i++) {
                q.poll();

                if (q.isEmpty()) {
                    break;
                }
            }
            ans += tmp * 2;
        }
        return ans;
	}
}
