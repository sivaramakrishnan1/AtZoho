class Complex
{
	private double real, imag;
	
	Complex() {
		real = 0;
		imag = 0;
	}
	
	Complex(int r, int i) {
		real = r;
		imag = i;
	}
	
	public double getRealPart() {
		return real;
	}
	
	public double getImaginaryPart() {
		return imag;
	}
	
	public void setRealPart(double r) {
		real = r;
	}
	
	public void setImaginaryPart(double i) {
		imag = i;
	}
	
	public void add(Complex c) {
		this.real += c.getRealPart();
		this.imag += c.getImaginaryPart();
	}
	
	public void subtract(Complex c) {
		this.real -= c.getRealPart();
		this.imag -= c.getImaginaryPart();
	}
	
	public void multiply(Complex c) {
		System.out.println(real + " " + imag);
		double r = (real*c.getRealPart()) - (imag * c.getImaginaryPart());
		double i = ((imag * c.getRealPart() + real*c.getImaginaryPart()));
		this.setRealPart(r);
		this.setImaginaryPart(i);
		System.out.println(real + " " + imag);
	} 
	
	public void divide(Complex c) {
		multiply(c);
		double div = (c.getRealPart() * c.getRealPart()) + (c.getImaginaryPart() * c.getImaginaryPart());
		double r = real / div;
		double i = imag / div;

		setRealPart(i);
		setImaginaryPart(r);
		System.out.println(real + " " + imag + " " + div);
	}
		
	public String toString() {
		String res = "";
		if(real != 0) res += real + " " ;
		if(imag != 0) res += imag + "i";
		return res;
	}
}