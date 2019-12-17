package convertor_valutar;
public class ConvertorModel 
{
	static final String INITIAL_VALUE = "0";
	private String c_total; 
	
	public void setValue(String value) 
	{
		c_total = value;
	}
	
	public String getValue() 
	{
		return this.c_total;
	}
}