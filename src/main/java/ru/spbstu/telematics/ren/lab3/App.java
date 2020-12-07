package ru.spbstu.telematics.ren.lab3;

/**
 * Hello world!
 *
 */
public class App 
{

	public static void main( String[] args )
	{
		CheeseShop a=new CheeseShop();
		Thread t1=new BraveCustomer("храбрые покупатели",a);
		t1.setPriority(1);
		Thread t2=new BraveCustomer("храбрые покупатели",a);
		t2.setPriority(1);
		Thread t3=new HumbleCustomer("смиренные покупатели",a);
		t3.setPriority(9);
		Thread t4=new HumbleCustomer("смиренные покупатели",a);
		t4.setPriority(9);
		t3.start();
		t4.start();
		t1.start();
		t2.start();
	}
}
