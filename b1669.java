package baekjoon;
import java.util.*;
import java.io.*;

public class b1669 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		m = d - m;
		int cnt = 0;
		d = 2;
		
		if(m <= 3)
		{
			System.out.println(m);
		}
		else
		{
			int num = (int)(Math.sqrt(m));
			if(m == Math.pow(num, 2))
				System.out.println(2 * num - 1);
			else if(m - Math.pow(num, 2) <= num)
				System.out.println(2 * num);
			else
				System.out.println(2 * num + 1);

		}
		
	}

}
