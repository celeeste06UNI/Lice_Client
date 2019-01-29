package com.mkyong.users.service;

import java.util.List;

import com.mkyong.users.model.Catalogue;
import com.mkyong.users.model.Organization;
import com.mkyong.users.model.RuleProjCatalogue;

public interface CatalogueService {
	
	public void addCatalogue(int id_catalogue, String name_catalogue, String description);
	
	public List<Catalogue> getAllCatalogue();
	
	public void deleteCatalogue(Integer id_catalogue);
	
	public Catalogue getCatalogue(Integer id_catalogue);
	
	public void updateCatalogue(Catalogue catalogue);

	public int getRuleProjCatalogue(Integer id_catalogue);

	public RuleProjCatalogue getListRuleProjCatalogue(int id_rule, Integer id_project);
}
