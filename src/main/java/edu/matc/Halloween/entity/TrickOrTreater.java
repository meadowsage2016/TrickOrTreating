package edu.matc.Halloween.entity;

import edu.matc.Halloween.RileysDoor;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by Sue Hundt on 3/25/17.
 */
@Entity
public class TrickOrTreater implements Runnable {
    String name;
    Date inTime;

    RileysDoor rileysDoor;

    public TrickOrTreater() {

    }

    public TrickOrTreater(RileysDoor rileysDoor)
    {
        this.rileysDoor = rileysDoor;
    }

    public String getName() {
        return name;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public void run()
    {
        ringDoorBellForCandy();
    }
    private synchronized void ringDoorBellForCandy()
    {
        rileysDoor.add(this);
    }
}
