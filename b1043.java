package baekjoon;
import java.util.*;
import java.io.*;

public class b1043 {
	static int parent[];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		parent = new int[n+1];
		int M = Integer.parseInt(st.nextToken()); 	
		
		List<Integer>[] p = new ArrayList[n];
		
		for (int i = 0; i < n; i++) {
		    p[i] = new ArrayList<Integer>();
		}

		for(int i = 1 ; i <= n ; i++)
		{
			parent[i] = i;
		}
		
		boolean check[] = new boolean[n+1];
		st = new StringTokenizer(br.readLine());
		int temp = Integer.parseInt(st.nextToken());
		for(int i = 0 ; i < temp ; i++)
		{
			check[Integer.parseInt(st.nextToken())] = true;
		}
		
		
		for (int i = 1; i <= M; i++) { // party number

            String inputs[] = br.readLine().split(" ");
            int party_num = Integer.parseInt(inputs[0]);

            if(party_num<=1) {
                p[i].add(Integer.parseInt(inputs[1]));
                continue;
            }

            for (int j = 1; j < party_num; j++) { 
                int a = Integer.parseInt(inputs[j]);
                int b = Integer.parseInt(inputs[j+1]);
                if (Find(a) != Find(b)) {
                    Union(a,b);
                }

                p[i].add(a);
                p[i].add(b);
            }
        }

        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if(check[i] && visited[i] != true){
                int root = Find(i);
                for (int j = 1; j <= n; j++){
                    if (Find(j)==root) {
                        check[j] = true;
                        visited[j] = true;
                    }
                }
            }
        }
        
        int cnt = 0;
        for (int i = 1; i <= M; i++) { 
            boolean flag = false;
            for (int person : p[i]) { 
                if(check[person]){
                    flag = true;
                    break;
                }
            }
            if(!flag) cnt++;
        }
        bw.write(cnt+"");
        bw.close();
	}
	static public int Find(int a)
	{
		if (a == parent[a])
			return a;
		return parent[a] = Find(parent[a]);
	}

	public static void Union(int a, int b)
	{
		int pa = Find(a), pb = Find(b);
		parent[pa] = pb;
	}
}
