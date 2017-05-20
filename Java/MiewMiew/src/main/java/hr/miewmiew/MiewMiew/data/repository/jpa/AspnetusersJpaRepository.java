package hr.miewmiew.MiewMiew.data.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.miewmiew.MiewMiew.dbmodel.jpa.AspnetusersEntity;

/**
 * Repository : Aspnetusers.
 */
public interface AspnetusersJpaRepository extends JpaRepository<AspnetusersEntity, String> {
	
	List<AspnetusersEntity> findById(String id);
}
