package convertor_valutar;

public class ConvertorMain
{
	public static void main(String[] args) 
	{
	    ConvertorModel model = new ConvertorModel();
	    ConvertorView view = new ConvertorView(model);
	    new ConvertorValutarController(model,view); 
	    view.setVisible(true);
	}
}