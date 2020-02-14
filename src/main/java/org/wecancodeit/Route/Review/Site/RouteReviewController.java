package org.wecancodeit.Route.Review.Site;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouteReviewController {

	
	@GetMapping("localhost:8080/show-routes")
	public String findAllRoutes(Model model) {
		return "routes-template";
		
	}
}
