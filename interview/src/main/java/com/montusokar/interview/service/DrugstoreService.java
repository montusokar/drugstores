package com.montusokar.interview.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.montusokar.interview.entities.drugstores.Drugstore;
import com.montusokar.interview.entities.drugstores.DrugstoreList;
import com.montusokar.interview.entities.drugstores.DrugstoreResponse;
import com.montusokar.interview.exceptions.DrugstoresException;

@Service
public class DrugstoreService {

	private DrugstoreList drugstores = null;

	@Autowired
	private RestTemplate restTemplate;

	public DrugstoreList retrieveDrugstores() throws Exception {
		ResponseEntity<Drugstore[]> result = restTemplate.getForEntity(
				"https://farmanet.minsal.cl/maps/index.php/ws/getLocalesRegion?id_region=7", Drugstore[].class);

		List<Drugstore> originalDrugstores = Arrays.asList(result.getBody());
		List<DrugstoreResponse> responseDrugstores = new ArrayList<DrugstoreResponse>();
		originalDrugstores.forEach(drugstore -> {
			DrugstoreResponse response = new DrugstoreResponse(drugstore.getLocal_nombre(),
					drugstore.getLocal_direccion(), drugstore.getLocal_telefono(), drugstore.getLocal_lat(),
					drugstore.getLocal_lng(), drugstore.getComuna_nombre());
			responseDrugstores.add(response);
		});
		drugstores = new DrugstoreList(responseDrugstores);
		return drugstores;
	}

	public DrugstoreList listDrugstores() throws DrugstoresException {
		if (drugstores != null) {
			return drugstores;
		} else {
			throw new DrugstoresException("Drugstore service needs to load data first, please request /farmacias/load");
		}
	}

	public DrugstoreList retrieveByComuna(String comuna) {
		DrugstoreList filteredDrugstores = new DrugstoreList();
		if (drugstores != null && drugstores.getDrugstores() != null) {
			filteredDrugstores.setDrugstores(drugstores.getDrugstores().stream()
					.filter(drugstore -> drugstore.getLocal_comuna().equalsIgnoreCase(comuna))
					.collect(Collectors.toList()));
		}

		return filteredDrugstores;
	}

}
