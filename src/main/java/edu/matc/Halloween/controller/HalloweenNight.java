package edu.matc.Halloween.controller;


import edu.matc.Halloween.Riley;
import edu.matc.Halloween.RileysDoor;
import edu.matc.Halloween.entity.TrickOrTreaterGenerator;

/**
 * Created by Sue Hundt on 3/25/17.
 */
public class HalloweenNight {
    public static void main(String a[])
    {
        RileysDoor doorBell = new RileysDoor();

        Riley riley = new Riley(doorBell);
        TrickOrTreaterGenerator totg = new TrickOrTreaterGenerator(doorBell);

        Thread thriley = new Thread(riley);
        Thread thtotg = new Thread(totg);

        thtotg.start();
        thriley.start();
    }

}
