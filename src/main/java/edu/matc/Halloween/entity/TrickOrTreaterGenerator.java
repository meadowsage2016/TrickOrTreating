package edu.matc.Halloween.entity;

import edu.matc.Halloween.RileysDoor;
import edu.matc.Halloween.entity.TrickOrTreater;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Sue Hundt on 3/25/17.
 */
public class TrickOrTreaterGenerator implements Runnable {

    RileysDoor doorBell;

    public TrickOrTreaterGenerator(RileysDoor doorBell)
    {

        this.doorBell = doorBell;
    }

    public void run()
    {
        while(true)
        {
            TrickOrTreater guest = new TrickOrTreater(doorBell);
            guest.setInTime(new Date());
            Thread thguest = new Thread(guest);
            guest.setName("Trick-or-Treater: "+ thguest.getId());
            thguest.start();

            try
            {
                TimeUnit.SECONDS.sleep((long)(Math.random()*10));
            }
            catch(InterruptedException iex)
            {
                iex.printStackTrace();
            }
        }
    }
}
