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
						// arg2의 값이 전부 arg1에 있을 경우 return값 반환
						if(answerCount == arg2.length) {
							// 새로운 배열의 length 설정
							newArray = new char[arg1.length - arg2.length + arg3.length];
							int newArrayCount = 0;
							// arg2찾기 전까지의 배열 원소 값 넣기
							for(int idxValue = 0; idxValue < i; idxValue++, newArrayCount++) {
								newArray[newArrayCount] = arg1[idxValue];
							}
							
							// arg2 대신 arg3 값 넣기
							for(int inputArg3 = 0; inputArg3 < arg3.length; inputArg3++, newArrayCount++) {
								newArray[newArrayCount] = arg3[inputArg3];
							}
							// 바뀐 원소 뒷 번호부터 넣기
							for(int nomalArg1 = i + j + 1; nomalArg1 < arg1.length; nomalArg1++, newArrayCount++) {
								newArray[newArrayCount] = arg1[nomalArg1]; 
							}
							// 바뀐 배열 return
							return newArray;
						}
					}
				}
			}
		}
		// 바뀌지 않았을 경우 arg1 return
		return arg1;
	}
}
