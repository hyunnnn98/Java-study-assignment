package testPkg;

public class Quiz22_1 {
	public static void main(String[] args) {
		char value1[] = { 'h', 'e', 'l', 'l', 'o' };
		char value2[] = { ' ', 'w', 'o', 'r', 'l', 'd' };
		
		char values[] = concatenate(value1, value2);
		
		System.out.println(values);
	}
	
	public static char[]  concatenate(char arg1[], char arg2[]) {
		// �ΰ��� �迭�� ���� �� �ִ� ���ο� �迭 ����
		char[] newArray = new char[arg1.length + arg2.length];
		for(int i = 0; i < arg1.length; i++) {
			newArray[i] = arg1[i];
		}
		for(int j = arg1.length, idxCount = 0; j < newArray.length; j++, idxCount++) {
			newArray[j] = arg2[idxCount];
		}
		
		return newArray;
	}
}
