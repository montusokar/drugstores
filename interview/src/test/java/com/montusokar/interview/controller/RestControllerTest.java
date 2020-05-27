package com.montusokar.interview.controller;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.montusokar.interview.entities.drugstores.DrugstoreList;
import com.montusokar.interview.entities.drugstores.Filter;

@SpringBootTest
public class RestControllerTest {

	@Autowired
	DrugstoresController controller;

	@Test
	public void contexLoads() {
		Assert.assertTrue(controller != null);
	}

	@Test
	public void loadInitialDataTest() throws Exception {
		DrugstoreList drugstores = controller.loadDrugstores();
		Assert.assertTrue(drugstores != null);
		Assert.assertTrue(drugstores.getDrugstores().size() > 0);
	}

	@Test
	public void loadAndListData() throws Exception {
		DrugstoreList loadedDrugstores = controller.loadDrugstores();
		DrugstoreList listedDrugstores = controller.listDrugstores();
		Assert.assertTrue(loadedDrugstores.getDrugstores().size() == listedDrugstores.getDrugstores().size());
	}

	@Test
	public void filterData() throws Exception {
		controller.loadDrugstores();
		DrugstoreList drugstores = controller.filterDrugstores(new Filter("recoleta"));
		Assert.assertTrue(drugstores != null);
		Assert.assertTrue(drugstores.getDrugstores().size() > 0);
		drugstores.getDrugstores().forEach(drugstore -> {
			Assert.assertTrue(drugstore.getLocal_comuna().equalsIgnoreCase("recoleta"));
		});
	}

}