package 유형별문제풀이.TopologicalSort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

/*
 * 
 * 문제번호가 앞자리 부터 난이도가 쉬움 -> 우선순위 큐로 작은 수 부터 담기
 * 
 @author Jeeyani
 */

public class BJ1766_문제집 {

	static int n, m;
	static List<Integer>[] list; //선행관계 
	static int[] problemList;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		list = new ArrayList[n + 1];
		problemList = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 1; i <= m; i++) {

			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list[a].add(b);
			problemList[b]++;

		}

		getTerm();
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static void getTerm() {
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();

		for (int i = 1; i <= n; i++) {
			if (problemList[i] == 0) {
				q.add(i);
			}
		}
		
		while (!q.isEmpty()) {
			int v = q.remove();
			sb.append(v+" ");
			
			for (int j = 0; j < list[v].size(); j++) {
				int next = list[v].get(j);
				problemList[next]--;
				
				if (problemList[next] == 0) {
					q.add(next);
				}
			}
			
		
		}
		
	}

}
