package school_Project;

import java.util.Scanner;

public class School_Gugudan_Example {
	public static void main(String[] args) {
		// start() �޼��带 ȣ���ϱ����� �ν��Ͻ�ȭ ��.
		School_Gugudan_Example Gugudan = new School_Gugudan_Example();

		//����ڰ� �����ϱ� ������ ���α׷� ���� �ݺ�
		while(true) {
			Gugudan.start();
		}
	}

	void start() {
		System.out.println("---------------------\n"
					 	+ "1 . ������ ���\n"
						+ "2 . ���α׷� ����\n"
						+ "---------------------");
		// �޴� �������� �̵�
		menu_Select();
	}

	void menu_Select( ) {
		// ����ڷκ��� �޴����� ���ڸ� �Է¹���
		Scanner scan_Menu	 = new Scanner(System.in);
		int input_MenuSelect = scan_Menu.nextInt();

		if(input_MenuSelect == 1) {
			// ������ ���� �޼���� �̵�
			Dan_Select();
		}else if(input_MenuSelect == 2) {
			System.out.println("�̿����ּż� �����մϴ�.");
			System.exit(0);
		}else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���.");
			// �߸� �Է½� start()�޼��� ��ȣ��
			start();
		}
	}

	void Dan_Select() {
		System.out.println("����� �������� ���� �Է��ϼ���. �������� 2~9 ���� �Է�");
		// ����ڷκ��� ����� ���� ���ڸ� �Է¹���
		Scanner scan_Dan  = new Scanner(System.in);
		int input_Dan	  = scan_Dan.nextInt();

		if(1 < input_Dan && input_Dan < 10) {
			for(int dan = 1; dan < 10; dan++) {
				System.out.println(input_Dan + " X " + dan + " = " + input_Dan * dan);
			}
		}else {
			System.out.println("2~9������ ������ �Է����ּ���.");
			// ����Լ��� �̿��� 2~9�̿��� ������ �Է¹��� ��� Dan_Select()�޼��� ȣ��
			Dan_Select();
		}
	}
}
