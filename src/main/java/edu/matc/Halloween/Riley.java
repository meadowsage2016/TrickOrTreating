package edu.matc.Halloween;


import org.apache.log4j.Logger;

/**
 * Created by Sue Hundt on 3/25/17.
 */
public class Riley implements Runnable {

    private final Logger log = Logger.getLogger(this.getClass());
    RileysDoor doorBell;;

    public Riley(RileysDoor doorBell)
    {
        this.doorBell = doorBell;
    }
    public void run()
    {
        try
        {
            Thread.sleep(10000);
        }
        catch(InterruptedException iex)
        {
            iex.printStackTrace();
        }
        log.info("Riley started..");
        while(true)
        {
            doorBell.handOutCandy();
        }
    }
}
