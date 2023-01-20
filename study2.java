package java1;
import java.util.*;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class study2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> arr = new ArrayList<>();
		int num;
		
		for(int i = 0 ; i < n ; i++)
		{
			num = Integer.parseInt(br.readLine());
			arr.add(num);
		}
		
		Collections.sort(arr);
		
		int cnt = 0;
		ArrayList<Integer> cntArr = new ArrayList<>();
		for(int i = 0 ; i < n ; i++)
		{
			cnt = 0;
			for(int j = arr.get(i); j < arr.get(i)+5 ; j++)
			{
				if(arr.contains(j))
					cnt++;
			}
			cntArr.add(cnt);
		}
		System.out.println(cntArr);
		System.out.println(5 - Collections.max(cntArr));
	}

}
