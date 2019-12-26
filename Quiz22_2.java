package testPkg;

public class Quiz22_2 {
	public static void main(String[] args) {
		boolean result = compareTo(
						new String("문자열 1").toCharArray(),
						new String("문자열 1").toCharArray()
						);
		
		System.out.println(result ? "같음" : "다름");
	}

	public static boolean compareTo(char arg1[], char arg2[]) {
		// arg1,arg2 비교 후 일치 >> true, 불일치 >> false 반환
		
		// 1. 문자열 길이를 비교해 다르면 리턴값 false
		if(arg1.length != arg2.length)
			return false;
		// 2. 문자열 길이가 같으면 두개의 문자열을 비교하고 반환값 도출
		else {
			int trueCount = 0;
			// 두개의 문자 비교
			for(int i = 0; i < arg1.length; i++) {
				if(arg1[i] == arg2[i]) 
					trueCount++;
			}
			// 두개의 문자가 전부 같을 때
			if(trueCount == arg1.length)
				 return true;
			// 두개의 문자가 다를 때
			else return false;
		}
	}
}
