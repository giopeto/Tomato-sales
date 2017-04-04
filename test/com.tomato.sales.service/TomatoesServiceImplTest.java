package com.tomato.sales.service;

import com.tomato.sales.domain.Tomato;
import com.utils.TomatoSaleUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.Random;


public class TomatoesServiceImplTest {

    TomatoesService tomatoesService;
    TomatoSaleUtils utils = new TomatoSaleUtils();
    List<Tomato> tomatoes;
    int testSize;

    @Before
    public void setup(){
        Random rand = new Random();
        testSize = rand.nextInt(50);
        tomatoesService = new TomatoesServiceImpl(utils);
        tomatoes = tomatoesService.get(testSize);
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

}
