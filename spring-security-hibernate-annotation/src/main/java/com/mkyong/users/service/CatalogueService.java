package com.mkyong.users.service;

import java.util.List;

import com.mkyong.users.model.Catalogue;

public interface CatalogueService {
	
	public void addCatalogue(int id_catalogue, String name_catalogue, String description);
	
	public List<Catalogue> getAllCatalogue();

}
