package org.omc.seguro.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.omc.seguro.NegocioEntity;
import org.omc.seguro.dao.NegocioDAO;
import org.omc.seguro.dao.NegocioJdbcTemplateDAO;
import org.omc.seguro.repository.INegocioRepository;
import org.omc.seguro.to.NegocioTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author ocean
 *
 */
@Service
public class NegocioService {
	
	private static ObjectMapper MAPPER = new ObjectMapper();
	
	@Autowired NegocioDAO negocioDAO;
	
	@Autowired NegocioJdbcTemplateDAO negocioJdbcTemplateDAO;
	
	@Autowired INegocioRepository negocioRepository;


	public NegocioTO getNegocio() {				
		return parseEntityForTO(negocioDAO.getNegocio());		
	}
	
	public List<NegocioTO> getNegocios() {
		return parseEntitiesForTOs(negocioDAO.getNegocios());
	}
	
	public NegocioTO getNegocioJdbcTemplate() {				
		return parseEntityForTO(negocioJdbcTemplateDAO.getNegocio());		
	}
	
	public List<NegocioTO> getNegociosJdbcTemplate() {
		return parseEntitiesForTOs(negocioJdbcTemplateDAO.getNegocios());
	}
	
	public NegocioTO getNegocioSpringDataJPA() {				
		return parseEntityForTO(negocioRepository.findOne(1));		
	}
	
	public List<NegocioTO> getNegociosSpringDataJPA() {
		return parseEntitiesForTOs(negocioRepository.findAll());
	}
	
	
	public List<NegocioTO> parseEntitiesForTOs(List<NegocioEntity> entities) {
		List<NegocioTO> tos = new ArrayList<>();
		try {
			
			String json = MAPPER.writeValueAsString(entities);
			tos =  MAPPER.readValue(json, new TypeReference<List<NegocioTO>>() {});
			
		} catch (JsonProcessingException e) {		
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return tos;
	}

	public NegocioTO parseEntityForTO(NegocioEntity entity) {
		NegocioTO to = new NegocioTO();
		try {
			
			String json = MAPPER.writeValueAsString(entity);
			to = MAPPER.readValue(json, NegocioTO.class);
			
		} catch (JsonProcessingException e) {		
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return to;
	}
	
	
	}