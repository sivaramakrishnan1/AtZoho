import java.util.Scanner;

class LeapYearMain {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        LeapYear y = new LeapYear(s.nextInt());
        System.out.println("Is the year " + y.getYear() + " is Leap year ? : " + y.isLeapYear());
        s.close();
    }
}

class LeapYear {
    private int year;

    LeapYear(int year) {
        this.year = year;
    }

    public int getYear()
    {
        return this.year;
    }

    public boolean isLeapYear() {
        if(year % 4 != 0) return false;
        if(year % 100 == 0 && year % 400 != 0) return false;
        return true;
    }
}