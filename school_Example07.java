package school_Project;

public class school_Example07 {
	public static void main(String[] args) {
		int input_Line	= 52; 				// all line
		int copy_Line	= input_Line/2 - 1; // copy half line

		//��ü����
		for(int i = 0; i < input_Line; i++) {
			char ALPHA = 'A';
			//�� ���� ���
			if(i <= input_Line/2) {
				// �� ���ĺ� ���
				for(int j = 0; j < i; j++) {
					System.out.print(ALPHA++);
				}		
				
			//�Ʒ� ���� ���
			}else {
				// �Ʒ� ���ĺ� ���
				for(int k = 0; k < copy_Line; k++) {
					System.out.print(ALPHA++);
				}
				copy_Line--;
				
			}// if�� ����
			
			System.out.println();
		}// for�� ����
	}
}
