public class Student3
{
	private String name, phno, address;
	private int rollno;
	
	Student3 (String name, int rollno, String phno, String address) 
	{
		this.name = name;
		this.rollno = rollno;
		this.phno = phno;
		this.address = address;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getRollNo() {
		return this.rollno;
	}
	
	public String getPhNo() { 
		return this.phno;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public void printDetails() {
		System.out.println("\n\nName: " + getName() + "\nRoll No : " + getRollNo() + "\nAddress : \n" + getAddress() + "\nPhone number :" + getPhNo());
	}
}