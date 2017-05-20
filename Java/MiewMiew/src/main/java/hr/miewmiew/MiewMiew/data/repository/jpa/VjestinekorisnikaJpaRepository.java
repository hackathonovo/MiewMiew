package hr.miewmiew.MiewMiew.data.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import hr.miewmiew.MiewMiew.dbmodel.jpa.VjestinekorisnikaEntity;

/**
 * Repository : Vjestinekorisnika.
 */
public interface VjestinekorisnikaJpaRepository extends JpaRepository<VjestinekorisnikaEntity, Integer> {

}
