package baekjoon;
import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class b1339 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		Integer alpha[] = new Integer[26];
		Arrays.fill(alpha, 0);
		
		for(int i = 0 ; i < n ; i++)
		{
			String temp = br.readLine();
			int num = (int)Math.pow(10, temp.length() - 1);
			
			for(int j = 0 ; j < temp.length() ; j++)
			{
				alpha[temp.charAt(j)-'A'] += num;
				num /= 10;
			}
		}
		
		Arrays.sort(alpha,  Collections.reverseOrder());
		n = 9;
		int sum = 0;
		for(int i : alpha)
		{
			if(i == 0)
				break;
			sum += i * n;
			n--;
		}
		
		bw.write(sum+"");
		bw.close();
	}

}
