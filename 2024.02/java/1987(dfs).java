package s240213_coin;

import java.util.*;
import java.io.*;

/*
 * 0. 사용자로부터 맵 크기와 알파벳 정보를 입력받는다.
 * 1. 타일 정보를 입력받는다.
 * 2. dfs함수를 호출한다.
 * 3. 깊이 우선 탐색을 통해 가장 깊은 모든 경우를 탐색하고 깊이가 가장 깊은 경우 업데이트 한다.
 * 4. 결과를 출력한다.
 */
public class b1987_알파벳_김상우{
	static boolean [] visited = new boolean [26];
	static int result =0;
	static int [][] alphaMap;
	static int col, row;
	//움직이는 방향
	static int [] dx = {0,1,0,-1};
	static int [] dy = {-1,0,1,0};
	//3. 깊이 우선 탐색을 통해 가장 깊은 모든 경우를 탐색하고 
	static void dfs(int curCol, int curRow, int count) {
		for(int idx=0;idx<4;idx++) {
			//이동 가능하고 아직 방문하지 않은 공간일 경우
			if(curCol+dy[idx] >=0 && curCol+dy[idx] <col &&
				curRow+dx[idx] >=0 && curRow+dx[idx] <row &&
				!visited[alphaMap[curCol+dy[idx]][curRow+dx[idx]]]) {
				//방문 확인 - dfs - 방문 해제
				visited[alphaMap[curCol+dy[idx]][curRow+dx[idx]]] = true;
				dfs(curCol+dy[idx], curRow+dx[idx], count+1);
				visited[alphaMap[curCol+dy[idx]][curRow+dx[idx]]] = false;
				
			}
		}
		//깊이가 가장 깊은 경우 업데이트 한다.
		result = (result > count) ? result : count;
	}
	public static void main(String[] args)  throws IOException{
		// 0. 사용자로부터 맵 크기와 알파벳 정보를 입력받는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] mapSize = br.readLine().trim().split(" ");
		col = Integer.parseInt(mapSize[0]);
		row = Integer.parseInt(mapSize[1]);
		alphaMap = new int[col][row];
		String inputLine;
		//1. 타일 정보를 입력받는다.
		for(int colIdx=0;colIdx<col;colIdx++) {
			inputLine = br.readLine().trim();
			for(int rowIdx =0;rowIdx<row;rowIdx++)
				//char를 int처럼 사용
				alphaMap[colIdx][rowIdx] = inputLine.charAt(rowIdx) - 'A';
		}
		visited[alphaMap[0][0]] = true;
		//2. dfs함수를 호출한다.
		dfs(0,0,1);
		//4. 결과를 출력한다.
		System.out.println(result);
	}

}
