package com.mkyong.users.service;

import java.nio.file.Path;
import java.util.List;

import com.mkyong.users.model.DataModel;

public interface DatamodelService {
	
	public void upload(String path, String sistemabbdd, String version);

	public List<DataModel> getAllDatamodel();
	
	public List<String> getAllNameDatamodel();


}
