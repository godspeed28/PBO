package implementasi;

public class TestAc {

	public static void main(String[] args) {
		AC ac = new AC(20);
		ac.setOn();
		ac.setCool();
		ac.setChill();
		ac.setDry();
		ac.setSuhu();
		ac.setDry();
		ac.setSuhu();
		ac.checkSuhu();
		ac.setChill();
		ac.checkMode();
	}

}
