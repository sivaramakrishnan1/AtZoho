class InterestBank extends Bank
{
	private int interestRate;
	
	InterestBank(double balance, double minBalance, double minBalancePenalty, double monthlyCharge, int interestRate)
	{
		super(balance, minBalance, minBalancePenalty, monthlyCharge);
		this.interestRate = interestRate;
	}
	
	
	
}