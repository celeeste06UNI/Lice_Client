package com.mkyong.users.service;

import java.util.List;

import com.mkyong.users.model.Organization;

public interface OrganizationService {

	public void addOrganization(Organization organization);

	public List<Organization> getAllOrganization();

	public void deleteOrganization(Integer id);

	public Organization getOrganization(Integer id);

	public void updateOrganization(Organization organization);

}
