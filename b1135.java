package baekjoon;

import java.util.*;
import java.io.*;



class Human implements Comparable<Human> {
    int time;
    int index;

    public Human(int time, int index) {
        this.time = time;
        this.index = index;
    }

    @Override
    public int compareTo(Human o) {
        return o.time - this.time;
    }
}
public class b1135 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine()), dp[] = new int[n];
		ArrayList<Integer> arr[] = new ArrayList[n];
		
		for(int i = 0 ; i < n ;i++) {
			arr[i] = new ArrayList<>();
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		st.nextToken();
		for(int i = 1 ; i < n ; i++) {
			arr[Integer.parseInt(st.nextToken())].add(i);
		}
		for (int i = n - 1; i >= 0; i--) {
            if(arr[i].size()==0) continue;

            PriorityQueue<Human> priorityQueue = new PriorityQueue<>();
            for (Integer integer : arr[i]) {
                priorityQueue.add(new Human(dp[integer], integer));
            }

            int t = 1;
            int max = 0;
            while (!priorityQueue.isEmpty()) {
                max = Math.max(priorityQueue.poll().time + t++, max); 
            }
            dp[i]=max;
        }
		bw.write(dp[0]+"");
		bw.close();
	}

}
