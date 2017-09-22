package org.omc.seguro.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
import org.omc.seguro.NegocioEntity;
import org.omc.seguro.dao.NegocioDAO;
import org.omc.seguro.dao.NegocioJdbcTemplateDAO;
import org.omc.seguro.excpetion.SeguroExcpetion;
import org.omc.seguro.parse.ParseUtil;
import org.omc.seguro.repository.data.NegocioRepository;
import org.omc.seguro.to.NegocioTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

/**
 * @author ocean
 *
 */
@Service
public class NegocioService {

	@Autowired
	NegocioDAO negocioDAO;

	@Autowired
	NegocioJdbcTemplateDAO negocioJdbcTemplateDAO;

	@Autowired
	NegocioRepository negocioRepository;

	public NegocioTO getNegocioById(Long id) {
		NegocioEntity negocioEntity = negocioDAO.findById(id, NegocioEntity.class);
		return ParseUtil.parseObjectAForB(negocioEntity, NegocioTO.class);
	}

	@SuppressWarnings("unchecked")
	public List<NegocioTO> getNegocios() {
		return (List<NegocioTO>) ParseUtil.parseEntitiesForTOs(negocioDAO.getNegocios(), new ArrayList<NegocioTO>());
	}

	public NegocioTO getNegocioJdbcTemplate() {
		return ParseUtil.parseObjectAForB(negocioJdbcTemplateDAO.getNegocio(), NegocioTO.class);
	}

	@SuppressWarnings("unchecked")
	public List<NegocioTO> getNegociosJdbcTemplate() {
		return (List<NegocioTO>) ParseUtil.parseEntitiesForTOs(negocioJdbcTemplateDAO.getNegocios(),
				new ArrayList<NegocioTO>());
	}

	public NegocioTO getNegocioSpringDataJPA() {
		return ParseUtil.parseObjectAForB(negocioRepository.findOne(1L), NegocioTO.class);
	}

	@SuppressWarnings("unchecked")
	public List<NegocioTO> getNegociosSpringDataJPA() {
		return (List<NegocioTO>) ParseUtil.parseEntitiesForTOs(negocioRepository.findAll(), new ArrayList<NegocioTO>());
	}

	
	public NegocioTO saveNegocio(NegocioTO to) throws Exception {
		NegocioTO negocioTO = null;		
		try {
			NegocioEntity entity = ParseUtil.parseObjectAForB(to, NegocioEntity.class);
			entity = negocioRepository.save(entity);
			negocioTO = ParseUtil.parseObjectAForB(entity, NegocioTO.class);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return negocioTO;
	}


	public NegocioTO updateNegocio(NegocioTO to) throws Exception {
		NegocioTO negocioTO = null;			
		try {
			NegocioEntity entity = ParseUtil.parseObjectAForB(to, NegocioEntity.class);			
			entity = negocioRepository.saveAndFlush(entity);
			negocioTO = ParseUtil.parseObjectAForB(entity, NegocioTO.class);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return negocioTO;
	}


	public String deleteNegocio(Long cdNgoco, String tpHistoNgoco) throws Exception {
		try {			
			Optional<NegocioEntity> entity = negocioRepository.findByCdNgocoAndTpHistoNgoco(cdNgoco, tpHistoNgoco);
			if(entity.isPresent()) {
				negocioRepository.delete(entity.get());				
			} else {
				throw new Exception("Negocio não encontrado!");
			}
		} catch (DataIntegrityViolationException d) {
			if(d.getCause() instanceof ConstraintViolationException) {
				throw new SeguroExcpetion("O negocio " +cdNgoco+ " não pode ser excluído pois existem itens relacionados!");				
			}
			
			throw new Exception(d);
			
		} catch (Exception e) {
			throw new Exception(e);
		}		
		return "sucesso";
		
	}

}