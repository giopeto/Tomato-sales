package com.tomato.sales.service;

import com.tomato.sales.domain.Tomato;
import com.utils.TomatoSaleUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class TomatoesServiceImpl implements TomatoesService{

	private final TomatoSaleUtils utils;

	@Autowired
	public TomatoesServiceImpl(TomatoSaleUtils utils) {
		this.utils = utils;
	}

	public List get(int size) {
		Random rand = new Random();
		ArrayList<Tomato> tomatoes = new ArrayList<Tomato>();

		for (int i=0; i<size; i++){
			int randomQuantity = rand.nextInt(1999) + 1;
			Tomato t = new Tomato(UUID.randomUUID(), randomQuantity, utils.getRandomTomatoProvider(), utils.getRandomTimestamp());
			tomatoes.add(t);
		}

		tomatoes.sort((o1,o2) -> o1.getTimestamp().compareTo(o2.getTimestamp()));

		return tomatoes;

	}

}
