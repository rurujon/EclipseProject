package com.day13;

import java.util.Scanner;

interface FruitA{
	
	String Won = "��";
	
	public int getPrice();
	public String getName();
	
}

interface ItemFruit extends FruitA{
	
	public String getItems();
}

class Orange implements ItemFruit{

	@Override
	public int getPrice() {
		return 1500;
	}

	@Override
	public String getName() {
		return "������";
	}

	@Override
	public String getItems() {
		return "����";
	}
	
}

class Apple implements ItemFruit{

	@Override
	public int getPrice() {
		return 2000;
	}

	@Override
	public String getName() {
		return "���";
	}

	@Override
	public String getItems() {
		return "����";
	}
	
}

public class Test3 {
	
	public void packing(ItemFruit ob) {
		System.out.println(ob.getItems());
		System.out.println(ob.getName());
		System.out.println(ob.getPrice() + Fruit.Won );
		
	}

	public static void main(String[] args) {
		//ItemFruit ob
		//			ob = new Apple();
		//			ob = new Orange();
		
		Scanner sc = new Scanner(System.in);
		
		Test3 t = new Test3();
		
		System.out.println("1.���? 2.������?");
		int n = sc.nextInt();
		
		if(n==1) {
			t.packing(new Apple());
		}
		
		else if(n==2) {
			t.packing(new Orange());
		}//Ŭ������ �������̽��� ��ĳ����
		
		//ItemFruit ob1 = new Orange();
		//ob1.getItems();
		/*System.out.println(ob.getItems());
		System.out.println(ob.getName());
		System.out.println(ob.getPrice() + Fruit.Won );*/
		
		
		
		//ItemFruit ob2 = new Apple();
		//ob2.getItems();
		/*System.out.println(ob.getItems());
		System.out.println(ob.getName());
		System.out.println(ob.getPrice() + Fruit.Won );*/
		

	}

}

/*
int a;

a=10;
System.out.print(a);//10

a= 20;
Syso(a);//20
*/