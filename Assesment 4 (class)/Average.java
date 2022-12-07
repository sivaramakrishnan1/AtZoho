class Average
{
	private int num1, num2, num3;
	
	Average(int n1, int n2, int n3)
	{
		this.num1 = n1;
		this.num2 = n2;
		this.num3 = n3;
	}
	
	public void printAverage() {
		System.out.println("Average of three numbers: " + ((num1+num2+num3)/3));
	}
}