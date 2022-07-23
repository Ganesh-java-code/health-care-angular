package in.nit.ganesh.service;

import java.util.List;

import in.nit.ganesh.entity.Specialization;

public interface SpecializationService {
	
	public Integer saveSpecialization(Specialization specialization);
	
	public Specialization getOneSpecialization(Integer id);
	
	public List<Specialization> getAllSpecializations();
	
	public void deleteSpecialization(Integer id);
	
	public void updateSpecialization(Specialization specialization);
	
}
