package school_Project;

public class school_2_Example006 {
	public static void main(String[] args) {
		// ���� �¾翡�� ����Ͽ� �������� �����ϴ� �ð� ���
		
		// �¾翡�� �������� �Ÿ� : �� 1�� 5õ�� km
		// ���� �ӵ� : 30��km
		
		final double DISTANCE 	= 150_000_000;
		final double SPEED		= 300_000;
		
		double time				= DISTANCE / SPEED;
		
		System.out.println(time);
		System.out.println("===================");
		System.out.println("����ǥ�������� �ٲ� ��");
		// ���� ǥ�������� �ٲ� time value
		System.out.printf("%e", time);
		
	}
}
