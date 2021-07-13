package carrental;

public class Date 
{
    private int year;   // 1-12
    private int month;  // 1-31 based on month
    private int day;    // > 0
    
    //constructor: call checkMonth to confirm proper value for month;
    //call checkDay to confirm proper value for day;
    public Date(int theDay, int theMonth, int theYear)
    {
        year = checkYear(theYear);      //validate year
        month = checkMonth(theMonth);   //validate month
        day = checkDay(theDay);         //validate day
        
        System.out.printf("Date object constructor for date %s\n", toString());
    }
    
    //utility method to confirm proper year value
    private int checkYear(int testYear)
    {
        if(testYear > 0)    //validate year
        {
            return testYear;
        }
        else                //day is invalid
        {
            System.out.printf("Invalid year (%d) set to 1.\n", testYear);
            return 1;
        }   //end else
    }       //end method checkYear
    
    private int checkMonth(int testMonth)
    {
        if(testMonth > 0 && testMonth <= 12)    // validate month
        {
            return testMonth;
        }
        else // month is invalid
        {
            System.out.printf("Invalid month (%d) set to 1.\n", testMonth);
            return 1;   //maintain obj in consistent state
        }   //end else
    }       //end method checkMonth
    
    //utility method to confirm proper day value based on month and year
    private int checkDay(int testDay)
    {
        int dayPerMonth[] = 
        {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        //check if day in range for month
        if(testDay > 0 && testDay <= dayPerMonth[month])
        {
            return testDay;
        }
        
        //check for leap year
        if (month == 2 && testDay == 29 &&(year % 400 == 0 || 
                (year % 4 == 0 && year % 100 != 0 )))
        {
            return testDay;
        }
        
        System.out.printf("invalid day (%d) set to 1.\n", testDay);
        return 1;   //maintain obj in consistent state
    }
    
    //return a String of the form dd/mm/yyyy
    public String toString()
    {
        return String.format("%d/%d/%d", day, month, year);
    }
}