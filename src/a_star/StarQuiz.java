package a_star;

import java.util.Iterator;
import java.util.Scanner;

public class StarQuiz {

	// 사용자로부터 입력받은 값을 높이로 가지는 직각삼각형을 그려봅시다.
	// *
	// **
	// ***
	// ****
	static void printTriangle() {
		Scanner sc = new Scanner(System.in);
		System.out.print("입력 : ");
		int input = sc.nextInt();

		for (int i = 0; i < input; i++) {
			for (int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}

			System.out.println();
		}
	}

	//	row : 5
	//	col : 5
	//	*****
	//	*****
	//	*****
	//	*****
	//	*****
	static void printRectangle() {
		Scanner sc = new Scanner(System.in);
		System.out.print("row: ");
		int row = sc.nextInt();
		
		System.out.print("col: ");
		int col = sc.nextInt();
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	}

	//	숫자 : 5
	//	1****
	//	*2***
	//	**3**
	//	***4*
	//	****5
	static void printNumberReactable() {
		Scanner sc = new Scanner(System.in);
		System.out.print("입력: ");
		int input = sc.nextInt();
		
		for (int i = 0; i < input; i++) {
			for (int j = 0; j < 5; j++) {
				if(i == j ) {
					System.out.print(i+1);
					continue;
				}
				System.out.print("*");
			}
			
			System.out.println();
		}
		
	}
	
	static void printDiamond() {
		Scanner sc = new Scanner(System.in);
		System.out.print("입력: ");
		int input = sc.nextInt();
		
		System.out.println("===========================");
		
		for (int i = 1; i < input + 1; i++) {
			
			for (int j = 0; j < input - i; j++) {
				System.out.print(" ");
			}
			
			for (int j = 0; j < 2 * i - 1; j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
		
		for (int i = 1; i < input; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			
			for (int j = 0; j < 2 * (input - i) - 1; j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
	
	static void printButterfly() {
		System.out.println("=============================");
		Scanner sc = new Scanner(System.in);
		System.out.print("입력: ");
		int input = sc.nextInt();
		
		for (int i = 1; i < input+1; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			
			for (int j = 0; j < 2 * (input - i); j++) {
				System.out.print(" ");
			}
			
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
		
		for (int i = 1; i < input; i++) {
			for (int j = 0; j < input - i; j++) {
				System.out.print("*");
			}
			
			for (int j = 0; j < 2 * i; j++) {
				System.out.print(" ");
			}
			
			for (int j = 0; j < input - i; j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
	

	public static void main(String[] args) {
		//printTriangle();
		//printRectangle();
		//printNumberReactable();
		printButterfly();
	}

}
