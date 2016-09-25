
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.SortedSet;
import java.util.TreeSet;


/**
 * Сохраниение
 */


public class Acc {
    public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");


    private String name;
    private int numberAcc;

    //снятие.внесение, Изменение процента, Остаток из банка
    private TreeSet<DayAcc> daily = new TreeSet<DayAcc>();

    //капитализация
    private boolean isCap = false;

    //День месяца капитализации
    private int dayCap = -1;

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





    public static void main(String[] arg){
        Acc a = initAcc1();


    }

    //testData
    private static Acc initAcc1(){

        DayAcc day1 = new DayAcc("2016.01.12", 200000L, null, 12L);
        DayAcc day2 = new DayAcc("2016.02.20", null, 10000L, null);
        DayAcc day3 = new DayAcc("2016.04.02", null, 10000L, null);
        TreeSet<DayAcc> ds = new TreeSet<DayAcc>();
        ds.add(day3);
        ds.add(day2);
        ds.add(day1);
        System.out.println( ds.first().day );

        Acc a = new Acc("Тест", 1, ds, true, 15);
        return a;
    }





}
