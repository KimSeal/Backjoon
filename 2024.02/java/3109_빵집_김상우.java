package backjoon;

import java.util.*;
import java.io.*;

/*
 * 1. 사용자로부터 배열의 크기를 입력받는다.
 * 2. 배열의 내용을 채운다.
 * 3. 파이프라인의 최대 개수를 찾는 메소드를 실행한다.
 * 		3.1 좌측 상단부터 우측에 도달하는 DFS를 실행한다.
 * 			이때 우선순위는 우측 상단, 우측, 우측 하단 순으로 하여 최대한 위를 향한다.
 * 		3.2 최우측에 도달할 경우 지나온 곳에 대해 방문 처리를 유지한다.
 * 		3.3 도달시 결과에 1을 더한다.
 * 		3.4 모든 출발 지점에 대해 반복한다.
 * 4. 결과를 출력한다.
 */
public class b3109_빵집_김상우 {
	//가로 세로 길이.
	static int row, col;
	//입력을 위한 변수
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	//배열을 저장할 변수, 접촉 여부를 판단하는 변수
	static boolean stage[][], touch;
	static int result = 0;
	//3. 파이프라인의 최대 개수를 찾는 메소드를 실행한다.
	static void DFS(int curRow, int curCol) {
		if(curCol == col-1) {
			//3.2 최우측에 도달할 경우 지나온 곳에 대해 방문 처리를 유지한다.
			stage[curRow][curCol] = true;
			//3.3 도달시 결과에 1을 더한다.
			result++;
			touch = true;
			return;
		}
		//3.1 좌측 상단부터 우측에 도달하는 DFS를 실행한다.
		stage[curRow][curCol] = true;
		//이때 우선순위는 우측 상단, 우측, 우측 하단 순으로 하여 최대한 위를 향한다.
		for(int idx=-1;idx<2;idx++) {
			if(curRow+idx>=0 && curRow+idx<row && !stage[curRow+idx][curCol+1]) {
				DFS(curRow+idx,curCol+1);
				//3.2 최우측에 도달할 경우 지나온 곳에 대해 방문 처리를 유지한다.
				if(touch) return;
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		//1. 사용자로부터 배열의 크기를 입력받는다.
		String[] firstStr = br.readLine().trim().split(" ");
		row = Integer.parseInt(firstStr[0]);
		col = Integer.parseInt(firstStr[1]);
		String tempStr;
		//2. 배열의 내용을 채운다.
		stage = new boolean[row][col];
		for(int rowIdx=0;rowIdx<row;rowIdx++) {
			tempStr = br.readLine().trim();
			for(int colIdx=0;colIdx<col;colIdx++) {
				if(tempStr.charAt(colIdx)=='x') {
					stage[rowIdx][colIdx] = true;
				}
			}
		}
		
		//3. 파이프라인의 최대 개수를 찾는 메소드를 실행한다.
		//3.1 좌측 상단부터 우측에 도달하는 DFS를 실행한다.
		//3.4 모든 출발 지점에 대해 반복한다.
		for(int rowIdx = 0; rowIdx<row; rowIdx++) {
			touch = false;
			DFS(rowIdx,0);
		}
		//4. 결과를 출력한다.
		System.out.println(result);
	}
	
}
