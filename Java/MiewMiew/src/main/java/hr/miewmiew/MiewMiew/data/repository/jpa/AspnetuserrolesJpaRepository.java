package hr.miewmiew.MiewMiew.data.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import hr.miewmiew.MiewMiew.dbmodel.jpa.AspnetuserrolesEntity;
import hr.miewmiew.MiewMiew.dbmodel.jpa.AspnetuserrolesEntityKey;

/**
 * Repository : Aspnetuserroles.
 */
public interface AspnetuserrolesJpaRepository extends JpaRepository<AspnetuserrolesEntity, AspnetuserrolesEntityKey> {

}
