package org.omc.seguro.service;
/**
 * 
 */

import java.util.List;

import org.omc.seguro.NegocioEntity;
import org.omc.seguro.dao.NegocioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ocean
 *
 */
@Service
public class NegocioService {
	
	@Autowired NegocioDAO negocioDAO; 
	
	public List<NegocioEntity> getNegocios() {
		return negocioDAO.getNegocios();
	}

}
