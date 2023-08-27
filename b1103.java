package baekjoon;

import java.util.*;
import java.io.*;

public class b1103 {
    static int n, h, ans;
	static boolean flag;
	static int[][] dp;
	static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        int b[][] = new int[n][h];
        visited = new boolean[n][h];
        dp = new int[n][h];
        
        for (int i = 0; i < n; i++) {
            char arr[] = br.readLine().toCharArray();
            int idx = 0;
            for (char j : arr) {
                if (j == 'H') {
                    b[i][idx++] = 0;
                    continue;
                }
                b[i][idx++] = Character.getNumericValue(j);
            }
        }

        visited[0][0] = true;
		flag = false;
		dfs(0, 0, b, b[0][0], 1);

		if (flag) 
			bw.write(-1+"");
		else 
			bw.write(ans+"");
        bw.close();
    }

    public static void dfs(int row, int col, int[][] graph, int move, int cnt) {
    	if (cnt > ans)
    		ans = cnt;
		dp[row][col] = ans;
		
        int dirX[] = {0, 0, move, -move};
        int dirY[] = {move, -move, 0, 0};

        int tmp = 1;

        int originalValue = graph[row][col];
        graph[row][col] = -1;

        for (int i = 0; i < 4; i++) {
            int curY = row + dirY[i];
            int curX = col + dirX[i];
            if (curX >= 0 && curX < h && curY >= 0 && curY < n) {
            	if (visited[curY][curX]) {
    				flag = true;
    				return;
    			}
            	else if (graph[curY][curX] != 0 && dp[curY][curX] <= cnt) {
            		visited[curY][curX] = true;
                    dfs(curY, curX, graph, graph[curY][curX], cnt+1);
                    visited[curY][curX] = false;
                }
            }
        }
        
        graph[row][col] = originalValue;
    }
}
