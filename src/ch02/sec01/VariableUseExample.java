package ch02.sec01;

public class VariableUseExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int hour = 3;
		int min = 5;
		System.out.println(hour + "시간 " + min + "분");
		
		int totalMin = hour * 60 + min;
		System.out.println("총 " + totalMin + "분");
		System.out.println("가나");
		
		int o = 011;
		System.out.println(o);
	}
}