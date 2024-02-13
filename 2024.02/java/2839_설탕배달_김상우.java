package s240213_coin;

import java.io.*;

/*
 * 1. 사용자로부터 설탕의 무게를 입력받는다.
 * 2. 5에 해당하는 포대를 사용할 수록 봉투가 적어지기에 5의 배수가 될때까지 3을 빼준다.
 * 3. 3과 5로 설탕의 무게를 충족할 수 없다면 -1를 출력한다.
 * 4. 사용한 작은 설탕 포대와 사용될 큰 설탕 포대의 수를 더해 출력한다.
 */


public class b2839_설탕배달_김상우 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int result = 0;
		//1. 사용자로부터 설탕의 무게를 입력받는다.
		int sugar = Integer.parseInt(br.readLine().trim());
		//2. 5에 해당하는 포대를 사용할 수록 봉투가 적어지기에 5의 배수가 될때까지 3을 빼준다.
		while(sugar % 5 != 0) {
			sugar -= 3;
			result ++;
			//3. 3과 5로 설탕의 무게를 충족할 수 없다면 -1를 출력한다.
			if(sugar<0) {System.out.print(-1);return;}
		}
		//4. 사용한 작은 설탕 포대와 사용될 큰 설탕 포대의 수를 더해 출력한다.
		System.out.print(result + sugar/5);
	}
}
