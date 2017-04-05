package com.tomato.sales.controller;

import com.tomato.sales.service.TomatoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tomatoes/data")
public class TomatoesController {

	private final TomatoesService tomatoesService;

	@Autowired
	public TomatoesController(TomatoesService tomatoesService) {
		this.tomatoesService = tomatoesService;
	}

	@RequestMapping(
			method = RequestMethod.GET,
			headers="Accept=application/json",
			produces="application/json"
	)

	public List get(@RequestParam("size") Optional<Integer> sizeParam) {
		int size = 3;
		if (sizeParam.isPresent()) {
			size = sizeParam.get();
		}
		return tomatoesService.get(size);
	}

}
