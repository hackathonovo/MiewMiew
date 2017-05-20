package hr.miewmiew.MiewMiew.data.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import hr.miewmiew.MiewMiew.dbmodel.jpa.KompetencijekorisnikaEntity;

/**
 * Repository : Kompetencijekorisnika.
 */
public interface KompetencijekorisnikaJpaRepository extends JpaRepository<KompetencijekorisnikaEntity, Integer> {

}
