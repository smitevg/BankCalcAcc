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
        System.out.println("Start calc");
        Calendar c = Calendar.getInstance();
        c.setTime(this.startDate);

        Iterator<DayAcc> iDA = this.daily.iterator();
        DayAcc da = iDA.next();

        TreeSet<DayCalc> ts = new TreeSet<DayCalc>();
        for (int i=1; i < daysCount; i++) {


            String dateText = sdf.format(c.getTime());





            if (da != null && da.getDay().equals(dateText)) {
                System.out.println(dateText);
                if (iDA.hasNext()){
                    da = iDA.next();
                }
            }


            DayCalc dc = new DayCalc(i);
            ts.add(dc);
            c.add(Calendar.DAY_OF_MONTH, 1);
        }
        return ts;
    }







}
