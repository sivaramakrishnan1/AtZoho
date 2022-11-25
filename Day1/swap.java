class swap {
	public static void main(String args[]) {
		int a = 8, b = 6, temp;
		
		temp = a;
		a = b;
		b = temp;
		
		System.out.println("After swapping witha new variable : " + a + " " + b);		
		
		a = a + b;
		b = a - b;
		a = a - b;
		
		System.out.println("After swapping witha new variable : " + a + " " + b);
	}
}
		