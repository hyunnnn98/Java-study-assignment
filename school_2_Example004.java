package school_Project;

import java.util.Scanner;

public class school_2_Example004 {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		
		System.out.println("x ���� �Է��Ͻÿ�!!");
		int input_X = scan.nextInt();
		
		int result  = 3 * (int)(Math.pow(input_X, 5)) + 7 * input_X + 11;
		
		System.out.println("�����:" + result +"�Դϴ�.");
	}
}
