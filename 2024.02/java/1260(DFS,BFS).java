package s240213_coin;

import java.io.*;
import java.util.*;
/*
 * 1. 사용자로부터 정점, 간선의 수와 시작 정점을 입력받는다.
 * 2. 간선들을 입력받으며 각 정점과 연결된 정점들을 배열화 한다.
 * 3. 정점들을 sort하여 순서를 맞춘다.
 * 4. 재귀와 방문 체크를 통해 dfs를 진행하고 string builder에 업데이트.
 * 5. queue를 이용해 너비 우선 탐색을 진행하고 string builder에 업데이트.
 * 6. string builder 출력
 * 
 */
public class b1260_DFS와BFS_김상우 {
	static int[][] graph = new int[1001][1001];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int nodeNum, lineNum, startPoint, firstNode, secondNode;
	static boolean [] visited;
	//4. 재귀와 방문 체크를 통해 dfs를 진행하고 
	public static void dfs(int curNode) {
		//string builder에 업데이트.
		sb.append(curNode+" ");
		visited[curNode-1] = true;
		for(int idx=1001-graph[0][curNode-1];idx<1001;idx++) {
			//방문 안한 원소에 대해 재귀 실행
			if(!visited[graph[curNode][idx]-1]) {
				dfs(graph[curNode][idx]);
			}
		}
	}
	//5. queue를 이용해 너비 우선 탐색을 진행하고 string builder에 업데이트.
	public static void bfs(int curNode) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(curNode);
		visited[curNode-1] = false;
		while(!queue.isEmpty()) {
			curNode = queue.poll();
			//0이 아닌 범위 내에서 탐색
			for(int idx=1001-graph[0][curNode-1];idx<1001;idx++) {
				//방문 한 원소에 대해서만 실행
				if(visited[graph[curNode][idx]-1]) {
					//queue를 통해 너비 우선 탐색
					queue.add(graph[curNode][idx]);
					visited[graph[curNode][idx]-1] = false;
				}
			}
			sb.append(curNode).append(" ");
		}
	}
	public static void main(String[] args) throws IOException{
		//1. 사용자로부터 정점, 간선의 수와 시작 정점을 입력받는다.
		String [] firstInput = br.readLine().trim().split(" ");
		nodeNum = Integer.parseInt(firstInput[0]);
		lineNum = Integer.parseInt(firstInput[1]);
		startPoint = Integer.parseInt(firstInput[2]);
		//2. 간선들을 입력받으며 각 정점과 연결된 정점들을 배열화 한다.
		for(int idx=0;idx<lineNum;idx++) {
			firstInput = br.readLine().trim().split(" ");
			firstNode = Integer.parseInt(firstInput[0]);
			secondNode = Integer.parseInt(firstInput[1]);

			graph[firstNode][graph[0][firstNode-1]++] = secondNode;
			graph[secondNode][graph[0][secondNode-1]++] = firstNode;
		}
		
		visited = new boolean [nodeNum];
		//3. 정점들을 sort하여 순서를 맞춘다.
		for(int idx=1;idx <= nodeNum;idx++) {
			Arrays.sort(graph[idx]);
		}
		//4. 재귀와 방문 체크를 통해 dfs를 진행하고 string builder에 업데이트.
		dfs(startPoint);
		sb.append("\n");
		//5. queue를 이용해 너비 우선 탐색을 진행하고 string builder에 업데이트.
		bfs(startPoint);
		//6. string builder 출력
		System.out.println(sb);
	}

}
