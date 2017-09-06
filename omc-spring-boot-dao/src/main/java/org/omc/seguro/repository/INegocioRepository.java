package org.omc.seguro.repository;

import org.omc.seguro.NegocioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INegocioRepository extends JpaRepository<NegocioEntity, Integer> {

}
