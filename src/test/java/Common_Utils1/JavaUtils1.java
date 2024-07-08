package Common_Utils1;

import java.util.Random;

public class JavaUtils1 
{
	public int getRandomNumber()
	{
		//it is non static thats why we have to create a object 
		Random r = new Random();
	    int ran = r.nextInt(1000);
		return ran;
	}
}
