package org.omc.seguro.service;

import java.util.ArrayList;
import java.util.List;

import org.omc.seguro.NegocioEntity;
import org.omc.seguro.dao.NegocioDAO;
import org.omc.seguro.dao.NegocioJdbcTemplateDAO;
import org.omc.seguro.parse.ParseUtil;
import org.omc.seguro.repository.INegocioRepository;
import org.omc.seguro.to.NegocioTO;
import org.springframework.beans.factory.annotation.Autowired;
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
	INegocioRepository negocioRepository;

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
		return ParseUtil.parseObjectAForB(negocioRepository.findOne(1), NegocioTO.class);
	}

	@SuppressWarnings("unchecked")
	public List<NegocioTO> getNegociosSpringDataJPA() {
		return (List<NegocioTO>) ParseUtil.parseEntitiesForTOs(negocioRepository.findAll(), new ArrayList<NegocioTO>());
	}

}