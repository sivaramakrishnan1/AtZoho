class BankAccount
{
	private float balance;
	
	BankAccount() 
	{
		balance = 0;
	}
	
	BankAccount(float bal)
	{
		if(bal > -1)
			balance = bal;
	}
	
	public void deposit(float dep) 
	{
		if(dep > 0)
			balance += dep;
	}
	
	public void withdraw(float wit)
	{
		if(wit > 0)
			balance -= wit;
	}
	
	public float getBalance()
	{
		return balance;
	}
	
	public void transferMoney(BankAccount receiver, float cashToSend)
	{
		this.withdraw(cashToSend);
		receiver.deposit(cashToSend);
	}
	
	public void display()
	{
		System.out.println("Balance: " + balance);
	}
}