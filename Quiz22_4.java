package testPkg;

public class Quiz22_4 {
	public static void main(String[] args) {
		char result[] = replace(
							new String("abcdefg").toCharArray(),
							new String("cdef").toCharArray(),
							new String("k").toCharArray()
				);
		System.out.println(result);
				
	}
	
	public static char[] replace(char arg1[], char arg2[], char arg3[]) {
		char[] newArray;
		for(int i = 0; i < arg1.length; i++) {
			if(arg1[i] == arg2[0]) {
				int answerCount = 0;
				for(int j = 0; j < arg2.length; j++) {
					if(arg1[i + j] == arg2[j]) {
						answerCount++;
						// arg2�� ���� ���� arg1�� ���� ��� return�� ��ȯ
						if(answerCount == arg2.length) {
							// ���ο� �迭�� length ����
							newArray = new char[arg1.length - arg2.length + arg3.length];
							int newArrayCount = 0;
							// arg2ã�� �������� �迭 ���� �� �ֱ�
							for(int idxValue = 0; idxValue < i; idxValue++, newArrayCount++) {
								newArray[newArrayCount] = arg1[idxValue];
							}
							
							// arg2 ��� arg3 �� �ֱ�
							for(int inputArg3 = 0; inputArg3 < arg3.length; inputArg3++, newArrayCount++) {
								newArray[newArrayCount] = arg3[inputArg3];
							}
							// �ٲ� ���� �� ��ȣ���� �ֱ�
							for(int nomalArg1 = i + j + 1; nomalArg1 < arg1.length; nomalArg1++, newArrayCount++) {
								newArray[newArrayCount] = arg1[nomalArg1]; 
							}
							// �ٲ� �迭 return
							return newArray;
						}
					}
				}
			}
		}
		// �ٲ��� �ʾ��� ��� arg1 return
		return arg1;
	}
}
