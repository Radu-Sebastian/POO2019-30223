package convertor_valutar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConvertorValutarController 
{
	private ConvertorModel model;
	private ConvertorView view;

	ConvertorValutarController(ConvertorModel c_model, ConvertorView c_view) 
	{
		model = c_model;
		view = c_view;
		view.addConvertListener(new convertListener());
	}

	public class convertListener implements ActionListener
    {
   	  public void actionPerformed(ActionEvent e)
   	  {
   		 String input = "";

   		 try
   		 {
   			 input = view.getUserInput();

   			 if(view.getFromCurrency() == "RON")
   			 {
   				 view.setInput("RON");
   				 
   				 if(view.getToCurrency() == "RON")
   				 {
   					 model.setValue(String.valueOf(Integer.parseInt(input)));
   					 view.setOutput("RON");
   				 }
   				 
   				 if(view.getToCurrency() == "USD")
   				 {
   					 model.setValue(String.valueOf(Math.floor(Integer.parseInt(input) * 0.23 * 100)/100));
   					 view.setOutput("USD");
   				 }
   					 
   				 if(view.getToCurrency() == "EUR")
   				 {
   					 model.setValue(String.valueOf(Math.floor(Integer.parseInt(input) * 0.20 * 100)/100));
   					 view.setOutput("EUR");
   				 }
   			 }
   			 else if(view.getFromCurrency() == "USD")
      		 {
   				view.setInput("USD");
   				
   				 if(view.getToCurrency() == "USD")
  				 {
   					 model.setValue(String.valueOf(Integer.parseInt(input)));
   	 				 view.setOutput("USD");
  				 }
   				 
      			 if(view.getToCurrency() == "RON")
      			 {
      				 model.setValue(String.valueOf(Math.floor(Integer.parseInt(input) * 4.29 * 100)/100));
      			     view.setOutput("RON");
      			 }
      					 
      			 if(view.getToCurrency() == "EUR")
      			 {
      				 model.setValue(String.valueOf(Math.floor(Integer.parseInt(input) * 0.89 * 100)/100));
      				 view.setOutput("EUR");
      			 }
      		 }
   			 else if(view.getFromCurrency() == "EUR")
         	 {
   				view.setInput("EUR");
   				
   				 if(view.getToCurrency() == "EUR")
 				 {
   					 model.setValue(String.valueOf(Integer.parseInt(input)));
   					 view.setOutput("EUR");
 				 }
   				
         		 if(view.getToCurrency() == "RON")
         		 {
         			 model.setValue(String.valueOf(Math.floor(Integer.parseInt(input) * 4.77 * 100)/100));
              		 view.setOutput("RON");
         		 }
         					 
         		 if(view.getToCurrency() == "USD")
         		 {
         			 model.setValue(String.valueOf(Math.floor(Integer.parseInt(input) * 1.11 * 100)/100));
              		 view.setOutput("USD");
         		 }
         	}
   			 
   			 view.convertCurrency(model.getValue());
   			
   		 }	 catch(NumberFormatException ee) 
   			{
   				view.showError("error");
   			}
   	   }
   	 }

}
