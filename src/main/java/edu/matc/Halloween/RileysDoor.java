package edu.matc.Halloween;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import edu.matc.Halloween.entity.TrickOrTreater;
import org.apache.log4j.Logger;

/**
 * Created by Sue Hundt on 3/25/17.
 */
public class RileysDoor {
    private final Logger log = Logger.getLogger(this.getClass());
    int lineAtTheDoor;
    List<TrickOrTreater> listGuest;

    public RileysDoor()
    {
        lineAtTheDoor = 10;
        listGuest = new LinkedList<TrickOrTreater>();
    }

    public void handOutCandy()
    {
        TrickOrTreater guest;
        log.info("Riley waiting for lock.");
        synchronized (listGuest)
        {

            while(listGuest.size()==0)
            {
                log.info("Riley is watching TV, waiting for a trick-or-treater.");
                try
                {
                    listGuest.wait();
                }
                catch(InterruptedException iex)
                {
                    iex.printStackTrace();
                }
            }
            log.info("Riley hears the doorbell.");
            guest = (TrickOrTreater) ((LinkedList<?>)listGuest).poll();
        }
        long duration=3;
        try
        {
            log.info("Handing out candy to  : " + guest.getName());
            TimeUnit.SECONDS.sleep(duration);
        }
        catch(InterruptedException iex)
        {
            iex.printStackTrace();
        }
        log.info("Riley was done handing candy to: " + guest.getName() + " in "+ duration + " seconds.");
    }

    public void add(TrickOrTreater guest)
    {
        log.info("Trick-or-Treater : "+guest.getName()+ " is coming to the front door " + guest.getInTime());

        synchronized (listGuest)
        {
            if(listGuest.size() == lineAtTheDoor)
            {
                log.info("The line is too long for "+guest.getName());
                log.info("Trick-or-Treater "+guest.getName()+" Exits...");
                return ;
            }

            ((LinkedList<TrickOrTreater>)listGuest).offer(guest);
            log.info("Trick-or-Treater : "+guest.getName()+ " is in line at the door.");

            if(listGuest.size()>0)
                listGuest.notify();
        }
    }
}
