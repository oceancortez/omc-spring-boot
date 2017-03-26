/**
 * 
 */
package omc.pedidos.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import omc.pedidos.entity.ClienteEntity;

/**
 * @author ocean
 *
 */
@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long>{

}
