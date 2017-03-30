package com.tomato.sales.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TomatoesService {

	List get(int size);

}
