package implementasi;

public interface AirConditioner {
	public static final int acStateOn = 1;
	public static final int acStateOff = 0;
	
	public abstract void setOn();
	public abstract void setOff();
	public abstract int setSuhu();
	
	public abstract void setCool();
	public abstract void setDry();
	public abstract void setChill();
}
