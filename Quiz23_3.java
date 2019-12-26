package testPkg;

import java.util.Scanner;

public class Quiz23_3 {
   static int      menu = 0;
   static int      studentNum = 0;
   static String[] form = {"�й�", "����", "����", "����", "�հ�", "���", "����", "����"};
   final static int S_NUM = 0, S_KOR = 1, S_ENG = 2, S_MATH = 3, S_SUM = 4, S_AVG = 5, S_DEV = 6, S_RANK = 7;
   
   public static void main(String[] args) {
      // �л� ���� ������ ���� 2���� �迭 ����
      float[][] students = new float[5][form.length];
      
      // scanner ����
      Scanner scan = new Scanner(System.in);
      
      while(true) {
         // ���� ȭ�� ���
         displayMain(scan);
         
         // �޴��� ����
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
            + "    �� �� �� �� ���α׷�\n"
            + "--------------------");
      
      System.out.println("1. �л����� �Է��ϱ�\n"
            + "2. �л����� ó�� ��� ����ϱ�\n"
            + "3. �������� �������� ����ϱ�\n"
            + "4. ���м��� ���� �ø����� ����ϱ�\n");
      
      System.out.print("�޴��� �����ϼ���: ");      
      menu = scn.nextInt();
   }
   
   // �л��� �й�, ����, ����, ���� ���� �Է�
   static void inputInfo(float[][] arr, Scanner scn) {
      while(studentNum < 5) {
         for(int i = 0; i < 4; i++) {
            if(i == 0) System.out.println();
            
            System.out.print(form[i] + " �Է��ϼ���: ");
            arr[studentNum][i] = scn.nextFloat();
            
            if(i == 0) {   
               // �й��� -100�� ��� ����
               if(arr[studentNum][i] == -100) {
                  return;
               }
               
               // �й� �ߺ� �˻�
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
   
   // ���� �� ����� �͵�
   static void calculateAll(float[][] arr) {
      calculateSum(arr);
      calculateAvg(arr);
      calculateDev(arr);
      calculateRank(arr);
   }
   
   // ���� �հ� ���
   static void calculateSum(float[][] arr) {
      for(int i = 0; i < studentNum; i++) {
         arr[i][S_SUM] = 0;
         
         for(int j = 1; j < 4; j++) {
            arr[i][S_SUM] += arr[i][j];
         }
      }
   }
   
   // ���� ��� ���
   static void calculateAvg(float[][] arr) {
      for(int i = 0; i < studentNum; i++) {
         arr[i][S_AVG] = arr[i][S_SUM] / 3;
      }
   }
   
   // ���� ���� ���
   static void calculateDev(float[][] arr) {
      // �л��� ��� �� ���ϱ�
      float sumOfAvg = 0.f;
      
      for(int i = 0; i < studentNum; i++) {
         sumOfAvg += arr[i][S_AVG];
      }
      
      float standValue = sumOfAvg / studentNum;
      
      // ������ ���� = ���� ��� - �л���ü���
      for(int i = 0; i < studentNum; i++) {
         arr[i][S_DEV] = arr[i][S_AVG] - standValue;
      }
   }
   
   // ���� ���
   static void calculateRank(float[][] arr) {
      for(int i = 0; i < studentNum; i++) {
         // �л��� �ʱ� ������ 1
         arr[i][S_RANK] = 1;
         
         // �ڽ��� ����������� ���� ������ ������ ���� + 1
         for(int j = 0; j < studentNum; j++) {
            if(arr[i][S_AVG] < arr[j][S_AVG])
               arr[i][S_RANK]++;
         }
      }
   }
   
   // �Է� ������� ���
   static void basicPrint(float[][] arr) {
      if(studentNum != 0) {
         // ��� ���
         for(String str : form)
            System.out.print(str + "\t");
         System.out.println();
         
         // ������ ���
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
         System.out.println("�Է� ���� �����ϴ�.");
      }
   }
   
   // �������� �������� ���
   static void rankDesc(float[][] arr) {
      if(studentNum != 0) {
         // ��� ���
         for(String str : form)
            System.out.print(str + "\t");
         System.out.println();
         
         // ������ ���
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
         System.out.println("�Է� ���� �����ϴ�.");
      }
   }
   
   //���� ���� ���� �������� ���
   static void mathAsc(float[][] arr) {
      if(studentNum != 0) {
         // �ε����� �����س��� �迭 ����
         int[] saveIndex = new int[studentNum];
         
         // 0 ~ �л����� ������� ����
         for(int i = 0; i < saveIndex.length; i++)
            saveIndex[i] = i;
         
         int basePos = 0;
         for(int i = 0; i < saveIndex.length - 1; i++) {
            // basePos�� i�� ����
            basePos = i;
            
            for(int j = i + 1; j < saveIndex.length; j++) {
               // i ���� ������ �˻��ϸ鼭 i���� ū ���� ������ basePos�� ����
               if(arr[basePos][S_MATH] > arr[j][S_MATH]) {
                  basePos = j;
               }
            }
            
            // for�� ���� �� i�� basePos�̶� �� �ٲ�
            int tmp = saveIndex[i];
            saveIndex[i] = saveIndex[basePos];
            saveIndex[basePos] = tmp;
         }
         
         // ��� ���
         for(String str : form)
            System.out.print(str + "\t");
         System.out.println();
         
         // �迭�� �ε��� ������� ���
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
         System.out.println("�Է� ���� �����ϴ�.");
      }
   }

}