class Clock
{
	private int hour, minute, second;
	
	Clock() {
		hour = 12;
		minute = 0;
		second = 0;
	}
	
	Clock(int h, int m, int s) {
		setSecond(s);
		setMinute(m);
		setHour(h);
	}
	
	Clock(int s) {
		setClock(s);
	}
	
	public void setClock(int s) {
		hour = s / 3600;
		s %= 3600;
		
		minute = s / 60;
		s %= 60;
		
		second = s;
	}
	
	public int getHour() {
		return hour;
	}
	
	public int getMinute() {
		return minute;
	}
	
	public int getSeconds() {
		return second;
	}
	
	public void setHour(int h) {
		if(h < 0) {
			hour = 24 + h;
			return;
		}
			
		hour = h % 24;
	}
	
	public void setMinute(int m) {
		if(m < 0) {
			setHour(hour - 1);
			minute = 60 + m;
			return;
		}
		
		if(m > 59) setHour(hour + 1);
		minute = m % 60;
	}
	
	public void setSecond(int s) {
		if(s < 0) {
			setMinute(minute - 1);
			second = 60 + s;
			return;
		}	
		
		if(s > 59) setMinute(minute +1);
		second = s % 60;
	}
	
	public void tick()
	{
		setSecond(second + 1);
	}
	
	public void tickDown()
	{
		setSecond(second - 1);
	}
	
	@Override
	public String toString()
	{
		String time = "";
		time += (hour <10) ? "0"+hour : hour;
		time += (minute <10) ? ": 0"+minute : ": " + minute;
		time += (second <10) ? ": 0"+second : ": " + second;
		
		return time;
	}
	
	public void addClock(Clock clock) {
		this.setHour(this.hour + clock.getHour());
		this.setMinute(this.minute + clock.getMinute());
		this.setSecond(this.second + clock.getSeconds());
	}
	
	public void subtractClock(Clock clock) { 
		this.setHour(this.hour - clock.getHour());
		this.setMinute(this.minute - clock.getMinute());
		this.setSecond(this.second - clock.getSeconds());
	}
}