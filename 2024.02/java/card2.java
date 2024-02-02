import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 1. 사용자로부터 숫자를 입력받는다.
 * 2. 입력을 인자로 갖는 버리고 시작하는 경우의 메소드을 실행하고 값을 리턴 후 출력.
 * 		2.1 버리고 시작하는 경우
 * 			2.1.1 인자가 짝수면 버리고 시작하는 경우의 절반에 해당하는 값의 2배를 return
 * 			2.1.2 인자가 홀수면 내리고 시작하는 경우의 (n-1)/2에 해당하는 값의 2배를 return
 * 		2.2 내리고 시작하는 경우
 * 			2.2.1 인자가 짝수면 내리고 시작하는 경우의 절반에 해당하는 값의 2배에서 1을 뺀 값을 return
 * 			2.2.2 인자가 홀수면 버리고 시작하는 경우의 (n+1)/2에 해당하는 값의 2배에서 1을 뺀 값을 return 
 * 
 */

public class card2 {
	//2.1 버리고 시작하는 경우
	// 			2.1.1 인자가 짝수면 버리고 시작하는 경우의 절반에 해당하는 값의 2배를 return
	//			2.1.2 인자가 홀수면 내리고 시작하는 경우의 (n-1)/2에 해당하는 값의 2배를 return
	static int recur0(int n){
		return (n % 2 == 0) ? (2 * recur0(n/2)) : (n==1) ? 1 : 2*recur1(n/2);
	}
	//2.2 내리고 시작하는 경우
	//	2.2.1 인자가 짝수면 내리고 시작하는 경우의 절반에 해당하는 값의 2배에서 1을 뺀 값을 return
	//	2.2.2 인자가 홀수면 버리고 시작하는 경우의 (n+1)/2에 해당하는 값의 2배에서 1을 뺀 값을 return 
	static int recur1(int n) {
		return (n % 2 == 0) ? 2*recur1(n/2)-1 : (n==1) ? 1 : 2*recur0((n+1)/2)-1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 1. 사용자로부터 숫자를 입력받는다.
		// 2. 입력을 인자로 갖는 버리고 시작하는 경우의 메소드을 실행하고 값을 리턴 후 출력.
		System.out.print(recur0(Integer.parseInt(br.readLine().trim())));
	}
}