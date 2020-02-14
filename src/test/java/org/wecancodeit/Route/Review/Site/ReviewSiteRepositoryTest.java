package org.wecancodeit.Route.Review.Site;


import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import javax.annotation.Resource;

import org.junit.Test;

public class ReviewSiteRepositoryTest {

	@Resource
	private ReviewSiteRepository underTest;
	
	private Route routeOne = new Route(1L, "route name", "image url", "route grade", "description");
	private Route routeTwo = new Route(2L, "route name", "image url", "route grade", "description");
	
	@Test
	public void shouldFindReviewOneById() {
		underTest = new ReviewSiteRepository(routeOne);
		Route foundRoute = underTest.findOneRoute(1L);
		assertThat(foundRoute, is(routeOne));
	}
	
	@Test
	public void shouldFindSecondRouteById() {
		underTest = new ReviewSiteRepository(routeTwo);
		Route foundRoute = underTest.findOneRoute(2L);
		assertThat(foundRoute, is(routeTwo));
	}
	
	@Test
	public void shouldFindAllRoutes() {
		underTest = new ReviewSiteRepository(routeOne, routeTwo);
		Collection<Route> foundRoutes = underTest.findAllRoutes();
		assertThat(foundRoutes, containsInAnyOrder(routeOne, routeTwo));
	}
	
	
	
	
	
	
	
	
}
