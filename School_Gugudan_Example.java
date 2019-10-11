package school_Project;

import java.util.Scanner;

public class School_Gugudan_Example {
	public static void main(String[] args) {
		// start() 메서드를 호출하기위해 인스턴스화 함.
		School_Gugudan_Example Gugudan = new School_Gugudan_Example();

		//사용자가 종료하기 전까지 프로그램 무한 반복
		while(true) {
			Gugudan.start();
		}
	}

	void start() {
		System.out.println("---------------------\n"
					 	+ "1 . 구구단 출력\n"
						+ "2 . 프로그램 종료\n"
						+ "---------------------");
		// 메뉴 선택으로 이동
		menu_Select();
	}

	void menu_Select( ) {
		// 사용자로부터 메뉴선택 숫자를 입력받음
		Scanner scan_Menu	 = new Scanner(System.in);
		int input_MenuSelect = scan_Menu.nextInt();

		if(input_MenuSelect == 1) {
			// 구구단 선택 메서드로 이동
			Dan_Select();
		}else if(input_MenuSelect == 2) {
			System.out.println("이용해주셔서 감사합니다.");
			System.exit(0);
		}else {
			System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
			// 잘못 입력시 start()메서드 재호출
			start();
		}
	}

	void Dan_Select() {
		System.out.println("출력할 구구단의 단을 입력하세요. 구구단은 2~9 사이 입력");
		// 사용자로부터 출력할 단의 숫자를 입력받음
		Scanner scan_Dan  = new Scanner(System.in);
		int input_Dan	  = scan_Dan.nextInt();

		if(1 < input_Dan && input_Dan < 10) {
			for(int dan = 1; dan < 10; dan++) {
				System.out.println(input_Dan + " X " + dan + " = " + input_Dan * dan);
			}
		}else {
			System.out.println("2~9사이의 정수를 입력해주세요.");
			// 재귀함수를 이용해 2~9이외의 정수를 입력받은 경우 Dan_Select()메서드 호출
			Dan_Select();
		}
	}
}
