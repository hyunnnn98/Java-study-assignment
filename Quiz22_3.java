package testPkg;

public class Quiz22_3 {
	public static void main(String[] args) {
		int index = indexOf(
				new String("abcde").toCharArray(),
				new String("cd").toCharArray()
				);
		
		System.out.println(index);
	}
	
	public static int indexOf(char arg1[], char arg2[]) {
		// arg1���� arg2�� ���� ���� �ֳ� ���� ã�� �� ã�� �� ã�� arg1�� ù�� ° indexCount�� ����.
		// ã�� ���� �� -1 ����
		for(int i = 0; i < arg1.length; i++) {
			if(arg1[i] == arg2[0]) {
				int answerCount = 0;
				for(int j = 0; j < arg2.length; j++) {
					if(arg1[i + j] == arg2[j]) {
						answerCount++;
						// arg2�� ���� ���� arg1�� ���� ��� return�� ��ȯ
						if(answerCount == arg2.length) return i;
					}
				}
			}
		}
		return -1;
	}
}

