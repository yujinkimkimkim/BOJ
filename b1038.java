package baekjoon;

import java.util.*;
import java.io.*;

public class b1038 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Long> arr = new ArrayList<>();

		if(n <= 10) {
			bw.write(n+"");
		} else if(n > 1022) {
			bw.write(-1+"");
		}else {
			for(int i = 0 ; i < 10; i++) {
				cal(arr,i,1);
			}
			Collections.sort(arr);
			bw.write(arr.get(n)+"");
		}
		bw.close();
	}
	public static void cal(ArrayList<Long> arr, long num, int len) {
		if(len > 10)
			return;
		arr.add(num);
		for(int i = 0 ; i < num % 10 ; i++) {
			cal(arr, (num * 10)+i, len+1);
		}
	}
}
