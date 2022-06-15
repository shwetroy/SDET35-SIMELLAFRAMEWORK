package generic_Utility;

import java.util.Date;
import java.util.Random;

public class Java_Utility 
{
public int getRandomNum()
{
	Random ran = new Random();
	int rannum = ran.nextInt(1000);
	return rannum;
}
public String  getSystemDateInIST() 
{
	Date date = new Date();
	String currentDate = date.toString();
	System.out.println(currentDate);
	String[] arr = currentDate.split(" ");
	
	String yyyy = arr[5];
	String dd = arr[2];
	int mm = date.getMonth()+1;

		String formate = dd+"-"+mm+"-"+yyyy;
		return formate;
}


}
