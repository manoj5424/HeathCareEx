package in.nit.raghu.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.comparator.Comparators;

import in.nit.raghu.entity.Specialization;
import in.nit.raghu.exception.SpecializationNotFoundException;
import in.nit.raghu.repo.SpecializationRepository;
import in.nit.raghu.service.ISpecializationService;
import in.nit.raghu.util.MyCollectionsUtil;

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
		// repo.deleteById(id);
		repo.delete(getOneSpecialization(id));
	}

	public Specialization getOneSpecialization(Long id) {

		return repo.findById(id).orElseThrow(() -> new SpecializationNotFoundException(id + "Not Found"));
		/*
		 * Optional<Specialization> optional = repo.findById(id);
		 * if(optional.isPresent()) { 
		 * return optional.get(); 
		 * }else { 
		 * throw new SpecializationNotFoundException(id+" Not Found"); 
		 * }
		 */
	}

	public void updateSpecialization(Specialization spec) {
		repo.save(spec);
	}

	public boolean isSpecCodeExit(String specCode) {

		/*
		 * Integer count = repo.getSpecCodeCount(specCode); boolean exist=count>0 ? true
		 * : false; return exist;
		 */
		return repo.getSpecCodeCount(specCode) > 0;
	}

	public boolean isSpecNameExit(String specName) {
		return repo.getSpecNameCount(specName) > 0;
	}

	@Override
	public boolean isSpecCodeExistForEdit(String specCode, Long id) {

		return repo.getSpecCodeCountForEdit(specCode, id)>0;
	}

	@Override
	public Map<Long, String> getSpecIdAndName() {
		List<Object[]> list = repo.getSpecIdAndName();
		Map<Long,String> map = MyCollectionsUtil.convertToMap(list);
		return map;
	}
}
