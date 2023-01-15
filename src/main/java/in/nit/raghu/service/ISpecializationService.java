package in.nit.raghu.service;

import java.util.List;
import java.util.Map;

import in.nit.raghu.entity.Specialization;

public interface ISpecializationService {

	public Long saveSpecialization(Specialization spec);
	
	public List<Specialization> getAllSpecialization();

	public void removeSpecialization(Long id);
	
	public Specialization getOneSpecialization(Long id);
	
	public void updateSpecialization(Specialization spec);
	
	
	public boolean isSpecCodeExit(String specCode);
	
	public boolean isSpecNameExit(String specName);
	
	boolean isSpecCodeExistForEdit(String specCode, Long id);
	
	public Map<Long,String> getSpecIdAndName();
}
