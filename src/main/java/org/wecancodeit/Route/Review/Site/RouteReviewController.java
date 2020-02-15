package org.wecancodeit.Route.Review.Site;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RouteReviewController {

	@Resource
	private ReviewSiteRepository routeRepo;
	
	@GetMapping("/show-routes")
	public String findAllRoutes(Model model) {
		model.addAttribute("routesModel", routeRepo.findAllRoutes());
		return "routes-templates";
		//src/main/resources/templates (name of template) + .html
	}
	
	@GetMapping("/show-single-route")
	public String findOneRoute(@RequestParam Long id, Model model) throws RouteNotFoundException {
		if(routeRepo.findOneRoute(id) == null) {
			throw new RouteNotFoundException();
		}
		model.addAttribute("routeModel", routeRepo.findOneRoute(id));
		return "route-template";
	}
}
