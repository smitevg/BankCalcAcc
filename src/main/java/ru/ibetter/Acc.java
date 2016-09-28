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

		//full %
		Long prValue = null;
		Iterator<DayAcc> iDA = this.daily.iterator();
		while (iDA.hasNext()){
            DayAcc d = iDA.next();
			if (d.prValue == null) {
				d.prValue = prValue;	
			} else {
				prValue = d.prValue;	
			}
		
        }
    }


    public TreeSet<DayCalc> calc(int daysCount) {
        System.out.println("Start calc");
        Calendar c = Calendar.getInstance();
        c.setTime(this.startDate);

		DayAcc daCur =  null;
		DayAcc daNext =  null;
		
        Iterator<DayAcc> iDA = this.daily.iterator();
        if (iDA.hasNext()){
            daNext = iDA.next();
        }
		
		
		long curRrValue = 0; // Current procent
		int cDays = 0;
		long depo = 0;
		long allInterest = 0;
		
        TreeSet<DayCalc> ts = new TreeSet<DayCalc>();
        for (int i=0; i < daysCount; i++) {

            String dateText = sdf.format(c.getTime());

			int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
			
            if (daNext != null && daNext.getDay().equals(dateText)) {
				
				daCur = daNext;
				
                System.out.println(dateText);
                if (iDA.hasNext()){
                    daNext = iDA.next();					
                } else {
					daNext = null;
				}
				if (daCur != null) {
					if (daCur.bankValue != null){
						depo = daCur.bankValue;
					}
					curRrValue = daCur.prValue;
				}
				cDays = i;
            }
				
			long interest = (depo * curRrValue * (i - cDays) / 365) / 10000;
			allInterest = allInterest + interest;				
			System.out.println(allInterest + "		|interest:" + interest );
			
			
            DayCalc dc = new DayCalc(i);
			dc.interest = interest;
            ts.add(dc);
            c.add(Calendar.DAY_OF_MONTH, 1);
        }
        return ts;
    }
	
	public static long sumInterest(TreeSet<DayCalc> ts) {
		long res = 0L;
		Iterator<DayCalc> da = ts.iterator();
        while (da.hasNext()){            
			res = res +	da.next().interest;
        }
		return res;
	}




	


}
