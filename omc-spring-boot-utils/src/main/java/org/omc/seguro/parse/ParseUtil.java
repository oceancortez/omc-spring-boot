package org.omc.seguro.parse;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ParseUtil {
	
	
	private static ObjectMapper MAPPER = new ObjectMapper();
	
	public static List<?> parseEntitiesForTOs(List<?> entities, List<?> tos) {		
		try {
			
			String json = MAPPER.writeValueAsString(entities);
			tos =  MAPPER.readValue(json, new TypeReference<List<?>>() {});
			
		} catch (JsonProcessingException e) {		
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return tos;
	}

	public static <T> T parseEntityForTO(Object entity, Class<T> clazz) {
		T to = null;
		try {
			
			String json = MAPPER.writeValueAsString(entity);
			to = MAPPER.readValue(json, clazz);
			
		} catch (JsonProcessingException e) {		
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return to;
	}

}
