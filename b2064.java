package baekjoon;
import java.util.*;
import java.io.*;

public class b2064 {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		String a;
		StringBuilder temp = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            //temp.setLength(0);  // StringBuilder °´Ã¼ ÃÊ±âÈ­
			a = toStringbinary(br.readLine().split("\\."));
			for(int j = 0 ; j < 32 ; j++)
			{
				if (temp.length() <= j || temp.charAt(j) == ' ') 
				{
                    temp.append(a.charAt(j));
                } 
				else if (temp.charAt(j) != a.charAt(j)) 
				{
                    temp.setCharAt(j, '0');
                }
			}
		}
        
        boolean flag = false;
        
        String b = "";
        for(int i = 31 ; i >= 0 ; i--)
        {
        	if(temp.charAt(i) != '0' && flag == false)
        	{
        		b += "1";
        		flag = true;
        	}
        	if(flag)
        	{
        		b += "1";
        	}
        	else
        		b += "0";
        }

        a = "";
        for (int i = 0; i < 32; i += 8) {
            a += Integer.parseInt(temp.substring(i, i + 8), 2);
            if(i < 24)	
            	a += ".";
            
        }

        bw.write(a+"\n");
        a = "";
        StringBuffer sb = new StringBuffer(b);
        b = sb.reverse().toString();
        for (int i = 0; i < 32; i += 8) {
            a += Integer.parseInt(b.substring(i, i + 8), 2);
            if(i < 24)	
            	a += ".";
        }
    
		
        bw.write(a);
        bw.close();
		
	}
	public static String toStringbinary(String list[])
	{
		String a = "";
		
		for(int i = 0 ; i < 4 ; i++)
		{
			int n = Integer.parseInt(list[i]);
			String temp = Integer.toBinaryString(n);
			if(temp.length() < 8)
			{
				for(int j = 0 ; j < 8 - temp.length() ;j++)
					a += "0";
			}
			a += temp;
		}
		return a;
	}
}
