class CheckingAccount extends BankAccount
{
	private final float ALLOWED_TRANS = 2, TRANS_FEE = 3;
	private int transactionCount = 0;
	
	CheckingAccount() 
	{
		super();
	}
	
	CheckingAccount(float bal)
	{
		super(bal);
	}
	
	@Override
	public void deposit(float dep)
	{
		++transactionCount;		
		super.deposit(dep);
	}
	
	public void withdraw(float wit)
	{
		++transactionCount;		
		super.withdraw(wit);
	}
	
	public void chargeFees()
	{
		withdraw(TRANS_FEE * (transactionCount - 2));
		transactionCount = 0;
	}
}