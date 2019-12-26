package testPkg;

import java.util.Scanner;

public class Quiz23_1 {
	// id_Count 전역변수 설정.
	static int id_Count = 0;

	public static void main(String[] args) {
		// 학생 성적을 관리하기 위한 2차원 배열 생성
		double[][] grade = new double[5][8];

		System.out.println("----------------\n"
				+ "    성적관리 프로그램\n"
				+ "----------------\n"
				+ "1. 학생 성적 입력하기\n"
				+ "2. 학생성적 처리 결과 출력하기\n"
				+ "3. 순위기준 내림차순 출력하기\n"
				+ "4. 수학성적 기준 오름차순 출력하기\n");

		// 매뉴 선택하기
		Scanner scan = new Scanner(System.in);
		while(true) {
			scan = new Scanner(System.in);
			System.out.print("메뉴를 선택하세요 :");
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
				System.out.println("입력값이 없습니다");
				continue;
			}
		}
	}

	// 오름차순 && 내림차순 메서드
	static double[][] sorting_Rank(double[][] grade, int idxNumber, int menuNumber) {
		// 배열 복사
		double[][] temp = copy_Array(grade);

		for(int i = 0; i < Quiz23_1.id_Count - 1; i++) {
			for(int j = i + 1; j < Quiz23_1.id_Count; j++) {
				// 내림차순
				if(menuNumber == 3 && (temp[i][idxNumber] < temp[j][idxNumber])) {
					double[] saveIndex = temp[i];
					temp[i] = temp[j];
					temp[j] = saveIndex;
				}
				// 오름차순
				if(menuNumber == 4 && (temp[i][idxNumber] > temp[j][idxNumber])) {
					double[] saveIndex = temp[i];
					temp[i] = temp[j];
					temp[j] = saveIndex;
				}
			}
		}
		return temp;
	}

	// 현재까지 입력 된 배열 복사 메서드
	static double[][] copy_Array(double[][] grade) {
		// 배열 복사
		double[][] temp = new double[5][8];
		for(int i = 0; i < Quiz23_1.id_Count; i++) {
			for(int j = 0; j < 8; j++) {
				temp[i][j] = grade[i][j];
			}
		}
		return temp;
	}

	// 순위 매기는 메서드 (합계값으로 순위 결정)
	static void rank_Std(double[][] grade) {
		// 시작하기 전 모든 학생의 성적을 1등으로 맞춰주기
		for(int i = 0; i < id_Count; i++) {
			grade[i][7] = 1;
		}
		
		// 성적 순위 매기기
		for(int i = 0; i < id_Count; i++) {
			for(int j = 0; j < id_Count; j++) {
				double leftNum = (grade[i][4]);
				double rightNum = (grade[j][4]);
				
				if(leftNum < rightNum) {
					grade[i][7]++;
				}
			}
		}
		
		// 합계를 기준으로 오름차순 -> temp에 저장
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

	// 학생성적 처리 결과 출력 메서드
	static void std_Grade_Table(double[][] grade) {

		String[] attributesName = {"학번", "국어", "영어", "수학", "합계", "평균", "편차", "순위"};
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

	// 학번 입력 메서드
	static void input_Std_Number(Scanner scan, double[][] grade) {

		if(id_Count > 4) {
			System.out.println("학생수는 5명까지 가능합니다.");
			while(true) {
				System.out.println("입력된 학생을 초기화 하시겠습니까? (1).YES (2).NO");
				int selectBoolean = scan.nextInt();
				if(selectBoolean == 1) {
					System.out.println("초기화 완료");
					grade = new double[5][8];
					Quiz23_1.id_Count = 0;
				}else if(selectBoolean == 2) {
					System.out.println("입력된 학생의 성적을 출력합니다.");
				}else {
					System.out.println("잘못된 입력값입니다. 다시 입력하세요.");
					continue;
				}
				break;
			}
			std_Grade_Table(grade);
			return ;
		}

		// 학생수가 5명 이하일때 작동 / 학번 중복값 없을 시 탈출.
		while(true) {
			scan = new Scanner(System.in);
			System.out.print("학번을 입력하세요 : ");
			int stdID = scan.nextInt();
			if(stdID == -100) {
				System.out.println("성적입력을 종료합니다.");
				std_Grade_Table(grade);
				break;
			}
			grade[id_Count][0] = stdID;
			// 중복값 검사
			boolean checkOverLap = true;
			for(int i = 0; i < id_Count; i++) {
				if(grade[i][0]  == stdID) {
					System.out.println("중복된 학번입니다. 다시입력해주세요.");
					checkOverLap = false;
					break;
				}
			}
			// 다음학생으로 카운트 넘김
			if(checkOverLap == true) break;
			else					 continue;
		}// end of while

		// 과목별 성적 입력메서드로 이동.
		input_Sbj_Grade(scan, grade);
	}

	// 과목별 성적 입력 메서드
	static void input_Sbj_Grade(Scanner scan, double[][] grade) {
		while(true) {
			int grade_Sum		= 0;
			int std_Deviation	= 0;
			for(int i = 0; i < 3; i++) {
				if(i == 0)		System.out.print("국어");
				else if(i == 1) System.out.print("영어");
				else if(i == 2) System.out.print("수학");

				System.out.println("성적을 입력하세요.");
				int sbj_grade = scan.nextInt();
				grade[id_Count][i + 1] = sbj_grade;
				// 유효성검사
				if(!(0 <= sbj_grade && sbj_grade <= 100)) {
					System.out.println("올바른 범위 값을 입력하세요");
					i--;
					continue;
				}// 유효성 검사 끝
				if(std_Deviation < sbj_grade) {		// 국.영.수 maxValue 찾기
					std_Deviation = sbj_grade;
				}
				std_Deviation = sbj_grade;
				grade_Sum += sbj_grade;
			}// 국영수 입력 종료 E

			// 모든 과목 입력 끝 ==> [4]합계 / [5]평균 / [6]편차 
			grade[id_Count][4] = grade_Sum;
			grade[id_Count][5] = grade_Sum / 3;
			grade[id_Count][6] = std_Deviation - grade[id_Count][5];
			break;
		}
		Quiz23_1.id_Count++;
		// 순위 결정 메서드 실행
		rank_Std(grade);
	}
}
