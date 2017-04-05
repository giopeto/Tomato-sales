package com.tomato.sales.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.tomato.sales.domain.Tomato;

@RunWith(MockitoJUnitRunner.class)
public class TomatoesServiceImplMockTest {
	
	@Mock
	Tomato mockTomato;
	
	
	@Test
	public void testMockTomato(){
		Mockito.when(mockTomato.getProvider()).thenReturn("Heinz");
		assertEquals("Size of list must be: ", "Heinz", mockTomato.getProvider());
	}
	
}
