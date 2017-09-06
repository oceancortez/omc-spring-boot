/**
 * 
 */
package org.omc.seguro.dao;

import java.util.List;

import org.omc.seguro.NegocioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author ocean
 *
 */
@Repository
public class NegocioJdbcTemplateDAO  {
	
	@Autowired
	JdbcTemplate jdbcTemplate;	
	
	public List<NegocioEntity> getNegocios() {
		return this.jdbcTemplate.query("SELECT * from NEGOCIO n ", new BeanPropertyRowMapper<NegocioEntity>(NegocioEntity.class));
	}

	public NegocioEntity getNegocio() {
		return  this.jdbcTemplate.queryForObject("SELECT * from NEGOCIO n ", new BeanPropertyRowMapper<NegocioEntity>(NegocioEntity.class));
		
	}
}
