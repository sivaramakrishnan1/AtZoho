class MessageMain
{
	public static void main(String args[])
	{
		FirstClass fc = new FirstClass();
		SecondClass sc = new SecondClass();
		
		fc.message();
		sc.message();
	}
}

abstract class Parent {
	public void message() {
		return;
	}
}

class FirstClass extends Parent {
	public void message() {
		System.out.println("From the first class");
	}
}

class SecondClass extends Parent {
	public void message() {
		System.out.println("From the second class");
	}
}