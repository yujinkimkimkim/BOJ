package baekjoon;
import java.util.*;
import java.io.*;

public class b5107 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 1 ; ; i++)
		{
			Map <String, String> arr = new HashMap();
			String startArr[] = new String[20];
			int cnt = 0;
			
			for(int j = 0 ; j < N ;j++)
			{
				st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				String b = st.nextToken();
				startArr[j] = a;
				arr.put(a, b);
			}
			
			String end;

			for(String start : startArr)
			{
				end = arr.get(start);
				while(true)
				{
					end = arr.get(end);
					if(end == null)
						break;
					else if(end.equals(start))
					{
						cnt++;
						//arr.values().remove(end);
						arr.keySet().remove(end);
						break;
					}
				}
			}
			System.out.println(i+" "+cnt);
			N = Integer.parseInt(br.readLine());
			if(N == 0)
				break;
		}
	}

}
