package org.joda.time;

import java.util.HashMap;

public class Pool {

    private static Pool myInstance;
    private HashMap<Integer, Object> instances;
    private RequestContext.MapView minutes;

    private Pool() {
        this.instances = new HashMap<Integer, Object>();
    }

    public static Pool getInstance() {

        if (myInstance == null) {
            myInstance = new Pool();
        }

        return myInstance;
    }

    private void add(int numeral, Days day) {
        instances.put(new Integer(numeral), day);
    }

    private void addMinutes(int numeral, Minutes minute) {
        minutes.put(new Integer(numeral), minute);
    }


    public Object getInstance(int numeral){
        Object instance = instances.get(new Integer(numeral));

        if (instance == null) {
            return null;
        }

        return instance;

    }

    public static Days getDays(int numeral) {
        Pool pool = Pool.getInstance();

        Object result = pool.getInstance(numeral);

        if (result == null) {
            result =  new Days(numeral);
            pool.add(numeral, (Days) result);
        }

        return (Days) result;
    }


    public static Minutes getMinutes(int numeral) {

        Pool pool = Pool.getInstance();

        Object result = pool.getInstance(numeral);

        if (result == null) {
            result =  new Minutes(numeral);
            pool.add(numeral, (Minutes) result);
        }

        return (Minutes) result;
    }
}
