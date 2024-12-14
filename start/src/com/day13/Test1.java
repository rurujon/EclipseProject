package com.day13;

//Interface
//1. 추상 클래스의 일종이며, 선언만 있고 정의가 없다.
//2. final 변수만 정의할 수 있다.
//3. Interface를 구현하기 위해서는 implements를 사용한다.
//4. 하나 이상의 인터페이스를 구현한 클래스는 인터페이스의
//	 모든 메서드를 Override해야한다
//5. Interface는 다중구현이 가능하다.
//6. 강제성의 의미를 가지고 있다.
//7. Interface 가 다른 Interface를 상속받을 수 있다. 그때는 extands를 사용한다.
//

interface Fruit{//public static final 이 생략되어 있다.
	String Won = "원";//만들 때 초기화를 해야한다.
	
	int getPrice();		//public abstract 가 생략되어 있다.
	public String getName();//abstract가 생략되어 있다.
	
	//public void print() {	} : 일반 메서드를 만들 수 없다.
	
}

class Inter implements Fruit{
//class FruitImpl inmplements Fruit	

	@Override
	public int getPrice() {
		return 1000;
	}

	@Override
	public String getName() {
		return "사과";
	}
	
	public String getItems() {
		return "과일";
	}
	
}

public class Test1 {

	public static void main(String[] args) {
		
		Inter ob1 = new Inter();
		//Fruit ob1 = new Inter(); upcast 되었다. 조건 : 자신만의 메서드를 가지고 있으면 안 된다.
		
		System.out.println(ob1.getItems());
		System.out.println(ob1.getName());
		System.out.println(ob1.getPrice() + Fruit.Won);
		
		//번외
		
		Fruit ob2 = ob1; //upcast
		System.out.println(ob2.getName());
		System.out.println(ob2.getPrice());
		//System.out.println(ob2.getItems()); 부모는 자식 걸 쓸 수 없다.

	}

}
