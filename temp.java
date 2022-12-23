class Mammal
{
	public void method(Mammal m)
	{
		System.out.println("At top");
	}
}

class Cattle extends Mammal
{
	public void method(Cattle c)
	{
		System.out.println("At cattle");
	}
}

class Horse extends Cattle
{
	public void method(Horse e)
	{
		System.out.println("At horse");
	}
}

class temp{
	public static void main(String args[])
	{
		Cattle c = new Horse();
		Mammal h = new Horse();
		c.method(h);
	}
}
