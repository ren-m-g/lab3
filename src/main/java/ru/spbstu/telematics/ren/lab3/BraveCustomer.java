package ru.spbstu.telematics.ren.lab3;

public class BraveCustomer extends Thread {
	CheeseShop a;
	String name;

	BraveCustomer(String name,CheeseShop a){
		CheeseShop.i++;	
		this.a=a;
		this.name=name;
	}
	public void run()
	{
		a.getCheese(name);


		int i2 = CheeseShop.random.nextInt(200)+300;

		try {
			Thread.sleep(i2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		new BraveCustomer(name,a).start();
	}
}
