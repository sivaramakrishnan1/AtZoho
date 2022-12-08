import java.util.Scanner;

class ComplexDemo
{
	public static void main(String args[])
	{		
		Scanner s = new Scanner(System.in);
		Complex c1 = new Complex(s.nextInt(), s.nextInt());
		Complex c2 = new Complex(s.nextInt(), s.nextInt());
		Complex res;

		res = c1.add(c2);
		System.out.println(res.getReal() + " " + res.gerImag() + "i");
		res = c1.sub(c2);
		System.out.println(res.getReal() + " " + res.gerImag() + "i");
		res = c1.mul(c2);
		System.out.println(res.getReal() + " " + res.gerImag() + "i");
		res = c1.div(c2);
		System.out.println(res.getReal() + " " + res.gerImag() + "i");
		
		s.close();
	}
}

class Complex {
	private int real, imag;
	
	Complex(int r, int i) {
		real = r;
		imag = i;
	}
	
	public int getReal() {
		return real;
	}
	
	public int gerImag() {
		return imag;
	}
	
	public Complex add(Complex c) {
		int r = this.real + c.getReal();
		int i = this.imag + c.gerImag();
		
		return new Complex(r, i);
	}
	
	public Complex sub(Complex c) {
		int r = this.real - c.getReal();
		int i = this.imag - c.gerImag();

		return new Complex(r, i);
	}
	
	public Complex mul(Complex c) {
		int r = this.real * c.getReal();
		int i = this.imag * c.gerImag();
		
		return new Complex(r, i);
	}
	
	public Complex div(Complex c) {
		int r = this.real / c.getReal();
		int i = this.imag / c.gerImag();
		
		return new Complex(r, i);
	}
}