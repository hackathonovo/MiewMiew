package hr.miewmiew.MiewMiew.data.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hr.miewmiew.MiewMiew.dbmodel.jpa.SudioniciEntity;
import hr.miewmiew.MiewMiew.dbmodel.jpa.SudioniciEntityKey;

/**
 * Repository : Sudionici.
 */
public interface SudioniciJpaRepository extends JpaRepository<SudioniciEntity, SudioniciEntityKey> {
	
	@Query("select s from SudioniciEntity s where (s.compositePrimaryKey.akcijaspasavanjaid =?)")
	List<SudioniciEntity> findById(Integer akcijaId);
	
}
