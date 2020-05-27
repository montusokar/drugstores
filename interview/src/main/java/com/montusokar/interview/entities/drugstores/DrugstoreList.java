package com.montusokar.interview.entities.drugstores;

import java.util.List;

public class DrugstoreList {
	private List<DrugstoreResponse> drugstores;

	public DrugstoreList() {
	}

	public DrugstoreList(List<DrugstoreResponse> drugstores) {
		super();
		this.drugstores = drugstores;
	}

	public List<DrugstoreResponse> getDrugstores() {
		return drugstores;
	}

	public void setDrugstores(List<DrugstoreResponse> list) {
		this.drugstores = (List<DrugstoreResponse>) list;
	}

}
