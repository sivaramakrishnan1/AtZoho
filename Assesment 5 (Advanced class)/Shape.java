import java.util.Scanner;

class ShapeDemo
{
	public static void main(String args[])
	{		
		Scanner s = new Scanner(System.in);
		Area rec = new Area();
		
		rec.setDim(s.nextInt(), s.nextInt());
		
		System.out.println(rec.getArea());
		s.close();
	}
}

class Area{
	private int len, wid;
	
	public void setDim(int len, int wid) {
		this.len = len;
		this.wid = wid;
	}
	
	public int getArea() {
		return len*wid;
	}
}