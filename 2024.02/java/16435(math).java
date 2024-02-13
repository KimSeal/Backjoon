package s240213_coin;
import java.io.*;
import java.util.*;

/*
 * 1. 사용자로부터 열매의 수와 뱀의 길이를 입력받는다.
 * 2. 열매의 높이들을 입력받고 해당 값들을 더해준다.
 * 3. 뱀의 길이를 해당 높이의 열매 갯수만큼 더해주며 최대 길이를 구한다.
 * 4. 뱀의 길이를 출력한다.
 */
public class b16435_스네이크버드_김상우 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//1. 사용자로부터 열매의 수와 뱀의 길이를 입력받는다.
		String[] firstStr = br.readLine().trim().split(" ");
		int fruitNum = Integer.parseInt(firstStr[0]);
		int snakeLen = Integer.parseInt(firstStr[1]);
		//2. 열매의 높이들을 입력받고 해당 값들을 더해준다.
		firstStr = br.readLine().trim().split(" ");
		int[] fruitArr = new int [10001];
		for(int idx=0;idx<fruitNum;idx++) 
			fruitArr[Integer.parseInt(firstStr[idx])]++;
		//3. 뱀의 길이를 해당 높이의 열매 갯수만큼 더해주며 최대 길이를 구한다.
		for(int idx=1;idx<=10000;idx++) {
			if(snakeLen<idx) break;
			snakeLen += fruitArr[idx];
		}
		//4. 뱀의 길이를 출력한다.
		System.out.print(snakeLen);
	}
}
