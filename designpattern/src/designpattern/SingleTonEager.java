package designpattern;

class B
{
	private static B obj= new B();//Eager
	
	 private B()
	{
		
	}
	
	 public static B getB()
	 {
		 return obj;
	 }
	
	void display()
	{
		
		System.out.println("Hello");
	}
	
}

public class SingleTonEager {
	
	public static void main(String args[])
	{
		
		B b=B.getB();
		b.display();
		
		B b1=B.getB();
		b1.display();
	}

}
