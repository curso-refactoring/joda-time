package org.joda.time.contrib.hibernate;

import org.joda.time.DateTime;

import java.io.Serializable;

/**
 * PO to be stored using hibernate
 */
public class EventTZ implements Serializable
{
    private int id;
    private DateTime dateTime;

    public EventTZ()
    {
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public DateTime getDateTime()
    {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime)
    {
        this.dateTime = dateTime;
    }
}