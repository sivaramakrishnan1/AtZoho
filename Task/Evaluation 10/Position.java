class Position
{
	int position, moveTo = -1;
	String symbol = " ";
	
	Position(int pos)
	{
		this.position = pos;
	}
	
	public void setMoveTo(int moveTo)
	{
		if(moveTo > 0 && moveTo < 101)
		{
			this.moveTo = moveTo;
		}
	}
}