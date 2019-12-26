package testPkg;

import java.util.Scanner;

public class Quiz21_1 {
	public static void main(String[] args) {
		int number_Count = 0;
		int input_Select = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("입력할 문자열의 개수?");
		number_Count = scan.nextInt();

		//		System.out.println("정렬 방식 선택? (1)오름, (2)내림");
		//		input_Select= scan.nextInt();

		String[] user_Input = new String[number_Count];
		System.out.println("문자열 입력");
		for(int iCount = 0; iCount < number_Count; iCount++) {
			user_Input[iCount] = scan.next();
		}

		//오름차순 && 내림차순
		for(int i = 0; i < user_Input.length - 1; i++) {
			// i 카운트 + 1 이상 문자열 순환하기
			for(int jCount = i + 1; jCount < user_Input.length; jCount++) {
				// 첫번째 자리 값만 비교 .. 첫번째 값이 차이가 안나면 그냥 통과
				if(user_Input[i].charAt(0) >= user_Input[jCount].charAt(0)) {
					int compareLength = 0;
					// 두 문자열 비교 시 필요한 for문 반복 Count 정하기
					if(user_Input[i].length() > user_Input[i + 1].length()) compareLength = user_Input[i + 1].length();
					else 													compareLength = user_Input[i].length();
					// 문자열 끼리 비교
					Main : for(int k = 0; k < compareLength; k++) {
						for(int j = k, n_Count = 1; j < compareLength; j++, n_Count++) {
							// 여기만 수정하면 끝날듯
							if(user_Input[i].charAt(k) > user_Input[i + n_Count].charAt(j)) {
								String temp			= user_Input[i];
								user_Input[i]		= user_Input[jCount];
								user_Input[jCount]	= temp;
								break Main;
							}
						}
					}
				}// 첫번째 자리 값 비교 알고리즘 끝
			}// jCount 알고리즘 끝
		}// 오름차순 알고리즘 끝
		
		// 출력하기
		System.out.println("===출력합니다===");
		for(int iCount = 0; iCount < user_Input.length; iCount++) {
			System.out.println(user_Input[iCount]);
		}

		// 예를들어
		/*	
		C, A, F ,B 가 있다
		여기서 처음에 C부터 시작해서 한칸씩 비교를 하겠지?
		C랑 A랑 비교했을 때 A가 더 작으면 A를 배열 0번째 자리에 안착
		그럼
		A, C, F, B 가 된다
		여기서 이제 A랑 F랑 비교하고 만약 앞에 값이 더 크면 그냥 넘어가기
		그럼 이제 A랑 B랑 비교한다 비교해도 앞에 값이 더 크기 때문에 그냥 넘어가기
		이제 맨 앞자리 알파벳은 정렬 완료
		그럼
		두번째 자리의 알파벳 정렬 시작
		C와 F비교 >> 그냥 넘어감
		C와 B비교 >> B가 더 작아서 B가 C자리로 감.
		그럼
		A, B, F, C가 된다.
		이제 세번째 자리의 알파벳 정렬 시작
		F와 C를 비교 >> C가 더 작아서 C가 배열 2번 자리로 들어가고 F가 마지막자리에 안착.
		정렬 끝.
		====================================================
		C, AC, A, B, AB가 있을 때
		일단 첫번째 자리로 비교하기 Charat
		1. C랑 A랑 비교 A가 더 작내? 그럼 바로 자리 교체
		>> AC, C, A, B, AB
		2. AC랑 A 비교 앞자리가 같을 때 알고리즘 시작.
		A == A >> 여기서 if구문 하나 써서 lengh가 1인게 앞으로 이동하기.
		만약 둘다 length가 2 이상일 시 >> 첫번째 자리를 제외하고 2번째 자리부터 서로 비교
		만약 여기서 2번째 자리도 같은 값일 시 반복해서 3번째 자리 비교, 4번째 자리 비교.. 반복하면서
		누가 더 작은지 비교 하고 >> 비교 하고 나온 작은 값을 앞으로 스위칭한다.
		 */		
	}
}

//		for(int iCount = 0; iCount < number_Count - 1; iCount++) {
//			int min_Index = iCount;
//			for(int i = 0; iCount < user_Input[iCount].length(); i++) {
//				for(int jCount = iCount + 1; jCount < number_Count; jCount++) {
//					for(int k = 0; k < user_Input[jCount].length(); k++) {
//						// 오름차순
//						if(input_Select == 1 && user_Input[jCount].charAt(k) < user_Input[min_Index].charAt(i)) {
//							min_Index = jCount;
//						}
//						// 내림차순
////						if(input_Select == 2 && user_Input[jCount].charAt(k) > user_Input[min_Index].charAt(i)) {
////							min_Index = jCount;
////						}
//					}
//				}
//			}
//			String temp = user_Input[iCount];
//			user_Input[iCount] = user_Input[min_Index];
//			user_Input[min_Index] = temp;
//		}
//		if(input_Select == 1)	System.out.println("오름차순 정렬 결과");
//		else					System.out.println("내림차순 정렬 결과");
//		for(int iCount = 0; iCount < number_Count; iCount++) {
//			System.out.print(user_Input[iCount] + " ");
//		}