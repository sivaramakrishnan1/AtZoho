class Transaction
{
	int tid;
	User from, to;
	double amount, commision;
	boolean isZCoinTransaction = false;
	
	Transaction(int tid, User from, User to, double amount, double commision, boolean transaction)
	{
		this.tid = tid;
		this.from = from;
		this.to = to;
		this.amount = amount;
		this.commision = commision;
		this.isZCoinTransaction = transaction;
	}
	
	@Override
	public String toString()
	{
		return String.format("|%-10s|%-10s|%-10s|%-10s|%-10s|", from.zid, to.zid, amount, commision, (isZCoinTransaction) ? "ZCurrency" : "Rcurrency");
	}	
}