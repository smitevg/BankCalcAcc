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

    @Test
    public void test1(){
        Acc a = initAcc1();

		

        try {
            assertEquals(a.getStartDate(), Acc.sdf.parse("2016.01.12"));
        } catch (ParseException e) {
            Assert.fail("Date start Account is bad");
        }

        assertEquals(1L,1L);

        TreeSet<DayCalc> dc = a.calc(200);

    }

	@Test
	public void test2(){
        Acc a = initAcc365();

		

        TreeSet<DayCalc> dc = a.calc(200);
		long l = dc.last().interest;

        assertEquals(l,13084);

    }

}
