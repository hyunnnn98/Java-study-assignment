package school_Project;

import java.util.Scanner;

public class Quiz3_2 {
	public static void main(String[] args) {
		int Gender = 0;
		int Weight = 0;

		Scanner scan = new Scanner(System.in);
		do {
			System.out.print("������ �Է��ϼ���: <���� 1, ����2>:");
			Gender = scan.nextInt();

			switch(Gender) {
			case 1:
				System.out.print("ü���� �Է��ϼ���: ");
				Weight = scan.nextInt();
				if(Weight >= 85) {
					System.out.println("��ü���Դϴ� ��ϼ���.");
				}else if(50 <= Weight && Weight < 85) {
					System.out.println("ǥ��ü�� �Դϴ� �� ���̽��� �����ϼ���.");
				}else if(0 < Weight && Weight < 50) {
					System.out.println("ǥ��ü�� �����Դϴ� ���弼��.");
				}else {
					System.out.println("�߸��� �Է��Դϴ�.");
				}
				break;
			case 2:
				System.out.print("ü���� �Է��ϼ���: ");
				Weight = scan.nextInt();
				if(Weight >= 68) {
					System.out.println("��ü���Դϴ� ��ϼ���.");
				}else if(40 <= Weight && Weight < 68) {
					System.out.println("ǥ��ü�� �Դϴ� �� ���̽��� �����ϼ���.");
				}else if(0 < Weight && Weight < 40) {
					System.out.println("ǥ��ü�� �����Դϴ� ���弼��.");
				}else {
					System.out.println("�߸��� �Է��Դϴ�.");
				}
				break;
			default:
				System.out.println("�߸��� �Է��Դϴ�.");
				continue;
			}
		}while(Weight < 1);
		
		scan.close();
	}
}
