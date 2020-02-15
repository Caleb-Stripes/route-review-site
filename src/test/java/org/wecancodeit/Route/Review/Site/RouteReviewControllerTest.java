package org.wecancodeit.Route.Review.Site;


import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(RouteReviewController.class)

public class RouteReviewControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private Route routeOne;
	
	@Mock
	private Route routeTwo;
	
	@MockBean
	private ReviewSiteRepository routeRepo;
	
	@Test
	public void shouldGetStatusOfOkWhenNavigatingToAllCourses() throws Exception {
		this.mockMvc.perform(get("/show-routes")).andExpect(status().isOk())
		.andExpect(view().name("routes-templates"));
	}
	
	@Test
	public void shouldGetStatusOfOkWhenNavigattingToRouteOnePage() throws Exception {
		when(routeRepo.findOneRoute(1L)).thenReturn(routeOne);
		this.mockMvc.perform(get("/show-single-route?id=1")).andExpect(status().isOk())
		.andExpect(view().name("route-template"));
	}
	
	@Test
	public void shouldAddAllRoutesToTheModel() throws Exception {
		when(routeRepo.findAllRoutes()).thenReturn(Arrays.asList(routeOne, routeTwo));
		this.mockMvc.perform(get("/show-routes")).andExpect(model().attribute("routesModel", hasSize(2)));
	}
	
	@Test
	public void shouldAddSingleRouteToModel() throws Exception {
		when(routeRepo.findOneRoute(1L)).thenReturn(routeOne);
		this.mockMvc.perform(get("/show-single-route?id=1")).andExpect(model().attribute("routeModel", is(routeOne)));
	}
	
	@Test
	public void shouldReturnNotFoundForBadRequest() throws Exception {
		Long badId = 90L;
		when(routeRepo.findOneRoute(badId)).thenReturn(null);
		this.mockMvc.perform(get("/show-single-route?id=90")).andExpect(status().isNotFound());
	}
	
	
}
