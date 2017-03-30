package com.utils;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.Month;
import java.util.Random;

@Service
public class TomatoSaleUtils {

	public Timestamp getRandomTimestamp(){

		Random random = new Random();
		LocalDate currentDate = LocalDate.now();
		LocalDate firstDateOfYear = LocalDate.of(currentDate.getYear(), Month.JANUARY, 1);

		int minDay = (int) firstDateOfYear.toEpochDay();
		int maxDay = (int) currentDate.toEpochDay();
		long randomDay = minDay + random.nextInt(maxDay - minDay + 1);
		LocalDate randomDate = LocalDate.ofEpochDay(randomDay);

		return Timestamp.valueOf(randomDate.atStartOfDay());
	}

	public String getRandomTomatoProvider() {

		String[] providers = {"Heinz", "Hunt's", "Del Monte", "Le Ol' Granma"};
		int randomProviderIndex = new Random().nextInt(providers.length);

		return providers[randomProviderIndex];
	}
}