package org.jhonnytunes.simulation.flowvehicles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StreetFactory {

	private StreetFactory() {
		// TODO Auto-generated constructor stub
	}

	private static Map<String, Street> streets;

	public static Street getStreet(String name ){
		 
		if(streets == null) streets = new HashMap<String,Street>();

		if(!streets.containsKey(name))
		   streets.put(name, new Street(name));

		return streets.get(name);
	}

}
