class Student
{
	private String name = "";
	private int rollno = 0;
	
	Student(String name, int rollno) {
		this.name = name;
		this.rollno = rollno;
	}
	
	public void printDetails()
	{
		if(name == "" && rollno == 0) return;
		
		System.out.println("Details: \n\tName: " + this.name + "\n\tRoll. No.: " + this.rollno);
	}
}