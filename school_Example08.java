package school_Project;

public class school_Example08 {
	public static void main(String[] args) {
		int input_Line		= 52; 				// all line
		int up_copy_Line	= input_Line/2 - 1; // copy half line
		int down_copy_Line  = input_Line/2 - 1;
		int middle_Count	= 2;

		//��ü����
		for(int i = 0; i < input_Line; i++) {
			char ALPHA = 'A';	// 'A'�� ��ü ������ �������� �ʱ�ȭ
			char ALPHA_Copy = ' ';
//			�� space ���
			if(i < input_Line/2) {
				//���� �ﰢ��
				for(int j = 0; j <= i; j++) {
					ALPHA_Copy = ALPHA;
					System.out.print(ALPHA++);
				}
				//�߰� ����
				for(int middle_Space = 0; middle_Space < input_Line-2*(i+1); middle_Space++) {
					System.out.print(" ");
				}
				//������ �ﰢ��
				for(int k = 0; k <=i; k++) {
					System.out.print(ALPHA_Copy--);
				}
//			�Ʒ� space ���
			}else {
				//���� �ﰢ��
				for(int j = 0; j < up_copy_Line ; j++) {
					ALPHA_Copy = ALPHA;
					System.out.print(ALPHA++);
				}
				up_copy_Line--;
				//�߰� ����
				for(int under_Space = 0; under_Space < middle_Count ; under_Space++) {
					System.out.print(" ");
				}
				middle_Count+=2;
				//������ �ﰢ��
				for(int k = 0; k < down_copy_Line; k++) {
					System.out.print(ALPHA_Copy--);
				}
				down_copy_Line-=1;
			}// if�� ����
			System.out.println();
		}// for�� ����
	}
}


