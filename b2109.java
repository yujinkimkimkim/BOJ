package baekjoon;
import java.util.*;
import java.io.*;

class node implements Comparable<node>
{
	int money;
	int time;
	
	public node(int money, int time)
	{
		this.money = money;
		this.time = time;
	}
	
	@Override
	public int compareTo(node n)
	{
		if(this.money < n.money)
			return 1;
		else if(this.money > n.money)
			return -1;
		else if(this.money == n.money && this.time < n.time)
			return 1;
		else if(this.money == n.money && this.time > n.time)
			return -1;
		else
			return 0;
	}
}
public class b2109 {
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		ArrayList <node> list = new ArrayList<node>(); // ArrayList √ ±‚»≠
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < n ; i++)
		{
			st = new StringTokenizer(br.readLine());
			list.add(new node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		Collections.sort(list);
		boolean check[] = new boolean[10001];
		int sum = 0;
		
		for(node i : list)
		{
			for (int j = i.time ; j >= 1; j--) {
				if (!check[j]) {
					check[j] = true;
					sum += i.money;
					break;
				}
			}
		}
		bw.write(sum+"");
		bw.close();
	}

}
