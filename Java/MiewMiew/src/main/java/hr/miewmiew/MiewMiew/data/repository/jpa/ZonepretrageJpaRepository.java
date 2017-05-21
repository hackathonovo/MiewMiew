package hr.miewmiew.MiewMiew.data.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hr.miewmiew.MiewMiew.dbmodel.jpa.ZonepretrageEntity;

/**
 * Repository : Zonepretrage.
 */
public interface ZonepretrageJpaRepository extends JpaRepository<ZonepretrageEntity, Integer> {
	
	@Query("select s from ZonepretrageEntity s where (s.akcijaspasavanje.id =?)")
	List<ZonepretrageEntity> findByAkcijaId(Integer akcijaId);
	
}
