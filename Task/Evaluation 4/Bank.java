class Bank
{
	private double balance, minBalance, minBalancePenalty, monthlyCharge;
	
	Bank(double balance, double minBalance, double minBalancePenalty, double monthlyCharge)
	{
		this.balance = balance;
		this.minBalance = minBalance;
		this.minBalancePenalty = minBalancePenalty;
		this.monthlyCharge = monthlyCharge;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}
	
	public void setMinBalancePenalty(double minBalancePenalty) {
		this.minBalancePenalty = minBalancePenalty;
	}
	
	public void setMonthlyCharge(double monthlyCharge) {
		this.monthlyCharge = monthlyCharge;
	}
	
	public void monthsPassed(int n) 
	{
		for(int i = 0  ; i < n ; i++)
		{
			balance -= balance / monthlyCharge;
			if(balance < minBalance)
			{
				balance -= minBalancePenalty;
			}
		}
	}
}