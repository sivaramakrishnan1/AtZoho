import java.util.Scanner;

class BankDemo
{
	public static void main(String args[])
	{		
		Scanner s = new Scanner(System.in);
		BankA ba = new BankA(5000);
		BankB bb = new BankB(8000);
		BankC bc = new BankC(9000);
		
		System.out.println(ba.getBalance() + "\n" + bb.getBalance() + "\n" + bc.getBalance());
		s.close();
	}
}

abstract class Bank
{
	public int balance;
	
	Bank(int balance)
	{
		this.balance = balance;
	}
	
	public int getBalance() {
		return 0;
	}
}

class BankA extends Bank {
	BankA(int balance) {
		super(balance);
	}
	
	@Override
	public int getBalance() {
		return this.balance;
	}
	
}

class BankB extends Bank {
	BankB(int balance) {
		super(balance);
	}
	
	@Override
	public int getBalance() {
		return this.balance;
	}
}

class BankC extends Bank {
	BankC(int balance) {
		super(balance);
	}
	
	@Override
	public int getBalance() {
		return this.balance;
	}
}