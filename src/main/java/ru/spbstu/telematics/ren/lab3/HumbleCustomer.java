package ru.spbstu.telematics.ren.lab3;

public class HumbleCustomer extends Thread {
	CheeseShop a;
	String name;
	HumbleCustomer(String name,CheeseShop a)
	{
		this.a=a;
		this.name=name;
	}
	public void run()
	{
		a.waitcheese(name);

		int i2 = CheeseShop.random.nextInt(100)+100;

		try {
			Thread.sleep(i2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		new HumbleCustomer(name,a).start();
	}
}
