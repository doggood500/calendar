/***************************************************
 * Date : 2014/7/28
 * File Name : main.java
 * Package Name : default
 * Java Project Name : calender
 * Synopsis : do something trash
 * Author : AnAn
 *****************************************************/


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
    static final int month_day[][]={{31,28,31,30,31,30,31,31,30,31,30,31},
                                {31,29,31,30,31,30,31,31,30,31,30,31}}; 
    static final String mon[]={"January","February","Mach","April","May",
                            "June","July","August","September","October","November","December"};
    static final String week[]={"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner scanner = new Scanner(System.in);
        int sel;
        boolean exit=false;
        while(!exit)
        {
            System.out.println("Pleace make choice : ");
            System.out.println("1. Is leap year?");
            System.out.println("2. Show you how many days in this month?");
            System.out.println("3. What day is this day?");
            System.out.println("4. Show the month calendar");
            System.out.println("5. How many Holiday in this year?");
            System.out.println("0. Exit");
            sel = scanner.nextInt();
            switch(sel)
            {
                case 1:
                    isLeapYear();
                    break;
                case 2:
                    howManyDay();
                    break;
                case 3:
                    whatDayToday();
                    break;
                case 4:
                    print_calender();
                    break;
                case 5:
                    Holiday();
                    break;
                case 0:
                    exit = true;
                    break;
            }
        }
    }
    //option 1 判斷輸入年分是否為閏年
    static void isLeapYear()
    {
        Scanner scanner = new Scanner(System.in);
        int year;
        System.out.println("Please enter year of calender : ");
        year=scanner.nextInt();
        if(leap_year(year)==1) 
            System.out.println("This year is leap year.");
        else 
            System.out.println("This year is not leap year.");    
    }
    
    //option 2 判斷這個月有多少天
    static void howManyDay()
    {
        Scanner scanner = new Scanner(System.in);
        int year,month;
        System.out.println("Please enter year of calender : ");
        year=scanner.nextInt();
        do
        {
            System.out.println("Please enter month of calender : ");
            month = scanner.nextInt();
            if((month>0) && (month<13))
                break;
        }while(true);
        System.out.println("There are " + month_day[leap_year(year)][(month-1)] +" in " + month + "/" + year ); 
    }
    
    //option 3 判斷輸入日期為星期幾
    static int whatDayToday()
    {
        Scanner scanner = new Scanner(System.in);
        int year,month,day;
        int i,j;
        int first_day=1;
        int flagOfLeap;
        System.out.println("Please enter year of calender : ");
        year=scanner.nextInt();
        do
        {
            System.out.println("Please enter month of calender : ");
            month = scanner.nextInt();
            if((month>0) && (month<13))
                break;
        }while(true);
        flagOfLeap=leap_year(year);
        do
        {
            System.out.println("Please enter day of calender : ");
            day = scanner.nextInt();
            if((day>0) && (day<month_day[flagOfLeap][(month-1)]))
                break;
        }while(true);
        //firstday平移
        for(i=1900;i<year;i++)
            first_day=(first_day+365+leap_year(i))%7;
        for(i=0;i<12;i++)
        {
            if(month==(i+1))
            {
                first_day=(first_day+day-1)%7;
                System.out.println(year+"/"+month+"/"+day+" is "+week[first_day]);
                return 0;
                
            }
            first_day=(first_day+month_day[flagOfLeap][i])%7;
            
           }
       return 0;
    }
    //option 4 print month calender
    static void print_calender()
    {
        Scanner scanner = new Scanner(System.in);
        int year,month;
        int i,j;
        int first_day=1;
        int flagOfLeap;
        System.out.println("Please enter year of calender : ");
        year=scanner.nextInt();
        do
        {
            System.out.println("Please enter month of calender : ");
            month = scanner.nextInt();
            if((month>0) && (month<13))
                break;
        }while(true);
        flagOfLeap=leap_year(year);
        //firstday平移
        for(i=1900;i<year;i++)
            first_day=(first_day+365+leap_year(i))%7;
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
                for(j=1;j<=month_day[flagOfLeap][i];j++)
                {
                    System.out.printf("%4d",j);
                    if((j+first_day)%7==0)
                        System.out.println("");	
                }
                	
                System.out.println("");
                
                break;
            }
            //否則只計算開始的星期
            first_day=(first_day+month_day[flagOfLeap][i])%7;	
        }
        
    }
    
    //判斷六日天數
    static void Holiday()
    {
        Scanner scanner = new Scanner(System.in);
        int year;
        int first_day=1;
        int i;
        year=scanner.nextInt();
        //firstday平移
        for(i=1900;i<year;i++)
            first_day=(first_day+365+leap_year(i))%7;
        if(leap_year(year)==1)
        {
            if((first_day==5)||(first_day==0))
                System.out.println("There are 105 holidays in this year.");
            else if(first_day==6)
                System.out.println("There are 106 holidays in this year.");
            else
                System.out.println("There are 104 holidays in this year.");
        }
        else
        {
            if((first_day==6)||(first_day==0))
                System.out.println("There are 105 holidays in this year.");
            else
                 System.out.println("There are 104 holidays in this year.");
        }
    }
        
        
    
    //閏年判斷
    static int leap_year(int year)
    {
        if((year%400)==0) return 1;//如果整除400是閏年
        else if(((year%4)==0)&&((year%100)!=0)) return 1;//如果是4得倍數而不是100的倍數是閏年
        return 0;
    }
       
}
