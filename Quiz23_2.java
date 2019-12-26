package testPkg;

import java.util.Scanner;

public class Quiz23_2 {

   public static void main(String[] args) {
      // TODO Auto-generated method stub

      PlayManagementProgram();
   }

   static void PlayManagementProgram() {

      Scanner      scan      = new Scanner(System.in);
      String[][]   saveGrades   = new String[6][8];

      saveGrades[0]         = new String[]{"학번", "국어", "영어", "수학", "합계", "평균", "편차", "순위"};

      for (int i = 0; i < saveGrades.length; i++) {
         for (int j = 0; j < saveGrades[i].length; j++) {
            System.out.print(saveGrades[i][j] + "\t");
         }
         System.out.println();
      }
      do {

         System.out.println("---------------------\n"
               + "     성 적 관 리  프 로 그 램\n"
               + "---------------------");
         System.out.println("1. 학생성적 입력하기\n"
               + "2. 학생성적 처리 결과 출력하기\n"
               + "3. 순위기준 내림차순 출력하기\n"
               + "4. 수학성적 기준 올림차순 출력하기\n"
               + "5. 프로그램 종료\n\n");

         System.out.print("메뉴를 선택하세요 : ");
         int   selectMenu = scan.nextInt();

         //if : 1 ~ 5 외의 메뉴를 선택 시, 오류메시지 출력 후 재선택
         if (!(selectMenu >= 1 && selectMenu <= 5))      System.out.println("메뉴 1 ~ 5 중에서 선택하시오.");
         else {
            if      (selectMenu == 5) {
               System.out.println("이용해주셔서 감사합니다.");
               break;
            }
            else if   (selectMenu == 1)   InputGrades(scan, saveGrades);
            else                  PrintGrades(saveGrades, selectMenu);
         }

      } while (true);

   }

   //method : 학생의 성적을 입력하는 메서드
   static void InputGrades(Scanner scan, String[][] saveGrades){

      //loop : 학생의 성적을 순차적으로 입력
      for (int i = 1; i < saveGrades.length; i++) {

         System.out.print("\n" + i + "번 학생의 학번을 입력 > ");
         String studentID = scan.next();
         scan.nextLine();

         boolean checkStudentID   = false;
         int      overlapID      = 0;
         
         for (int j = 1; j < i; j++) {
            
            checkStudentID = saveGrades[j][0].equals(studentID);
            
            if (checkStudentID) {
               overlapID = j;
               break;
            }
         }
         
         if (checkStudentID) {
            System.out.println(overlapID + "번 학생과 중복된 학번입니다.\n"
                  + (i--) + "번 학생의 학번을 다시 입력하세요");
            continue;
         }
         
         int tmpID = Integer.parseInt(studentID);

         //if : 입력 받은 학번이 -100일 경우 성적 입력을 종료
         if (tmpID == -100)      break;

         //else if : 학번이 1 ~ 999 사이가 아닐 경우 학번을 재입력
         else if(!(tmpID > 0 && tmpID <= 999)) {
            System.out.println("1 ~ 999 사이에서 학번은 입력하세요.\n");
            i--;
         }
         
         //else : 학번이 1 ~ 100 사이일 경우 성적을 입력
         else {

            boolean   checkGrade   = true;
            saveGrades[i][0]   = studentID;

            do {
               System.out.print(saveGrades[i][0] + " 학생의 국어, 영어, 수학 성적을 입력(성적은 0 ~ 100점, 공백으로 구분) > ");

               String   studentGrade = scan.nextLine();

               String   tmpGradeS = "";
               int      gradeIndex = 1;

               //loop : 입력받은 성적 문자열을 공백 단위로 끊어서 배열에 저장
               for (int j = 0; j < studentGrade.length(); j++) {

                  //if : 입력받은 문자열 중 공백이 이날 경우
                  if (studentGrade.charAt(j) != ' ')      tmpGradeS += studentGrade.charAt(j);

                  //if : 입력받은 문자열 중 공백일 경우
                  if (studentGrade.charAt(j) == ' ' || j == studentGrade.length() - 1) {

                     int tmpGradeI = Integer.parseInt(tmpGradeS);

                     //if : 유효하지 않은 성적 입력 시, 재입력
                     if (!(tmpGradeI >= 0 && tmpGradeI <= 100)) {
                        System.out.println("성적을 잘못 입력하였습니다. 다시 입력하세요.\n");
                        break;
                     }
                     //else : 유효한 성적 입력 시, 배열에 저장
                     else {
                        saveGrades[i][gradeIndex++] = tmpGradeS;
                        tmpGradeS = "";
                     }
                  }
               }

               if (gradeIndex == 4)   break;

            } while (checkGrade);
         }
      }

      CalcuGrades(saveGrades);

      System.out.println();
   }

