package hr.miewmiew.MiewMiew.data.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import hr.miewmiew.MiewMiew.dbmodel.jpa.AspnetuserloginsEntity;
import hr.miewmiew.MiewMiew.dbmodel.jpa.AspnetuserloginsEntityKey;

/**
 * Repository : Aspnetuserlogins.
 */
public interface AspnetuserloginsJpaRepository extends JpaRepository<AspnetuserloginsEntity, AspnetuserloginsEntityKey> {

}
