package ru.spbstu.telematics.ren.lab3;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CheeseShop {
	private final Lock lock = new ReentrantLock();
	private final Condition condition = lock.newCondition();
	static int cheese=10000;//доступный сыр
	static int i=0;// Количество храбрых покупателей в настоящее время 
	static int num=0;// Номер покупателя, подавшего заявку на обслуживание
	static Random random = new Random();
	public void getCheese(String name)
	{
		lock.lock();
		try {
			int lin=++num;

			try {
				int servicehours=random.nextInt(100)+200;
				Thread.sleep(servicehours);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			cheese(name,lin);
			i--;
			if(i==0)
				condition.signalAll();

		} finally {
			lock.unlock();
		}

	}
	public void waitcheese(String name) 
	{
		lock.lock();
		int lin =++num;
		try {
			while(i!=0)
			{
				try {
					if (condition.await(1, TimeUnit.SECONDS)) {

					} else {
						break;
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			try {
				int servicehours=random.nextInt(100)+200;
				Thread.sleep(servicehours);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			cheese(name,lin);

		} finally {
			lock.unlock();
		}
	}


	public void cheese(String name,int serialnum) {
		cheese--;
		String s="Завершение обслуживания ";
		s+=serialnum;
		s+="-го клиента(";
		s+=name;
		s+="):";
		System.out.println(s);
		System.out.println("Оставшееся количество сыра:"+cheese);
	}
}
