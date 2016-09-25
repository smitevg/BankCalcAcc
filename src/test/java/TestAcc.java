import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.util.TreeSet;

/**
 * Created by smit on 25.09.2016.
 */
public class TestAcc extends Assert {

    private Acc initAcc1(){

        DayAcc day1 = new DayAcc("2016.01.12", 200000L, null, 12L);
        DayAcc day2 = new DayAcc("2016.02.20", null, 10000L, null);
        DayAcc day3 = new DayAcc("2016.04.02", null, 10000L, null);
        TreeSet<DayAcc> ds = new TreeSet<DayAcc>();
        ds.add(day1);
        ds.add(day2);
        ds.add(day3);
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
    }
}
