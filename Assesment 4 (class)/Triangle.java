class Triangle
{
	private int side1, side2, side3;
	
	public void setSides(int s1, int s2, int s3) {
		this.side1 = s1;
		this.side2 = s2;
		this.side3 = s3;
	}
	
	public int getPerimeter() {
		return ( side1 + side2 + side3);
	}
	
	public float getArea() {
		return ( side1 + side2 + side3)/2;
	}
}