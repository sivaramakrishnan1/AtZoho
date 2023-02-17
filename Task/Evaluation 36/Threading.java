class Threading
{
	public static void main(String args[])
	{
		OddPrinter op = new OddPrinter();
		EvenPrinter ep = new EvenPrinter();
		op.start();
		ep.start();		
	}
}

class OddPrinter extends Thread{
	public void run() {
		for(int i = 1 ; i < 10 ; i += 2)
			System.out.print(i + " ");
	}
}
class EvenPrinter extends Thread{
	public void run() {
		for(int i = 0 ; i < 10 ; i += 2)
			System.out.print(i + " ");
	}
}