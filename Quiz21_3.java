package testPkg;

import java.util.Scanner;

public class Quiz21_3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 사용자로부터 문자열의 개수를 입력받기
		System.out.println("입력할 문자열의 개수?");
		final int MAX = scan.nextInt();
		String[] user = new String[MAX]; 

		// 오름차순 or 내림차순 입력받기
		System.out.println("정렬 방식 선택? (1)오름, (2)내림");
		int range_Control = scan.nextInt();

		//String로 받아 들이고 배열에 저장.
		System.out.println("값을 입력해주세요 배열의 최대 길이는" + MAX + "입니다.");
		for(int i = 0 ; i < MAX ; i++) {
			user[i] = scan.next();
		}
		System.out.println("String입력 끝. 배열에 저장 완료");

		if(range_Control == 1)
			System.out.println("오름차순으로 정렬한 값은?");
		else
			System.out.println("내림차순으로 정렬한 값은?");

		// 배열에 저장된 값 최대길이만큼 for문 돌리기
		for(int loop_Count = 0; loop_Count < MAX; loop_Count++) {
			// 첫번째 값만 비교하기 
			for(int find_1_Idx = loop_Count + 1; find_1_Idx < MAX; find_1_Idx++) {

				// 오름차순 알고리즘
				if(range_Control == 1) {
					//앞에 값이 뒤에 값 보다 크거나 같을 때 알고리즘시작  / 작을 떄 LOOP2 탈출
					if(user[loop_Count].charAt(0) >= user[find_1_Idx].charAt(0)) {
						int short_Idx_Lth	= 0;
						int idx_Count		= 0;

						//여기서 둘 사이의 length를 따져서 하나하나 비교.
						//length를 비교할 때는 둘중 작은 length의 값을 따라야 함으로 비교 연산이 필요함.
						if(user[loop_Count].length() >= user[find_1_Idx].length()) {
							short_Idx_Lth = user[find_1_Idx].length();

						}else short_Idx_Lth = user[loop_Count].length();

						//두 문자열 비교 시작
						while(true) {
							if(idx_Count == short_Idx_Lth) break;

							if(user[loop_Count].length() > user[find_1_Idx].length() || 
							   user[loop_Count].charAt(idx_Count) > user[find_1_Idx].charAt(idx_Count)) {
								
								String tmp				= user[loop_Count];
								user[loop_Count]		= user[find_1_Idx];
								user[find_1_Idx]	 	= tmp;
								break;
							}else if(user[loop_Count].charAt(idx_Count) > user[find_1_Idx].charAt(idx_Count)){
								break;
							}
							idx_Count++;
						}// 두 문자열 비교 end
					}
				}// 오름차순 알고리즘 end
				else if(range_Control == 2) {

					// 내림차순 알고리즘
					if(user[loop_Count].charAt(0) <= user[find_1_Idx].charAt(0)) {
						int short_Idx_Lth	= 0;
						int idx_Count		= 0;

						if(user[loop_Count].length() >= user[find_1_Idx].length()) {
							short_Idx_Lth = user[find_1_Idx].length();

						}else short_Idx_Lth = user[loop_Count].length();

						while(true) {
							if(idx_Count == short_Idx_Lth) break;

							if(user[loop_Count].length() < user[find_1_Idx].length() || 
							   user[loop_Count].charAt(idx_Count) < user[find_1_Idx].charAt(idx_Count)) {
								
								String tmp				= user[loop_Count];
								user[loop_Count]		= user[find_1_Idx];
								user[find_1_Idx]	 	= tmp;
								break;
							}else if(user[loop_Count].charAt(idx_Count) > user[find_1_Idx].charAt(idx_Count)) {
								break;
							}
							idx_Count++;
						}// 두 문자열 비교 end
					}
				}// 내림차순 알고리즘 end
			}
			System.out.println(user[loop_Count]);
//			if(loop_Count == MAX - 2) System.out.println(user[loop_Count + 1]);
		}
	}
}
