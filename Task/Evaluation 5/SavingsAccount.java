class SavingsAccount extends BankAccount
{
	private float interestRate;
	
	SavingsAccount(float rate)
	{
		interestRate = rate;
	}
	
	SavingsAccount(float rate, float bal)
	{
		super(bal);
		interestRate = rate;
	}
	
	public void addCompoundInterest()
	{
		float interest = (super.getBalance() * interestRate) / 100;
		deposit(interest);
	}
}