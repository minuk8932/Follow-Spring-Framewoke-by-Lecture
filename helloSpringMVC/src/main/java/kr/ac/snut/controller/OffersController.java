package kr.ac.snut.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.snut.model.Offer;
import kr.ac.snut.service.OffersService;

@Controller
public class OffersController {
	private OffersService offersService;
	
	@Autowired
	public void setOffersService(OffersService offersService) {
		this.offersService = offersService;
	}

	@RequestMapping("/offers")
	public String showOffers(Model model) {
		List<Offer> offers = offersService.getCurrent();
		
		model.addAttribute("offers", offers);
		return "offers";
	}
	
	@RequestMapping("/createoffer")
	public String createOffer(Model model) {
		
		return "createoffer";
	}
	
	@RequestMapping("/docreate")
	public String doCreate(Model model, Offer offer) {
		offersService.insert(offer);
		
		return "offercreated";
	}
}
