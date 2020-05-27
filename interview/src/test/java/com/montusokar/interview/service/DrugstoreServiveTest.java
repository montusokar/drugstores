package com.montusokar.interview.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.montusokar.interview.entities.drugstores.DrugstoreList;
import com.montusokar.interview.exceptions.DrugstoresException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DrugstoreServiveTest {

	@Autowired
	DrugstoreService service;

	@Test(expected = DrugstoresException.class)
	public void listWithoutRetrievalErrorTest() throws DrugstoresException {
		DrugstoreList drugstores = service.listDrugstores();
	}
}
