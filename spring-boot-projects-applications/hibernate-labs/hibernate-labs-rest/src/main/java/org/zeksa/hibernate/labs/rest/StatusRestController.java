package org.zeksa.hibernate.labs.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/status")
public class StatusRestController {

	@RequestMapping(value = "/up", method= RequestMethod.GET)
	public boolean isUp(){
		return true;
	}
}
