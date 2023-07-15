package baekjoon;
import java.util.*;
import java.io.*;

public class b6198 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int sum = 0;
		Stack <Integer> s = new Stack<>();
		
		for(int i = 0 ; i < n ; i++)
		{
			int num = Integer.parseInt(br.readLine());

			while(!s.isEmpty() && s.peek() <= num)
			{
				s.pop();
			}
			s.push(num);
			sum += s.size() - 1;
		}
		bw.write(sum+"");
		bw.close();
	}

}
