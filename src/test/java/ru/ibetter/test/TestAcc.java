package ru.ibetter.test;

import org.junit.Assert;
import org.junit.Test;
import ru.ibetter.Acc;
import ru.ibetter.DayAcc;
import ru.ibetter.DayCalc;

import java.text.ParseException;
import java.util.TreeSet;

import java.util.*;

/**
 * Created by smit on 25.09.2016.
 */
public class TestAcc extends Assert {

    private Acc initAcc1(){
		System.out.println("initAcc1");
        DayAcc day1 = new DayAcc("2016.01.12", 200000L, null, 1200L); //  2000р 12%
        DayAcc day2 = new DayAcc("2016.02.20", null, 10000L, null);
        DayAcc day3 = new DayAcc("2016.04.02", null, 10000L, 1100L);
		DayAcc day4 = new DayAcc("2016.05.12", null, -10000L, 900L);
        TreeSet<DayAcc> ds = new TreeSet<DayAcc>();
        ds.add(day1);
        ds.add(day2);
        ds.add(day3);
		ds.add(day4);
        Acc a = new Acc("Тест", 1, ds, true, 15);
		
		Iterator<DayAcc> iDA = ds.iterator();
		DayAcc _d = null;
        while (iDA.hasNext()){
            _d = iDA.next();
			if (_d.prValue == null) {
				System.out.println("!!!!NULL!!");
			} else {
				System.out.println(_d.prValue);
			}
        }
		
        return a;
    }

	
	private Acc initAcc365(){
		System.out.println("initAcc1");
        DayAcc day1 = new DayAcc("2016.01.01", 200000L, null, 1200L); //  2000р 12%        
		
        TreeSet<DayAcc> ds = new TreeSet<DayAcc>();
        ds.add(day1);
        
        Acc a = new Acc("Тест", 1, ds, true, 15);
		
        return a;
    }
	
	
	private Acc initAcc2(){
		System.out.println("initAcc1");
		TreeSet<DayAcc> ds = new TreeSet<DayAcc>();
        ds.add( new DayAcc("2016.01.13", 63000, null, 12) ); //  63 000р 12%
		ds.add( new DayAcc("2016.01.27", null, 37000, null) );
		ds.add( new DayAcc("2016.01.30", null, 25000, null) );
		ds.add( new DayAcc("2016.02.03", null, 21000, null) );
		ds.add( new DayAcc("2016.02.04", null, 4000, null) );
		ds.add( new DayAcc("2016.02.11", null, 50000, null) );
		ds.add( new DayAcc("2016.02.19", null, 50000, null) );
		ds.add( new DayAcc("2016.02.21", null, 50000, null) );
		ds.add( new DayAcc("2016.02.26", null, 20000, null) );
		ds.add( new DayAcc("2016.02.28", null, 30000, null) );

		
		ds.add( new DayAcc("2016.02.28", null, 30000, null) );
		ds.add( new DayAcc("2016.03.02", null, 25000, null) );
		ds.add( new DayAcc("2016.03.03", null, 50000, null) );
		ds.add( new DayAcc("2016.03.03", null, 50000, null) );
		ds.add( new DayAcc("2016.03.05", null, 45000, null) );
		ds.add( new DayAcc("2016.03.15", null, 3000, null) );
		ds.add( new DayAcc("2016.03.15", null, 30, null) );
		ds.add( new DayAcc("2016.03.25", null, 5000, null) );
		
		

        
        Acc a = new Acc("Тест", 1, ds, true, 15);
		
        return a;
    }

    @Test
    public void test_acc(){
        Acc a = initAcc2();

        TreeSet<DayCalc> dc = a.calc(90);

    }

    @Test
    public void test1(){
        Acc a = initAcc1();

        try {
            assertEquals(a.getStartDate(), Acc.sdf.parse("2016.01.12"));
        } catch (ParseException e) {
            Assert.fail("Date start Account is bad");
        }
    }

	@Test
	public void test2(){
        Acc a = initAcc365();

		

        TreeSet<DayCalc> dc = a.calc(200);
		long l = dc.last().interest;

        assertEquals(l,13084);

    }

}
