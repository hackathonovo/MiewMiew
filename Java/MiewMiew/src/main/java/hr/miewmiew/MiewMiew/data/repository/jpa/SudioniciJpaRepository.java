package hr.miewmiew.MiewMiew.data.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import hr.miewmiew.MiewMiew.dbmodel.jpa.SudioniciEntity;
import hr.miewmiew.MiewMiew.dbmodel.jpa.SudioniciEntityKey;

/**
 * Repository : Sudionici.
 */
public interface SudioniciJpaRepository extends JpaRepository<SudioniciEntity, SudioniciEntityKey> {

}
