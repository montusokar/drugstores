package com.montusokar.interview.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.montusokar.interview.controller.errors.UserError;
import com.montusokar.interview.entities.drugstores.DrugstoreList;
import com.montusokar.interview.entities.drugstores.Filter;
import com.montusokar.interview.exceptions.DrugstoresException;
import com.montusokar.interview.service.DrugstoreService;

@RestController
class DrugstoresController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DrugstoresController.class);

	@Autowired
	DrugstoreService drugstoreService;

	@GetMapping("/farmacias/list")
	DrugstoreList listDrugstores() throws Exception {
		LOGGER.info("Retrieving loaded drugstores");
		return drugstoreService.listDrugstores();
	}

	@GetMapping("/farmacias/load")
	DrugstoreList loadDrugstores() throws Exception {
		LOGGER.info("Getting drugstores from datasource");
		return drugstoreService.retrieveDrugstores();
	}

	@PostMapping("/farmacias/filter")
	DrugstoreList filterDrugstores(@RequestBody Filter filter) {
		LOGGER.info("Filtering drugstores by comuna: " + filter.getComuna());
		return drugstoreService.retrieveByComuna(filter.getComuna());
	}

	@ExceptionHandler({ DrugstoresException.class })
	public ResponseEntity<Object> handleException(Exception e) {
		List<String> errors = new ArrayList<>();
		UserError error = new UserError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), errors);
		return new ResponseEntity<Object>(error, error.getStatus());
	}
}