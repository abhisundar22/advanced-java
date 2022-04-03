package designpattern;


class A
{
	static A a;//static ins variable of clas type A
	
	private A() //private construstor i cannot create obect outside the class
	{
		
	}
	
	static A getA()//return type is A //static method  which return type is class A
	{
		if(a==null){
			a= new A();// only one time the object is created //object123 //Lazy
			return a;
			}
			else
			{
				return a;
			}
		
	}
	
	void display()
	{
		System.out.println("Hello");
	}
	
}

public class TestSingleton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*A a= new A();
		A a1=new A();*/
		
		A a = A.getA();// object123
		a.display();
		
		
      A a1=A.getA(); //object123
		

	}

}
