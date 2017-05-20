package hr.miewmiew.MiewMiew.data.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import hr.miewmiew.MiewMiew.dbmodel.jpa.SocketEntity;

/**
 * Repository : Socket.
 */
public interface SocketJpaRepository extends JpaRepository<SocketEntity, Integer> {

}
