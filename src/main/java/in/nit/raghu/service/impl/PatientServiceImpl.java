package in.nit.raghu.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nit.raghu.entity.Patient;
import in.nit.raghu.repo.PatientRepository;
import in.nit.raghu.service.IPatientService;
@Service
public class PatientServiceImpl implements IPatientService {

	@Autowired
	private PatientRepository repo;
	@Override
	public Long savePatient(Patient patient) {
		Long id = repo.save(patient).getId();
		
		return id;
	}

	@Override
	public void updatePatient(Patient patient) {
		repo.save(patient);
	}

	@Override
	public void deletePatient(Long id) {
		repo.deleteById(id);
	}

	@Override
	public Patient getOnePatient(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public List<Patient> getAllPatients() {
		return repo.findAll();
	}

}