   //method : 입력받은 학생의 성적을 이용하여, 합계, 평균, 편차, 순위를 연산
   static void CalcuGrades(String[][] saveGrades) {

      for (int i = 1; i < saveGrades.length; i++) {

         if (saveGrades[i][1] == null)      break;

         int      gradeMax      = Integer.parseInt(saveGrades[i][1]);
         int      gradeSum      = 0;
         float   gradeAverage   = 0;
         float   gradeDeviation   = 0;

         for (int j = 1; j <= 3; j++) {

            int grades = Integer.parseInt(saveGrades[i][j]);

            if (grades > gradeMax)   gradeMax = grades;
            gradeSum += grades;
         }

         gradeAverage   = (float)(Math.round(gradeSum / 3.0 * 10) / 10.0);
         gradeDeviation   = (float)(Math.round((gradeMax - gradeAverage) * 10) / 10.0);

         saveGrades[i][4] = Integer.toString(gradeSum);
         saveGrades[i][5] = Float.toString(gradeAverage);
         saveGrades[i][6] = Float.toString(gradeDeviation);
         saveGrades[i][7] = "1";   
      }

      for (int i = 1; i < saveGrades.length; i++) {
         for (int j = 1; j < saveGrades.length; j++) {

            if (saveGrades[i][5] == null || saveGrades[j][5] == null)   break;

            float leftNum   = Float.parseFloat(saveGrades[i][5]);
            float rightNum   = Float.parseFloat(saveGrades[j][5]);

            if (leftNum < rightNum) {
               int tmpNum = Integer.parseInt(saveGrades[i][7]) + 1;
               saveGrades[i][7] = Integer.toString(tmpNum);
            }
         }
      }
   }

   static void PrintGrades(String[][] inputArray, int selectMenu) {

      if (inputArray[1][0] == null) {
         System.out.println("입력 값이 없습니다.\n");
         return;
      }

      String[][] printArray = new String[6][8];

      for (int i = 0; i < printArray.length; i++) {
         for (int j = 0; j < printArray[i].length; j++) {
            printArray[i][j] = inputArray[i][j];
         }
      }

      if (selectMenu == 3 || selectMenu == 4)    SortGrades(printArray, selectMenu);

      for (int i = 0; i < printArray.length; i++) {
         for (int j = 0; j < printArray[i].length; j++) {
            System.out.print(printArray[i][j] + "\t");
         }
         System.out.println();
      }

      System.out.println();
   }   
   
   static void SortGrades(String[][] inputArray, int selectMenu) {

      boolean   checkCase = false;
      int      index = 0;

      if      (selectMenu == 3)   index = 7;
      else if (selectMenu == 4)   index = 3;

      for (int i = 1; i <= inputArray.length; i++) {
         for (int j = 1; j <= inputArray.length - i - 1; j++) {

            if (inputArray[j][index] == null || inputArray[j + 1][index] == null)   break;

            int leftNum    = Integer.parseInt(inputArray[j][index]);
            int rightNum   = Integer.parseInt(inputArray[j + 1][index]);

            if      (selectMenu == 3)   checkCase = leftNum < rightNum;
            else if (selectMenu == 4)   checkCase = leftNum > rightNum;

            if (checkCase) {
               String[] tmp      = inputArray[j];
               inputArray[j]      = inputArray[j + 1];
               inputArray[j + 1]   = tmp;
            }
         }
      }
   }
   
   //   static void DescendingOrderByRanking(String[][] inputArray) {
   //
   //      for (int i = 1; i <= inputArray.length; i++) {
   //         for (int j = 1; j <= inputArray.length - i - 1; j++) {
   //            
   //            if (inputArray[j][7] == null || inputArray[j + 1][7] == null)   break;
   //            
   //            int leftNum      = Integer.parseInt(inputArray[j][7]);
   //            int rightNum   = Integer.parseInt(inputArray[j + 1][7]);
   //            
   //            if (leftNum < rightNum) {
   //               String[] tmp      = inputArray[j];
   //               inputArray[j]      = inputArray[j + 1];
   //               inputArray[j + 1]   = tmp;
   //            }
   //         }
   //      }
   //   }
   //
   //   static void AscendingOrderByMathGrades(String[][] inputArray) {
   //      
   //      for (int i = 1; i <= inputArray.length; i++) {
   //         for (int j = 1; j <= inputArray.length - i - 1; j++) {
   //            
   //            if (inputArray[j][3] == null || inputArray[j + 1][3] == null)   break;
   //            
   //            int leftNum      = Integer.parseInt(inputArray[j][3]);
   //            int rightNum   = Integer.parseInt(inputArray[j + 1][3]);
   //            
   //            if (leftNum > rightNum) {
   //               String[] tmp      = inputArray[j];
   //               inputArray[j]      = inputArray[j + 1];
   //               inputArray[j + 1]   = tmp;
   //            }
   //         }
   //      }
   //   }
}