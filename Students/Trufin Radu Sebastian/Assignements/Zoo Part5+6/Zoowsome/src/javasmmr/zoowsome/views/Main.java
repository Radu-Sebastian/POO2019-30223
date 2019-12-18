package javasmmr.zoowsome.views;
import java.io.File;
import java.net.URISyntaxException;

public class Main 
{
	public static void main(String[] args) throws Exception 
	{
		new MainMenuController(new MainMenuFrame("Zoowsome"), false);
		System.out.println(findJAR());
	}
	
	public static File findJAR() throws URISyntaxException
	{
		return new File(MainMenuController.class.getProtectionDomain().getCodeSource().getLocation().toURI());
	}
}