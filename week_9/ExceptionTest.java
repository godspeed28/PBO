// package eksepsi;

public class ExceptionTest {
	public static void main(String args[]) {
		int arr[] = new int[10];
		try {
			System.out.println("Access element three :" + arr[10]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Exception thrown  :" + e);
		} finally {
			arr[0] = 6;
			System.out.println("First element value: " + arr[0]);
			System.out.println("The finally statement is executed");
		}
	}
}
