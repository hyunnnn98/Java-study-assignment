package testPkg;

public class Quiz22_2 {
	public static void main(String[] args) {
		boolean result = compareTo(
						new String("���ڿ� 1").toCharArray(),
						new String("���ڿ� 1").toCharArray()
						);
		
		System.out.println(result ? "����" : "�ٸ�");
	}

	public static boolean compareTo(char arg1[], char arg2[]) {
		// arg1,arg2 �� �� ��ġ >> true, ����ġ >> false ��ȯ
		
		// 1. ���ڿ� ���̸� ���� �ٸ��� ���ϰ� false
		if(arg1.length != arg2.length)
			return false;
		// 2. ���ڿ� ���̰� ������ �ΰ��� ���ڿ��� ���ϰ� ��ȯ�� ����
		else {
			int trueCount = 0;
			// �ΰ��� ���� ��
			for(int i = 0; i < arg1.length; i++) {
				if(arg1[i] == arg2[i]) 
					trueCount++;
			}
			// �ΰ��� ���ڰ� ���� ���� ��
			if(trueCount == arg1.length)
				 return true;
			// �ΰ��� ���ڰ� �ٸ� ��
			else return false;
		}
	}
}
