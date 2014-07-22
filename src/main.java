import java.util.Scanner;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Small_Deer
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        int year,month;
        
        System.out.println("Please enter year of calender : ");
        year = scanner.nextInt();
        do
        {
            System.out.println("Please enter month of calender : ");
            month = scanner.nextInt();
            if((month>0) && (month<13))
                break;
        }while(true);
        System.out.println("year"+year+"month"+month);
        print_calendar(year,month);
    }
    
    static int leap_year(int year)
    {
        if((year%400)==0) return 1;//如果整除400是閏年
        else if(((year%4)==0)&&((year%100)!=0)) return 1;//如果是4得倍數而不是100的倍數是閏年
        return 0;
    }
    static void print_calendar(int year,int month)
    {
        int i,j;
        int first_day=1;
        int is_leap_year;
        String mon[]={"January","February","Mach","April","May",
	  		"June","July","August","September","October","November","December"};
        int month_day[][]={{31,28,31,30,31,30,31,31,30,31,30,31},
                         {31,29,31,30,31,30,31,31,30,31,30,31}};      							
	//fitst_day的平移 
	for(i=1900;i<year;i++)
	{
            if(leap_year(i)==1)
                first_day=(first_day+366)%7;
            else
                first_day=(first_day+365)%7;		
	}
       is_leap_year=leap_year(year);
       
       
       //計算該年的月份天數
       for(i=0;i<12;i++)
	{
            //如果是輸入月份就列印
            if((month-1)==i)
            {
                System.out.printf("%13s\n",mon[i]);
                System.out.println("Sun Mon Tue Wed Thu Fir Sat");

                for(j=1;j<=first_day;j++)
                {
                    System.out.printf("%4c",0x20);//space
                }
                for(j=1;j<=month_day[is_leap_year][i];j++)
                {
                    System.out.printf("%4d",j);
                    if((j+first_day)%7==0)
                        System.out.println("");	
                }
                	
                System.out.println("");
                break;
            }
            //否則只計算開始的星期
            first_day=(first_day+month_day[is_leap_year][i])%7;	
	}
        
    }
}
