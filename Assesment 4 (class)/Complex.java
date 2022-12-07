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
		
		