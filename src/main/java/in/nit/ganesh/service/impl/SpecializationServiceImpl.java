package in.nit.ganesh.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nit.ganesh.entity.Specialization;
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
		Optional<Specialization> opt = repo.findById(id);
		if(opt.isPresent()) {
			opt.get();
		}else {
			throw new RuntimeException("Not Found");
		}
		return null;
	}

	public List<Specialization> getAllSpecializations() {
		
		List<Specialization> list = repo.findAll();
		return list;
	}

	public void deleteSpecialization(Integer id) {
		repo.delete(getOneSpecialization(id));
	}

	public void updateSpecialization(Specialization specialization) {
		repo.save(specialization);
	}

}
