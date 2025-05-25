package implementasi;

public class AC implements AirConditioner {
	private int acState = 0;
	private int suhu = 0;
	private int coolState = 0;
	private int dryState = 0;
	private int chillState = 0;
	
	public AC(int suhu)
	{
		this.suhu = suhu;
	}
	
	@Override
	public void setOn() {
		// TODO Auto-generated method stub
		if(this.acState == acStateOff)
		{
			this.acState = acStateOn;
			System.out.println("AC dihidupkan dengan suhu "+this.suhu);
		}
		else
		{
			System.out.println("AC sudah hidup dengan suhu "+this.suhu);
		}
		

	}

	@Override
	public void setOff() {
		// TODO Auto-generated method stub
		if(this.acState == acStateOn)
		{
			this.acState = acStateOff;
			System.out.println("AC dimatikan");
		}
		else
		{
			System.out.println("AC sudah mati");
		}
	}
	
	@Override
	public int setSuhu()
	{
		//cek apakah AC nyala/mati. Kalau nyala bisa set suhu, kalau mati tidak bisa
		if(this.acState == acStateOn)
		{
			return this.suhu+=1;			
		}
		else
		{
			return this.suhu = 0;
		}
		
		//berikan parameter naik/turun, jika naik this.suhu+=1, jika turun this.suhu-=1
	}

	@Override
	public void setCool() {
		//cek apakah ac nyala/mati
			if(this.coolState == 0)
			{
				this.coolState = 1;
				this.chillState = 0;
				this.dryState = 0;
				System.out.println("Mode sejuk dinyalakan dengan suhu "+this.suhu);
//			System.out.println(this.chillState+" "+this.dryState);
			}
			else
			{
				System.out.println("Mode sejuk sudah nyala dengan suhu "+this.suhu);
			}			
		}



	@Override
	public void setDry() {
		//cek apakah AC nyala/mati
		if(this.dryState == 0)
		{
			this.dryState = 1;
			this.coolState = 0;
			this.chillState = 0;
			System.out.println("Mode kering dinyalakan dengan suhu "+this.suhu);
//			System.out.println(this.coolState+" "+this.chillState);
		}
		else
		{
			System.out.println("Mode kering sudah nyala dengan suhu "+this.suhu);
		}

	}

	@Override
	public void setChill() {
		//cek apakah AC nyala/mati
		if(this.chillState == 0)
		{
			this.chillState = 1;
			this.coolState = 0;
			this.dryState = 0;
			System.out.println("Mode dingin dinyalakan dengan suhu "+this.suhu);
//			System.out.println(this.coolState+" "+this.dryState);
		}
		else
		{
			System.out.println("Mode dingin sudah nyala dengan suhu "+this.suhu);
		}

	}
	
	public void checkSuhu()
	{
		System.out.println("Suhu AC "+this.suhu);
	}
	
	public void checkMode()
	{
		//cek apakah AC nyala/mati
		if(this.chillState == 1)
		{
			System.out.println("Mode Dingin aktif");
		}
		
		if(this.coolState == 1)
		{
			System.out.println("Mode sejuk aktif");
		}
		
		if(this.dryState == 1)
		{
			System.out.println("Mode kering aktif");
		}
	}

}
