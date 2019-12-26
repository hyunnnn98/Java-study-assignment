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

      saveGrades[0]         = new String[]{"�й�", "����", "����", "����", "�հ�", "���", "����", "����"};

      for (int i = 0; i < saveGrades.length; i++) {
         for (int j = 0; j < saveGrades[i].length; j++) {
            System.out.print(saveGrades[i][j] + "\t");
         }
         System.out.println();
      }
      do {

         System.out.println("---------------------\n"
               + "     �� �� �� ��  �� �� �� ��\n"
               + "---------------------");
         System.out.println("1. �л����� �Է��ϱ�\n"
               + "2. �л����� ó�� ��� ����ϱ�\n"
               + "3. �������� �������� ����ϱ�\n"
               + "4. ���м��� ���� �ø����� ����ϱ�\n"
               + "5. ���α׷� ����\n\n");

         System.out.print("�޴��� �����ϼ��� : ");
         int   selectMenu = scan.nextInt();

         //if : 1 ~ 5 ���� �޴��� ���� ��, �����޽��� ��� �� �缱��
         if (!(selectMenu >= 1 && selectMenu <= 5))      System.out.println("�޴� 1 ~ 5 �߿��� �����Ͻÿ�.");
         else {
            if      (selectMenu == 5) {
               System.out.println("�̿����ּż� �����մϴ�.");
               break;
            }
            else if   (selectMenu == 1)   InputGrades(scan, saveGrades);
            else                  PrintGrades(saveGrades, selectMenu);
         }

      } while (true);

   }

   //method : �л��� ������ �Է��ϴ� �޼���
   static void InputGrades(Scanner scan, String[][] saveGrades){

      //loop : �л��� ������ ���������� �Է�
      for (int i = 1; i < saveGrades.length; i++) {

         System.out.print("\n" + i + "�� �л��� �й��� �Է� > ");
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
            System.out.println(overlapID + "�� �л��� �ߺ��� �й��Դϴ�.\n"
                  + (i--) + "�� �л��� �й��� �ٽ� �Է��ϼ���");
            continue;
         }
         
         int tmpID = Integer.parseInt(studentID);

         //if : �Է� ���� �й��� -100�� ��� ���� �Է��� ����
         if (tmpID == -100)      break;

         //else if : �й��� 1 ~ 999 ���̰� �ƴ� ��� �й��� ���Է�
         else if(!(tmpID > 0 && tmpID <= 999)) {
            System.out.println("1 ~ 999 ���̿��� �й��� �Է��ϼ���.\n");
            i--;
         }
         
         //else : �й��� 1 ~ 100 ������ ��� ������ �Է�
         else {

            boolean   checkGrade   = true;
            saveGrades[i][0]   = studentID;

            do {
               System.out.print(saveGrades[i][0] + " �л��� ����, ����, ���� ������ �Է�(������ 0 ~ 100��, �������� ����) > ");

               String   studentGrade = scan.nextLine();

               String   tmpGradeS = "";
               int      gradeIndex = 1;

               //loop : �Է¹��� ���� ���ڿ��� ���� ������ ��� �迭�� ����
               for (int j = 0; j < studentGrade.length(); j++) {

                  //if : �Է¹��� ���ڿ� �� ������ �̳� ���
                  if (studentGrade.charAt(j) != ' ')      tmpGradeS += studentGrade.charAt(j);

                  //if : �Է¹��� ���ڿ� �� ������ ���
                  if (studentGrade.charAt(j) == ' ' || j == studentGrade.length() - 1) {

                     int tmpGradeI = Integer.parseInt(tmpGradeS);

                     //if : ��ȿ���� ���� ���� �Է� ��, ���Է�
                     if (!(tmpGradeI >= 0 && tmpGradeI <= 100)) {
                        System.out.println("������ �߸� �Է��Ͽ����ϴ�. �ٽ� �Է��ϼ���.\n");
                        break;
                     }
                     //else : ��ȿ�� ���� �Է� ��, �迭�� ����
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

   //method : �Է¹��� �л��� ������ �̿��Ͽ�, �հ�, ���, ����, ������ ����
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
         System.out.println("�Է� ���� �����ϴ�.\n");
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