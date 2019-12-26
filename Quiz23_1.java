package testPkg;

import java.util.Scanner;

public class Quiz23_1 {
	// id_Count �������� ����.
	static int id_Count = 0;

	public static void main(String[] args) {
		// �л� ������ �����ϱ� ���� 2���� �迭 ����
		double[][] grade = new double[5][8];

		System.out.println("----------------\n"
				+ "    �������� ���α׷�\n"
				+ "----------------\n"
				+ "1. �л� ���� �Է��ϱ�\n"
				+ "2. �л����� ó�� ��� ����ϱ�\n"
				+ "3. �������� �������� ����ϱ�\n"
				+ "4. ���м��� ���� �������� ����ϱ�\n");

		// �Ŵ� �����ϱ�
		Scanner scan = new Scanner(System.in);
		while(true) {
			scan = new Scanner(System.in);
			System.out.print("�޴��� �����ϼ��� :");
			int selectMenu = scan.nextInt();

			switch(selectMenu) {
			case 1 :
				input_Std_Number(scan, grade);
				break;
			case 2 :
				std_Grade_Table(grade);
				break;
			case 3 : 
			case 4 :
				std_Grade_Table(sorting_Rank(grade, 7, selectMenu));
				break;
			default :
				System.out.println("�Է°��� �����ϴ�");
				continue;
			}
		}
	}

	// �������� && �������� �޼���
	static double[][] sorting_Rank(double[][] grade, int idxNumber, int menuNumber) {
		// �迭 ����
		double[][] temp = copy_Array(grade);

		for(int i = 0; i < Quiz23_1.id_Count - 1; i++) {
			for(int j = i + 1; j < Quiz23_1.id_Count; j++) {
				// ��������
				if(menuNumber == 3 && (temp[i][idxNumber] < temp[j][idxNumber])) {
					double[] saveIndex = temp[i];
					temp[i] = temp[j];
					temp[j] = saveIndex;
				}
				// ��������
				if(menuNumber == 4 && (temp[i][idxNumber] > temp[j][idxNumber])) {
					double[] saveIndex = temp[i];
					temp[i] = temp[j];
					temp[j] = saveIndex;
				}
			}
		}
		return temp;
	}

	// ������� �Է� �� �迭 ���� �޼���
	static double[][] copy_Array(double[][] grade) {
		// �迭 ����
		double[][] temp = new double[5][8];
		for(int i = 0; i < Quiz23_1.id_Count; i++) {
			for(int j = 0; j < 8; j++) {
				temp[i][j] = grade[i][j];
			}
		}
		return temp;
	}

	// ���� �ű�� �޼��� (�հ谪���� ���� ����)
	static void rank_Std(double[][] grade) {
		// �����ϱ� �� ��� �л��� ������ 1������ �����ֱ�
		for(int i = 0; i < id_Count; i++) {
			grade[i][7] = 1;
		}
		
		// ���� ���� �ű��
		for(int i = 0; i < id_Count; i++) {
			for(int j = 0; j < id_Count; j++) {
				double leftNum = (grade[i][4]);
				double rightNum = (grade[j][4]);
				
				if(leftNum < rightNum) {
					grade[i][7]++;
				}
			}
		}
		
		// �հ踦 �������� �������� -> temp�� ����
//		double[][] temp = copy_Array(sorting_Rank(grade, 4, 4));
//		for(int i = 0; i < Quiz23_1.id_Count; i++) {
//			int overlapCount = 0;
//			for(int j = 0; j < Quiz23_1.id_Count; j++) {
//				if(temp[i][4] == grade[j][4]) {
//					grade[j][7] = rank;
//					overlapCount++;
//				}
//			}
//			rank += overlapCount;
//			if(overlapCount > 1) i += overlapCount - 1;
//		}
	}

