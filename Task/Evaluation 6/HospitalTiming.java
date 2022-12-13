package Hospital;

class HospitalTiming
{
	static int id = 100;
	private int pid;
	private String name;
	private int[] prof = new int[2];
	private int[] inDoc = new int[2];
	private int[] outDoc = new int[2];
	private int[] pharm = new int[2];
	private int docTime = 0, waitMins = 0;
	
	HospitalTiming()
	{
		pid = 0;
	}
	
	HospitalTiming(String name, int arrHour, int arrMin, int docTime, HospitalTiming prevTime)
	{
		this.name = name;
		this.pid = id++;
		this.docTime = docTime;
		
		if(prevTime.getPatientId() == 0)
		{
			prof[1] = arrMin % 60;
			prof[0] = arrHour % 24;
			
			inDoc[1] = (prof[1] + 5) % 60;
			inDoc[0] = prof[0] + ((prof[1] + 5) / 60);
			
			pharm[1] = (docTime + inDoc[1]) % 60;
			pharm[0] = inDoc[0] + ((docTime + inDoc[1]) / 60);
		}
		else
		{
			int[] out = prevTime.getProfOut();
			waitMins = (out[1] - arrMin > 0) ? (out[1] - arrMin) : 0;
			prof[1] = (arrMin > out[1]) ? arrMin % 60 : out[1] % 60;
			prof[0] = arrHour % 24;
			if((arrMin + (out[1] - arrMin))  > 60) prof[0] += (arrMin + (out[1] - arrMin))  / 60;
			
			out = prevTime.getDocOut();
			waitMins += (out[1] - getProfOut()[1] > 0) ? (out[1] - getProfOut()[1]) : 0;
			inDoc[1] = (prof[1] > out[1]) ? prof[1] % 60 : out[1] % 60;;
			inDoc[0] = out[0] + ((prof[1] + 5 + out[0]) / 60);
			
			out = prevTime.getPharmOut();
			waitMins += (out[1] - getDocOut()[1] > 0) ? (out[1] - getDocOut()[1]) : 0;
			pharm[1] = (getDocOut()[1] > out[1]) ? getDocOut()[1] : out[1];
			pharm[0] = out[0] + ((docTime + inDoc[1]) / 60);
		}
	}
	
	public int getPatientId()
	{
		return pid;
	}
	
	public int[] getProfOut()
	{
		int[] time = {this.prof[0], this.prof[1]+5};
		return time;
	}
	
	public int[] getDocOut()
	{
		int[] time = {this.inDoc[0], (this.inDoc[1] + this.docTime)};
		return time;
	}
	
	public int[] getPharmOut()
	{
		int[] time = {this.pharm[0], (this.pharm[1]+5)};
		if(time[1] > 60)
		{
			time[1] %= 60;
			time[0] += (time[1] / 60);
		}
		return time;
	}
	
	public int[] gotOut()
	{
		int[] time = {getPharmOut()[0], (getPharmOut()[1]+5)};
		if(time[1] > 60)
		{
			time[1] %= 60;
			time[0] += (time[1] / 60);
		}
		return time;
	}
	
	public String toString()
	{
		String str = pid + "\t\t";
		str += name + "\t\t";
		str += docTime + "\t\t";
		/* str += getProfOut()[0] + "." + getProfOut()[1] + "\t";
		str += getDocOut()[0] + "." + getDocOut()[1] + "\t";
		str += getPharmOut()[0] + "." + getPharmOut()[1] + "\t"; */
		str += gotOut()[0] + "." + gotOut()[1] + "\t\t";
		str += waitMins;
		
		return str;
	}
	
}