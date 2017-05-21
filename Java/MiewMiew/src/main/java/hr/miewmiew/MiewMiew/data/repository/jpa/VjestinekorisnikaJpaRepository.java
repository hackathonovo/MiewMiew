package hr.miewmiew.MiewMiew.data.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hr.miewmiew.MiewMiew.dbmodel.jpa.VjestinekorisnikaEntity;

/**
 * Repository : Vjestinekorisnika.
 */
public interface VjestinekorisnikaJpaRepository extends JpaRepository<VjestinekorisnikaEntity, Integer> {
	@Query("select s from VjestinekorisnikaEntity s where (s.aspnetusers.id =?)")
	List<VjestinekorisnikaEntity> findByAspnetusers(String userId);
	
}
