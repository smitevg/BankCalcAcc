package ru.ibetter;

import java.text.SimpleDateFormat;
import java.util.*;




public class Acc {
    public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");


    private String name;
    private int numberAcc;

    private TreeSet<DayAcc> daily = new TreeSet<DayAcc>();

    private boolean isCap = false;

    private int dayCap = -1;

    //
    public Date getStartDate() {
        return startDate;
    }

    private Date startDate;


    public Acc(String name, int numberAcc, TreeSet<DayAcc> daily, boolean isCap, int dayCap) {
        try {
            this.startDate = Acc.sdf.parse(daily.first().day);
        } catch (Exception e) {
            throw new IllegalArgumentException("Date is empty or is not good format");
        }
        this.name = name;
        this.numberAcc = 1;
        this.daily = daily;
        this.isCap = isCap;
        this.dayCap = dayCap;
    }


    public TreeSet<DayCalc> calc(int daysCount) {

        TreeSet<DayCalc> ts = new TreeSet<DayCalc>();
        for (int i=1; i < daysCount; i++) {


            Date d = (Date)this.startDate.clone();


            String curDat = sdf.format(d);
            DayCalc da = new DayCalc(i);
            ts.add(da);
        }
        return ts;
    }







}
