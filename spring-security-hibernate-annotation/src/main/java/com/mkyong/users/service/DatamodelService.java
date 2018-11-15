package com.mkyong.users.service;

import java.nio.file.Path;
import java.util.List;

import com.mkyong.users.model.DataModel;
import com.mkyong.users.model.DataModelDecript;

public interface DatamodelService {
	
	public void upload(String path, String sistemabbdd, String version);

	public List<DataModel> getAllDatamodel();
	
	public List<String> getAllNameDatamodel();
	
	public List<String> getdmdByIdDatamodel(Integer id_datamodel);
	
	public List<String> getAttributesByTable(String table_name);

	public void deleteDataModel(String database_name, String version);


}
