package school_Project;

public class school_2_Example006 {
	public static void main(String[] args) {
		// 빛이 태양에서 출발하여 지구까지 도달하는 시간 계산
		
		// 태양에서 지구까지 거리 : 약 1억 5천만 km
		// 빛의 속도 : 30만km
		
		final double DISTANCE 	= 150_000_000;
		final double SPEED		= 300_000;
		
		double time				= DISTANCE / SPEED;
		
		System.out.println(time);
		System.out.println("===================");
		System.out.println("지수표현법으로 바꾼 값");
		// 지수 표현법으로 바꾼 time value
		System.out.printf("%e", time);
		
	}
}
