package school_Project;

import java.util.Scanner;

public class school_2_Example003 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("��ռӵ��� �Է��ϼ���!");
		int speed = scan.nextInt();
		System.out.println("������ �Ÿ��� �Է��ϼ���!");
		int distance = scan.nextInt();
		
		double time = ((double)distance / speed);
		
		System.out.printf("����ð�: %.4f", time);
		
		scan.close();
	}
}
