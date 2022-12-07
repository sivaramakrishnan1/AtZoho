class Areas {
	private int length, breadth;
	
	Areas(int l, int b) {
		this.length = l;
		this.breadth = b;
	}
	
	public int returnArea() {
		return this.length * this.breadth;
	}
}