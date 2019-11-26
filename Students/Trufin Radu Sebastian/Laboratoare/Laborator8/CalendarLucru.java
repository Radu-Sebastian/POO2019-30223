
public class CalendarLucru 
{
	public Zi[] Schedule = new Zi[7];
	
	CalendarLucru()
	{
		Schedule[0] = new Zi();
		Schedule[1] = new Zi();
		Schedule[2] = new Zi();
		Schedule[3] = new Zi();
		Schedule[4] = new Zi();
		Schedule[5] = new Zi();
		Schedule[6] = new Zi();
		Schedule[0].setNume("Luni"); 
		Schedule[1].setNume("Marti"); 
		Schedule[2].setNume("Miercuri"); 
		Schedule[3].setNume("Joi"); 
		Schedule[4].setNume("Vineri"); 
		Schedule[5].setNume("Sambata"); 
		Schedule[6].setNume("Duminica"); 
	}
	
	public Zi getDay(String zi)
	{
		if(zi == "Luni")
		return this.Schedule[0];
		
		if(zi == "Marti")
			return this.Schedule[1];
		else
		if(zi == "Miercuri")
			return this.Schedule[2];
		else
		if(zi == "Joi")
			return this.Schedule[3];
		else
		if(zi == "Vineri")
			return this.Schedule[4];
		else
		if(zi == "Sambata")
			return this.Schedule[5];
		else
			return this.Schedule[6];
	}
	
	public Zi getDayRank(int k)
	{
		return this.Schedule[k];
	}
}
