package hr.miewmiew.MiewMiew.data.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.miewmiew.MiewMiew.dbmodel.jpa.AkcijaspasavanjeEntity;

/**
 * Repository : Akcijaspasavanje.
 */
public interface AkcijaspasavanjeJpaRepository extends JpaRepository<AkcijaspasavanjeEntity, Integer> {
	
	AkcijaspasavanjeEntity findById(Integer akcijaId);
	
}
