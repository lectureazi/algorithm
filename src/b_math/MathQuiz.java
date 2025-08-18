package b_math;

public class MathQuiz {
	
	public static void main(String[] args) {
//		System.out.printf("소수입니까? %s \n", isPrime2(11));
//		System.out.println(gcd2(12, 18));
//		System.out.println(lcm(12, 18));
//		System.out.println(factorial1(5));
		System.out.println(factorialRecursive(5));
		System.out.println(factorialTail(5, 1));
//		System.out.println(fiboRecursive(7));
	}
	
	// 소수 
	// 소수는 1과 자신으로만 나누어 떨어지는 수
	static boolean isPrime(int num) {
		
		if(num == 2) return true;
		if(num % 2 == 0) return false;
		
		for (int i = 3; i < num; i++) {
			if(num % i == 0) return false;
		}
		
		return true;
	}	
	
	// 약수 : 어떤 정수를 나누어 떨어지게 하는 수
	// n % m = 0
	// n / m = k
	// 약수의 특징 : 약수는 곱해서 어떤 정수가 되게끔하는 쌍이 반드시 존재한다. (제수, 몫)
	// ex) 12 => 1, 2, 3, 4, 6, 12
	// 12의 제곱근 : 3.xxxxxx
	// 제곱근 : 제곱해서 어떤 정수(n)이 되는 수
	// 약수의 쌍의 중간을 구하기 위해서는 제곱근을 구하면 된다.
	static boolean isPrime2(int num) {
		if(num < 2) return false;
		
		for (int i = 2; i <= Math.sqrt(num) ; i++) {
			if(num % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	static int gcd1(int a, int b) {
		// a : 12, b : 8
		int min = Math.min(a, b);
		
		for (int i = min; i > 0; i--) {
			if(a % i == 0 && b % i == 0) {
				return i;
			}
		}
		
		return 1;
	}
	
	// 유클리드 호제법을 이용한 최대공약수 구하기
	// a > b
	// G가 a와 b의 최대공약수 일때, a = MG, b = NG라 표현할 수 있다.
	// a와 b가 최대공약수 G를 가질 때 a를 b로 나눈 나머지는 G의 배수이다.
	
	// a mod b
	// a = bq + r ---------> q는 몫, r은 나머지
	
	// a는 MG, b는 NG로 표현할 수 있기 때문에
	
	// 	MG = NGq + r
	// 	r = MG - NGq
	// 	r = G(M - Nq) ----------> r은 G의 배수이다.
	
	// b : NG
	// r : PG
	
	// b mod r
	// b = rq + r2
	// NG = PGq + r2
	// r2 = G(Pq - N)
	
	// 나머지가 0이될때 까지 반복하면 (제수가 제수와 피제수의 (최대)공약수)
	// 최대공약수를 구할 수 있다.
	static int gcd2(int a, int b) {
		while(b > 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		
		return a;
	}
	
	// 최소공배수
	// G * (a/G) * (b/G)
	// a * b / G
	static int lcm(int a, int b) {
		int gcd = gcd2(a,b);
		return a * b / gcd;
	}
	
	static int factorialRecursive(int n) {
		if(n < 0) throw new IllegalArgumentException("n은 0보다 작을 수 없습니다.");
		if(n <= 1) {
			return 1;
		}
		
		// n! = n * n-1!
		// n == 5
		// 5 * fact(4) => 5 * 4 * 3 * 2 * 1
		//		4 * fact(3) => 4 * 3 * 2 * 1
		//			3 * fact(2) => 3 * 2 * 1
		//				2 * fact(1) => 2 * 1
		return n * factorialRecursive(n-1);
	}
	
	// 꼬리재귀함수
	// 반환부에 연산이 없는 재귀함수
	// 컴파일러가 내부에서 반복문으로 최적화를 해준다. / 자바는 안해준다.
	static int factorialTail(int n, int result) {
		if(n < 0) throw new IllegalArgumentException("n은 0보다 작을 수 없습니다.");
		if(n <= 1) {
			return 1;
		}
		
		result = n * result;
		
		// 5
		// 4 * (5)
		// 3 * (4 * 5)
		// 2 * (3 * 4 * 5)
		return factorialTail(--n, result);
	}
}