	// �л����� ó�� ��� ��� �޼���
	static void std_Grade_Table(double[][] grade) {

		String[] attributesName = {"�й�", "����", "����", "����", "�հ�", "���", "����", "����"};
		for(int i = 0; i < attributesName.length; i++) {
			System.out.print(attributesName[i] + "\t");
		}
		System.out.println();
		for(int iCount = 0; iCount < grade.length; iCount++) {
			for(int jCount = 0; jCount < grade[iCount].length; jCount++) {
				if(jCount == 5 || jCount == 6)
					System.out.print(grade[iCount][jCount] + "\t");
				else
					System.out.print((int)(grade[iCount][jCount]) + "\t");
			}
			System.out.println();
		}

	}

	// �й� �Է� �޼���
	static void input_Std_Number(Scanner scan, double[][] grade) {

		if(id_Count > 4) {
			System.out.println("�л����� 5����� �����մϴ�.");
			while(true) {
				System.out.println("�Էµ� �л��� �ʱ�ȭ �Ͻðڽ��ϱ�? (1).YES (2).NO");
				int selectBoolean = scan.nextInt();
				if(selectBoolean == 1) {
					System.out.println("�ʱ�ȭ �Ϸ�");
					grade = new double[5][8];
					Quiz23_1.id_Count = 0;
				}else if(selectBoolean == 2) {
					System.out.println("�Էµ� �л��� ������ ����մϴ�.");
				}else {
					System.out.println("�߸��� �Է°��Դϴ�. �ٽ� �Է��ϼ���.");
					continue;
				}
				break;
			}
			std_Grade_Table(grade);
			return ;
		}

		// �л����� 5�� �����϶� �۵� / �й� �ߺ��� ���� �� Ż��.
		while(true) {
			scan = new Scanner(System.in);
			System.out.print("�й��� �Է��ϼ��� : ");
			int stdID = scan.nextInt();
			if(stdID == -100) {
				System.out.println("�����Է��� �����մϴ�.");
				std_Grade_Table(grade);
				break;
			}
			grade[id_Count][0] = stdID;
			// �ߺ��� �˻�
			boolean checkOverLap = true;
			for(int i = 0; i < id_Count; i++) {
				if(grade[i][0]  == stdID) {
					System.out.println("�ߺ��� �й��Դϴ�. �ٽ��Է����ּ���.");
					checkOverLap = false;
					break;
				}
			}
			// �����л����� ī��Ʈ �ѱ�
			if(checkOverLap == true) break;
			else					 continue;
		}// end of while

		// ���� ���� �Է¸޼���� �̵�.
		input_Sbj_Grade(scan, grade);
	}

	// ���� ���� �Է� �޼���
	static void input_Sbj_Grade(Scanner scan, double[][] grade) {
		while(true) {
			int grade_Sum		= 0;
			int std_Deviation	= 0;
			for(int i = 0; i < 3; i++) {
				if(i == 0)		System.out.print("����");
				else if(i == 1) System.out.print("����");
				else if(i == 2) System.out.print("����");

				System.out.println("������ �Է��ϼ���.");
				int sbj_grade = scan.nextInt();
				grade[id_Count][i + 1] = sbj_grade;
				// ��ȿ���˻�
				if(!(0 <= sbj_grade && sbj_grade <= 100)) {
					System.out.println("�ùٸ� ���� ���� �Է��ϼ���");
					i--;
					continue;
				}// ��ȿ�� �˻� ��
				if(std_Deviation < sbj_grade) {		// ��.��.�� maxValue ã��
					std_Deviation = sbj_grade;
				}
				std_Deviation = sbj_grade;
				grade_Sum += sbj_grade;
			}// ������ �Է� ���� E

			// ��� ���� �Է� �� ==> [4]�հ� / [5]��� / [6]���� 
			grade[id_Count][4] = grade_Sum;
			grade[id_Count][5] = grade_Sum / 3;
			grade[id_Count][6] = std_Deviation - grade[id_Count][5];
			break;
		}
		Quiz23_1.id_Count++;
		// ���� ���� �޼��� ����
		rank_Std(grade);
	}
}
