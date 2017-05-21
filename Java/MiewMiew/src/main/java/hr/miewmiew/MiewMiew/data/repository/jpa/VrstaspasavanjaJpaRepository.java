package hr.miewmiew.MiewMiew.data.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.miewmiew.MiewMiew.dbmodel.jpa.VrstaspasavanjaEntity;

/**
 * Repository : Vrstaspasavanja.
 */
public interface VrstaspasavanjaJpaRepository extends JpaRepository<VrstaspasavanjaEntity, Integer> {
	
	List<VrstaspasavanjaEntity> findById(int id);
	
}
