package ru.ibetter;

/**
 * Created by smit on 25.09.2016.
 */
public class DayCalc implements Comparable<DayCalc> {
    private final int numDay;
    public long interest;

    public DayCalc(int numDay) {
        this.numDay = numDay;
        this.interest = 0;
    }


    public int getNumDay() {
        return this.numDay;
    }

    public long getInterest() {
        return interest;
    }

    public void setInterest(long interest) {
        this.interest = interest;
    }


    @Override
    public int compareTo(DayCalc o) {
        return this.numDay - o.numDay;
    }
}
