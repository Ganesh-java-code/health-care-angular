package in.nit.ganesh.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nit.ganesh.entity.Specialization;
import in.nit.ganesh.exception.SpecializationException;
import in.nit.ganesh.repo.SpecializationRepository;
import in.nit.ganesh.service.SpecializationService;

@Service
public class SpecializationServiceImpl implements SpecializationService {

	@Autowired
	private SpecializationRepository repo;
	
	public Integer saveSpecialization(Specialization specialization) {
		return repo.save(specialization).getId();
	}

	public Specialization getOneSpecialization(Integer id) {
		/*
		 * Optional<Specialization> opt = repo.findById(id); if(opt.isPresent()) {
		 * opt.get(); }else { throw new SpecializationException("Not Found"); } return
		 * null;
		 */
		return repo.findById(id).orElseThrow(()->new SpecializationException("Not Found"));
	}

	public List<Specialization> getAllSpecializations() {
		
		List<Specialization> list = repo.findAll();
		return list;
	}

	public void deleteSpecialization(Integer id) {
		repo.delete(getOneSpecialization(id));
	}

	public void updateSpecialization(Specialization specialization) {
		if(getOneSpecialization(specialization.getId())!=null && repo.existsById(specialization.getId())) {			
			repo.save(specialization);
		}
	}

}
