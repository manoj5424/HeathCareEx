package in.nit.raghu.service;

import java.util.List;

import in.nit.raghu.entity.Patient;

public interface IPatientService {

	Long savePatient(Patient patient);

	void updatePatient(Patient patient);

	void deletePatient(Long id);

	Patient getOnePatient(Long id);

	List<Patient> getAllPatients();
	

}
