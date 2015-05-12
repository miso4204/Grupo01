package com.uniandes.stampidia.utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

public class ConvertObjetHelper {

	private static final ObjectMapper MAPPER = new ObjectMapper();

	static {
		MAPPER.registerModule(new Hibernate4Module());
		MAPPER.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false)
				.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
				.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,
						false)
				.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
						false)
				.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES,
						false);		
	}

	@SuppressWarnings("unchecked")
	public static Map<String, Object> objectToMap(Object entidad) {
		try {
			final ObjectWriter writer = MAPPER.writer();
			final String strObject = writer.writeValueAsString(entidad);
			return MAPPER.readValue(strObject, Map.class);
		} catch (final Exception e) {
			throw new IllegalArgumentException(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public static List<Map<String,Object>> listToMap(Object entidades){
		List<Map<String,Object>> lista = new ArrayList<Map<String,Object>>();
		for(Object entidad:(List<Object>)entidades){
			lista.add(objectToMap(entidad));
		}
		return lista;
	}
}
