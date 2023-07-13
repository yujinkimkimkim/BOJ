package baekjoon;
import java.util.*;
import java.io.*;

public class b12904 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String a = br.readLine();
		String b = br.readLine();
		
		StringBuffer newB = new StringBuffer(b);
		
		int interval = b.length() - a.length();
		
		for(int i = 0 ; i < interval ; i++)
		{
			if(newB.charAt(newB.length()-1) == 'A')
				newB = newB.deleteCharAt(newB.length()-1);
			else
			{
				newB = newB.deleteCharAt(newB.length()-1);
				newB = newB.reverse();			
			}
		}
		newB = newB.substring(2);
		b = newB.toString();
		if(b.equals(a))
			bw.write(1+"");
		else
			bw.write(0+"");
		bw.close();
	}

}
