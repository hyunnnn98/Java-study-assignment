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
		// arg1에서 arg2와 같은 값이 있나 없나 찾은 후 찾을 시 찾은 arg1의 첫번 째 indexCount를 리턴.
		// 찾지 못할 시 -1 리턴
		for(int i = 0; i < arg1.length; i++) {
			if(arg1[i] == arg2[0]) {
				int answerCount = 0;
				for(int j = 0; j < arg2.length; j++) {
					if(arg1[i + j] == arg2[j]) {
						answerCount++;
						// arg2의 값이 전부 arg1에 있을 경우 return값 반환
						if(answerCount == arg2.length) return i;
					}
				}
			}
		}
		return -1;
	}
}

