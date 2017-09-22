package org.omc.seguro.repository;

import java.util.Optional;

import org.omc.seguro.NegocioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NegocioRepository extends JpaRepository<NegocioEntity, Long> {
	
	Optional<NegocioEntity> findByCdNgocoAndTpHistoNgoco(Long cdNgoco, String tpHistoNgoco);

}
