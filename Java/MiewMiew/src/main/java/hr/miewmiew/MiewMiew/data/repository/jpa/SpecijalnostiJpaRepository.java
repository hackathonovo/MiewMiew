package hr.miewmiew.MiewMiew.data.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.miewmiew.MiewMiew.dbmodel.jpa.SpecijalnostiEntity;

/**
 * Repository : Specijalnosti.
 */
public interface SpecijalnostiJpaRepository extends JpaRepository<SpecijalnostiEntity, Integer> {
	
	List<SpecijalnostiEntity> findById(Integer id);
	
}
