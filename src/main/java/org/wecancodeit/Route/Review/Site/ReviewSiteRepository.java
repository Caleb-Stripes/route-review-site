package org.wecancodeit.Route.Review.Site;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ReviewSiteRepository {

	private Map<Long, Route> routeList = new HashMap<>();
	//private Route routeOne = new Route(1L, "Twinky", "twinky.img", "5.12a", "Steepest route in the Red");
	
	
	//uses varargs for testing purposes to take on necessary courses
	public ReviewSiteRepository(Route...routes) {
		for(Route route: routes) {
			routeList.put(route.getId(), route);
		}
	}

	public Route findOneRoute(long id) {
		return routeList.get(id);
	}

	public Collection<Route> findAllRoutes() {
		return routeList.values();
	}

}