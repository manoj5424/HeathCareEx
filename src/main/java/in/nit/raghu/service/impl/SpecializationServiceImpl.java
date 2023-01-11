package in.nit.raghu.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nit.raghu.entity.Specialization;
import in.nit.raghu.repo.SpecializationRepository;
import in.nit.raghu.service.ISpecializationService;
@Service
public class SpecializationServiceImpl implements ISpecializationService {

	@Autowired
	private SpecializationRepository repo;
	
	public Long saveSpecialization(Specialization spec) {
		return repo.save(spec).getId();
	}

	public List<Specialization> getAllSpecialization() {
		return repo.findAll();
	}

	public void removeSpecialization(Long id) {
		repo.deleteById(id);
	}

	public Specialization getOneSpecialization(Long id) {
		 Optional<Specialization> optional = repo.findById(id);
		 if(optional.isPresent()) {
			return optional.get();
		 }else {
		 return null;
		 }
	}

	public void updateSpecialization(Specialization spec) {
		repo.save(spec);
	}

}
