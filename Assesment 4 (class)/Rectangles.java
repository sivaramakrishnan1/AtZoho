class Rectangles
{
	private int length, breadth;
	
	Rectangles(int l, int b) {
		this.length = l;
		this.breadth = b;
	}
	
	public float Area() {
		return this.length * this.breadth;
	}
}