package org.wecancodeit.Route.Review.Site;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class ReviewSiteRepository {

	private Map<Long, Route> routeList = new HashMap<>();
	private Route routeOne = new Route(1L, "Twinky", "twinky.img", "5.12a", "Steepest route in the Red");
	private Route routeTwo = new Route(2L, "Phantasia", "phantasia.img", "5.12d", "Next to Twinky");
	private Route routeThree = new Route(3L, "Bedtime for Bonzo", "bedtime.img", "5.6 Trad", "Entry level traditional route, for those seeking adventure.");
	
	public ReviewSiteRepository() {
		routeList.put(routeOne.getId(), routeOne);
		routeList.put(routeTwo.getId(), routeTwo);
		routeList.put(routeThree.getId(), routeThree);
	}
	
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
