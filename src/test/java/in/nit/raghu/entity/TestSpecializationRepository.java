package in.nit.raghu.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import in.nit.raghu.repo.SpecializationRepository;

@DataJpaTest(showSql = true)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestMethodOrder(OrderAnnotation.class)
public class TestSpecializationRepository {
 
	@Autowired
	private SpecializationRepository repo;
	
	@Test
	@Order(1)
	@Disabled
	public void testSpecCreate() {
		Specialization spec = new Specialization(null, "CRDLS", "Cardiologist", "They're expert in Heart Deases");
		spec = repo.save(spec);
		assertNotNull(spec.getId(),"spec is not created");
	}
	
	@Test
	@Order(2)
	public void testSpectFetchAll() {
		List<Specialization> all = repo.findAll();
		assertNotNull(all);
		if(all.isEmpty()) {
			fail("No data exist in DB");
		}
	}
}
