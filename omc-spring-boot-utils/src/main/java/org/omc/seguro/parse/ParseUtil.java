package org.omc.seguro.parse;

import java.io.IOException;
import java.text.SimpleDateFormat;
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

	public static <T> T parseObjectAForB(Object entity, Class<T> clazz) {
		T to = null;
		try {
			
			String json = MAPPER.writeValueAsString(entity);
			// (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") para fazer o parse da data que veio do TO que esta com @JsonFormat
			to = (T) MAPPER.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).readValue(json, clazz);			
			
		} catch (JsonProcessingException e) {		
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return to;
	}

}
