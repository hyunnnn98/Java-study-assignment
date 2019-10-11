package school_Project;

import java.util.Scanner;

public class school_2_Example003 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("평균속도를 입력하세요!");
		int speed = scan.nextInt();
		System.out.println("주행한 거리를 입력하세요!");
		int distance = scan.nextInt();
		
		double time = ((double)distance / speed);
		
		System.out.printf("주행시간: %.4f", time);
		
		scan.close();
	}
}
