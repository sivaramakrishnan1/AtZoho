class Exceptions extends Exception
{
	Exceptions(String e) {
		super(e);
	}
}

class UserNotFoundException extends Exception
{
	UserNotFoundException() 
	{
		super("UserNotFound : Make sure the inputs are correct");
	}
}

class InsufficentBalanceExeption extends Exception
{
	InsufficentBalanceExeption() 
	{
		super("InsufficeBalance : Not enough resource to proceed the transaction");
	}
}

class PasswordMismatchException extends Exception
{
	PasswordMismatchException()
	{
		super("PasswordMismatch : Re-enter password or try resetting");
	}
}