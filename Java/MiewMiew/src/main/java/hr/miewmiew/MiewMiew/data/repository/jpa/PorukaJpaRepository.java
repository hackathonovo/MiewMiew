package hr.miewmiew.MiewMiew.data.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import hr.miewmiew.MiewMiew.dbmodel.jpa.PorukaEntity;

/**
 * Repository : Poruka.
 */
public interface PorukaJpaRepository extends JpaRepository<PorukaEntity, Integer> {

}
