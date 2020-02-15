package org.wecancodeit.Route.Review.Site;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason= "I don't have a route for that.")
public class RouteNotFoundException extends Exception {

}
