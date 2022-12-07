public class Area{
	int length = 0, breadth = 0;
	
	public void setDim(int l, int b)
	{
		this.length = l;
		this.breadth = b;
	}
	
	public int getArea()
	{
		return (this.length * this.breadth);
	}
}