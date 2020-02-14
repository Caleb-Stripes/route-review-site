package org.wecancodeit.Route.Review.Site;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(RouteReviewController.class)

public class RouteReviewControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void shouldGetStatusOfOkWhenNavigatingToAllCourses() throws Exception {
		this.mockMvc.perform(get("localhost:8080/show-routes")).andExpect(status().isOk());
	}
	
}
