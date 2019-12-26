package testPkg;

import java.util.Scanner;

public class Quiz23_3 {
   static int      menu = 0;
   static int      studentNum = 0;
   static String[] form = {"학번", "국어", "영어", "수학", "합계", "평균", "편차", "순위"};
   final static int S_NUM = 0, S_KOR = 1, S_ENG = 2, S_MATH = 3, S_SUM = 4, S_AVG = 5, S_DEV = 6, S_RANK = 7;
   
   public static void main(String[] args) {
      // 학생 성적 관리를 위한 2차원 배열 선언
      float[][] students = new float[5][form.length];
      
      // scanner 선언
      Scanner scan = new Scanner(System.in);
      
      while(true) {
         // 메인 화면 출력
         displayMain(scan);
         
         // 메뉴별 동작
         switch(menu) {
            case 1 :
               inputInfo(students, scan);
               calculateAll(students);
               break;
               
            case 2 :
               basicPrint(students);
               break;
               
            case 3 :
               rankDesc(students);
               break;
               
            case 4 :
               mathAsc(students);
            
         }
      }
   }
   
   static void displayMain(Scanner scn) {
      System.out.println("--------------------\n"
            + "    성 적 관 리 프로그램\n"
            + "--------------------");
      
      System.out.println("1. 학생성적 입력하기\n"
            + "2. 학생성적 처리 결과 출력하기\n"
            + "3. 순위기준 내림차순 출력하기\n"
            + "4. 수학성적 기준 올림차순 출력하기\n");
      
      System.out.print("메뉴를 선택하세요: ");      
      menu = scn.nextInt();
   }
   
   // 학생의 학번, 국어, 영어, 수학 성적 입력
   static void inputInfo(float[][] arr, Scanner scn) {
      while(studentNum < 5) {
         for(int i = 0; i < 4; i++) {
            if(i == 0) System.out.println();
            
            System.out.print(form[i] + " 입력하세요: ");
            arr[studentNum][i] = scn.nextFloat();
            
            if(i == 0) {   
               // 학번이 -100일 경우 종료
               if(arr[studentNum][i] == -100) {
                  return;
               }
               
               // 학번 중복 검사
               for(int j = 0; j < studentNum; j++) {
                  if(arr[studentNum][S_NUM] == arr[j][S_NUM]) {
                     i--;
                     break;
                  }
               }
            }
         }
         studentNum++;
      } // end of while
   } // end of inputInfo()
   
   // 종료 후 계산할 것들
   static void calculateAll(float[][] arr) {
      calculateSum(arr);
      calculateAvg(arr);
      calculateDev(arr);
      calculateRank(arr);
   }
   
   // 성적 합계 계산
   static void calculateSum(float[][] arr) {
      for(int i = 0; i < studentNum; i++) {
         arr[i][S_SUM] = 0;
         
         for(int j = 1; j < 4; j++) {
            arr[i][S_SUM] += arr[i][j];
         }
      }
   }
   
   // 성적 평균 계산
   static void calculateAvg(float[][] arr) {
      for(int i = 0; i < studentNum; i++) {
         arr[i][S_AVG] = arr[i][S_SUM] / 3;
      }
   }
   
   // 성적 편차 계산
   static void calculateDev(float[][] arr) {
      // 학생들 평균 다 더하기
      float sumOfAvg = 0.f;
      
      for(int i = 0; i < studentNum; i++) {
         sumOfAvg += arr[i][S_AVG];
      }
      
      float standValue = sumOfAvg / studentNum;
      
      // 본인의 편차 = 본인 평균 - 학생전체평균
      for(int i = 0; i < studentNum; i++) {
         arr[i][S_DEV] = arr[i][S_AVG] - standValue;
      }
   }
   
   // 순위 계산
   static void calculateRank(float[][] arr) {
      for(int i = 0; i < studentNum; i++) {
         // 학생의 초기 순위는 1
         arr[i][S_RANK] = 1;
         
         // 자신의 평균점수보다 높은 점수가 있으면 순위 + 1
         for(int j = 0; j < studentNum; j++) {
            if(arr[i][S_AVG] < arr[j][S_AVG])
               arr[i][S_RANK]++;
         }
      }
   }
   
   // 입력 순서대로 출력
   static void basicPrint(float[][] arr) {
      if(studentNum != 0) {
         // 양식 출력
         for(String str : form)
            System.out.print(str + "\t");
         System.out.println();
         
         // 데이터 출력
         for(int i = 0; i < studentNum; i++) {
            for(int j = 0; j < form.length; j++) {
               if((0 <= j && j <= 4) || j == S_RANK)
                  System.out.printf("%d\t", (int)arr[i][j]);
               else
                  System.out.printf("%.1f\t", arr[i][j]);
            }
            System.out.println();
         }
      } else {
         System.out.println("입력 값이 없습니다.");
      }
   }
   
   // 순위기준 내림차순 출력
   static void rankDesc(float[][] arr) {
      if(studentNum != 0) {
         // 양식 출력
         for(String str : form)
            System.out.print(str + "\t");
         System.out.println();
         
         // 데이터 출력
         for(int i = studentNum; i > 0; i--) {
            for(int j = 0; j < studentNum; j++) {
               if(arr[j][S_RANK] == i) {
                  for(int k = 0; k < form.length; k++) {
                     if((0 <= k && k <= 4) || k == S_RANK)
                        System.out.printf("%d\t", (int)arr[j][k]);
                     else
                        System.out.printf("%.1f\t", arr[j][k]);
                  }
                  System.out.println();
               }
            }
         }
      } else {
         System.out.println("입력 값이 없습니다.");
      }
   }
   
   //수학 성적 기준 오름차순 출력
   static void mathAsc(float[][] arr) {
      if(studentNum != 0) {
         // 인덱스를 저장해놓는 배열 선언
         int[] saveIndex = new int[studentNum];
         
         // 0 ~ 학생수를 순서대로 저장
         for(int i = 0; i < saveIndex.length; i++)
            saveIndex[i] = i;
         
         int basePos = 0;
         for(int i = 0; i < saveIndex.length - 1; i++) {
            // basePos을 i로 지정
            basePos = i;
            
            for(int j = i + 1; j < saveIndex.length; j++) {
               // i 이후 값부터 검사하면서 i보다 큰 값이 있으면 basePos에 저장
               if(arr[basePos][S_MATH] > arr[j][S_MATH]) {
                  basePos = j;
               }
            }
            
            // for문 종료 후 i랑 basePos이랑 값 바꿈
            int tmp = saveIndex[i];
            saveIndex[i] = saveIndex[basePos];
            saveIndex[basePos] = tmp;
         }
         
         // 양식 출력
         for(String str : form)
            System.out.print(str + "\t");
         System.out.println();
         
         // 배열의 인덱스 순서대로 출력
         for(int i = 0; i < saveIndex.length; i++) {
            int pos = saveIndex[i];
            for(int j = 0; j < form.length; j++) {
               if((0 <= j && j <= 4) || j == S_RANK)
                  System.out.printf("%d\t", (int)arr[pos][j]);
               else
                  System.out.printf("%.1f\t", arr[pos][j]);
            }
            System.out.println();
         }
      } else {
         System.out.println("입력 값이 없습니다.");
      }
   }

}