package school_Project;

public class school_Example06 {
	public static void main(String[] args) {
		final int alpha_Count = 26;
		int alpha_Number = 26;
		
		//��ü ���� ���
		for(int i = 0; i < alpha_Count; i++) {
			char alpha_a = 'A';
			
			// �����
			for(int j = 0; j < i; j++) {
				System.out.print("*");		
			}
			// ���ĺ�
			for(int k = 0; k < alpha_Number; k++) {
				System.out.print(alpha_a++);
			}
			alpha_Number--;

			System.out.println();
		}
	}
}
