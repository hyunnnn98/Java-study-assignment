package testPkg;

import java.util.Scanner;

public class Quiz21_3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// ����ڷκ��� ���ڿ��� ������ �Է¹ޱ�
		System.out.println("�Է��� ���ڿ��� ����?");
		final int MAX = scan.nextInt();
		String[] user = new String[MAX]; 

		// �������� or �������� �Է¹ޱ�
		System.out.println("���� ��� ����? (1)����, (2)����");
		int range_Control = scan.nextInt();

		//String�� �޾� ���̰� �迭�� ����.
		System.out.println("���� �Է����ּ��� �迭�� �ִ� ���̴�" + MAX + "�Դϴ�.");
		for(int i = 0 ; i < MAX ; i++) {
			user[i] = scan.next();
		}
		System.out.println("String�Է� ��. �迭�� ���� �Ϸ�");

		if(range_Control == 1)
			System.out.println("������������ ������ ����?");
		else
			System.out.println("������������ ������ ����?");

		// �迭�� ����� �� �ִ���̸�ŭ for�� ������
		for(int loop_Count = 0; loop_Count < MAX; loop_Count++) {
			// ù��° ���� ���ϱ� 
			for(int find_1_Idx = loop_Count + 1; find_1_Idx < MAX; find_1_Idx++) {

				// �������� �˰���
				if(range_Control == 1) {
					//�տ� ���� �ڿ� �� ���� ũ�ų� ���� �� �˰������  / ���� �� LOOP2 Ż��
					if(user[loop_Count].charAt(0) >= user[find_1_Idx].charAt(0)) {
						int short_Idx_Lth	= 0;
						int idx_Count		= 0;

						//���⼭ �� ������ length�� ������ �ϳ��ϳ� ��.
						//length�� ���� ���� ���� ���� length�� ���� ����� ������ �� ������ �ʿ���.
						if(user[loop_Count].length() >= user[find_1_Idx].length()) {
							short_Idx_Lth = user[find_1_Idx].length();

						}else short_Idx_Lth = user[loop_Count].length();

						//�� ���ڿ� �� ����
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
						}// �� ���ڿ� �� end
					}
				}// �������� �˰��� end
				else if(range_Control == 2) {

					// �������� �˰���
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
						}// �� ���ڿ� �� end
					}
				}// �������� �˰��� end
			}
			System.out.println(user[loop_Count]);
//			if(loop_Count == MAX - 2) System.out.println(user[loop_Count + 1]);
		}
	}
}
