package javasmmr.zoowsome.employees;

public class CaretakerException extends Exception
{
   private static final long serialVersionUID = 1L;

   public CaretakerException()
   {
      super();
   }

   public CaretakerException(String message)
   {
      super(message);
   }

   public CaretakerException(Throwable cause)
   {
      super(cause);
   }

   public CaretakerException(String message, Throwable cause)
   {
      super(message, cause);
   }
}