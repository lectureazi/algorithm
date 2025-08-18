package b_math;

public class BitwiseExamples {
    public static void main(String[] args) {
        
        // 1. 비트 AND (&) 연산
        // 두 비트가 모두 1일 때만 결과가 1
        int a = 12; // 0000 1100 (2진수)
        int b = 25; // 0001 1001 (2진수)
        int resultAnd = a & b;
        System.out.println("--- 1. AND (&) 연산 ---");
        System.out.printf("a (%d): %s\n", a, Integer.toBinaryString(a));
        System.out.printf("b (%d): %s\n", b, Integer.toBinaryString(b));
        // 0000 1100
        //&0001 1001
        //-----------
        // 0000 1000 => 8
        System.out.printf("a & b = %d\n", resultAnd);
        System.out.println();
        
        // 2. 비트 OR (|) 연산
        // 두 비트 중 하나라도 1일 때 결과가 1
        int resultOr = a | b;
        System.out.println("--- 2. OR (|) 연산 ---");
        System.out.printf("a (%d): %s\n", a, Integer.toBinaryString(a));
        System.out.printf("b (%d): %s\n", b, Integer.toBinaryString(b));
        // 0000 1100
        //|0001 1001
        //-----------
        // 0001 1101 => 29
        System.out.printf("a | b = %d\n", resultOr);
        System.out.println();
        
        // 3. 비트 XOR (^) 연산
        // 두 명제의 진리값이 다를 때만 참이 되는 논리 연산자
        // 두 비트가 서로 다를 때만 결과가 1
        int resultXor = a ^ b;
        System.out.println("--- 3. XOR (^) 연산 ---");
        System.out.printf("a (%d): %s\n", a, Integer.toBinaryString(a));
        System.out.printf("b (%d): %s\n", b, Integer.toBinaryString(b));
        // 0000 1100
        //^0001 1001
        //-----------
        // 0001 0101 => 21
        System.out.printf("a ^ b = %d\n", resultXor);
        System.out.println();
        
        // 4. 비트 NOT (~) 연산
        // 비트를 반전시킴.
        // 자바에서 정수는 4바이트(32비트)로 표현되므로, 결과가 음수가 됩니다.
        // ~12는 -13이 됨 (2의 보수법)
        // 2의 보수(진법 보수)는 1의 보수(n-1의 보수) + 1
        // 진법 보수 : 원래 수에 더했을 때 다음 자릿수로 올림(carry)이 발생하는 가장 작은 수
        // n-1의 보수 : 각 자릿수를 진법의 최댓값(n−1)으로 만드는 것
        // 컴퓨터는 표현범위를 벗어난 값은 무시한다. 따라서 올림을 무시한 나머지 값이 나옴
        int resultNot = ~a;
        System.out.println("--- 4. NOT (~) 연산 ---");
        System.out.printf("a (%d): %s\n", a, Integer.toBinaryString(a));
        // ...0000 1100
        //~
        // ...1111 0011 => Not 연산
        // ...0000 1100 => 부호비트가 1임으로 값을 반환하기 위해 1의 보수를 구함
        // ...0000 1101 => 1의 보수 + 1 => 음수 13 =>
        System.out.printf("~a = %d\n", resultNot);
        System.out.println();
        
        // 5. 비트 시프트 연산
        int num = 10; // 0000 1010
        
        // 왼쪽 시프트 (<< n)
        // num을 2의 n제곱으로 곱한 것과 같음
        int leftShift = num << 1;
        System.out.println("--- 5. 비트 시프트 연산 ---");
        System.out.printf("num (%d): %s\n", num, Integer.toBinaryString(num));
        // 0000 1010 << 1 => 0001 0100 (20)
        System.out.printf("num << 1 = %d\n", leftShift);
        
        // 부호 있는 오른쪽 시프트 (>> n)
        // num을 2의 n제곱으로 나눈 것과 같음. 부호 비트 유지
        int signedRightShift = num >> 1;
        // 0000 1010 >> 1 => 0000 0101 (5)
        System.out.printf("num >> 1 = %d\n", signedRightShift);
        
        // 부호 없는 오른쪽 시프트 (>>> n)
        // 부호에 관계없이 왼쪽을 0으로 n개 채움. 주로 음수에서 사용
        int negativeNum = -10; // 1111 1111 ... 1111 0110
        int unsignedRightShift = negativeNum >>> 2;
        System.out.printf("negativeNum (%d): %s\n", negativeNum, Integer.toBinaryString(negativeNum));
        // 1111...11110110 >>> 1 => 0111...11111011 (큰 양수)
        System.out.printf("negativeNum >>> 1 = %d\n", unsignedRightShift);
    }
}
