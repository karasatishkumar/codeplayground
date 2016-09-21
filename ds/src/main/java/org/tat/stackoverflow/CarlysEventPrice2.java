package org.tat.stackoverflow;

import java.util.Scanner;
public class CarlysEventPrice2
{
    public static void main(String[] args)
    {
    	int guestAmt = guestNumber();
        companyMotto();
        guestAndPrice(guestAmt);
    }

    public static int guestNumber()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("How many guests will attend this event?");
        int guestAmt = input.nextInt();
        return guestAmt;
    }

    public static void companyMotto()
    {
        System.out.println("*************************************************");
        System.out.println("* Carly's makes the food that makes it a party. *");
        System.out.println("*************************************************");
    }

    public static void guestAndPrice(int guestAmt)
    {
        int GUESTPRICE = 35;
        int totalPrice = GUESTPRICE * guestAmt;
        boolean largeEvent = (guestAmt >= 50);
        System.out.println("There will be " + guestAmt + " guests at $" + GUESTPRICE + ", equaling a total of $" + totalPrice + ".");
        System.out.println("The job is classified as a large event: " + largeEvent + ".");
    }
}
