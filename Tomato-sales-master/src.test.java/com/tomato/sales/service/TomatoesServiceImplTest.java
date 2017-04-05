package com.tomato.sales.service;

import com.tomato.sales.domain.Tomato;
import com.utils.TomatoSaleUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Random;


public class TomatoesServiceImplTest {

    static TomatoesService tomatoesService;
    static TomatoSaleUtils utils = new TomatoSaleUtils();
    static List<Tomato> tomatoes;
    static int testSize;
    
    @BeforeClass
    public static void setup(){
        Random rand = new Random();
        testSize = rand.nextInt(50);
        tomatoesService = new TomatoesServiceImpl(utils);
        tomatoes = tomatoesService.get(testSize);
    }
    
    @Test
    public void testDI(){
    	assertThat(tomatoesService, instanceOf(TomatoesServiceImpl.class));
    }
    
    @Test
    public void testGetMethodListSize(){
        Assert.assertEquals("Expected list size: " + testSize, testSize, tomatoes.size());
    }

    @Test
    public void testTomatoListForEmptyProperty(){
        tomatoes.forEach((t)-> {
            Assert.assertTrue(t.getId() != null);
            Assert.assertTrue(t.getTimestamp() != null);
            Assert.assertTrue(t.getProvider() != "");
            Assert.assertTrue(t.getTomatoes() > 0);
        });
    }
    
    @Test
    public void testDateIntervalIsFromBeginingOfThisYearToNow(){
    	LocalDate currentDate = LocalDate.now();
		LocalDate firstDateOfYear = LocalDate.of(currentDate.getYear(), Month.JANUARY, 1);
    	
    	tomatoes.forEach((t)-> {
    		Date d = t.getTimestamp();
    		LocalDate date = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    		Assert.assertTrue(date.compareTo(firstDateOfYear)==0 || date.compareTo(firstDateOfYear)>0);
    		Assert.assertTrue(date.compareTo(currentDate)==0 || date.compareTo(currentDate)<0);
        });
    	
    }

}