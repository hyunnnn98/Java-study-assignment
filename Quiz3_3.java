package school_Project;

import java.util.Scanner;

public class Quiz3_3 {
	public static void main(String[] args) {
		int input_Value = 0;
		String Grade	= " ";
		
		Scanner scan = new Scanner(System.in);
		System.out.print("������ �Է��ϼ���:");
		input_Value = scan.nextInt();
		
		if(input_Value >= 95) {
			Grade = "A+";
		}else if(input_Value >= 90) {
			Grade = "A";
		}else if(input_Value >= 85) {
			Grade = "B+";
		}else if(input_Value >= 80) {
			Grade = "B";
		}else if(input_Value >= 75) {
			Grade = "C+";
		}else if(input_Value >= 70) {
			Grade = "C";
		}else if(input_Value >= 65) {
			Grade = "D+";
		}else if(input_Value >= 60) {
			Grade = "D";
		}else {
			Grade = "F";
		}
		
		if(input_Value >= 60) {
			System.out.printf("�����մϴ�. %s �Դϴ�", Grade);
		}else {
			System.out.printf("�����մϴ�. %s �Դϴ� ^^;", Grade);
		}
		
		scan.close();
	}
}
