package com.gym.phoenixgym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gym.phoenixgym.entity.Enquiry;
import com.gym.phoenixgym.service.EnquiryService;



@CrossOrigin
@RestController
public class EnquiryController {

	@Autowired
	private EnquiryService enquiryService;
	
	@PostMapping("/requests")
	public Enquiry insertEnquiry(@RequestBody Enquiry enquiry) {
		return enquiryService.insertEnquiry(enquiry);
	}
	
	@GetMapping("/requests")
	public List<Enquiry> getAllEnquiry() {	
		return enquiryService.getAllEnquiry();
	}
	
	@GetMapping("/requests/{remail}")
	public List<Enquiry> getEnquiryByEmail(@PathVariable String remail) {	
		return 	enquiryService.getEnquiryByEmail(remail);
	}
	
	@GetMapping("/getrequests/{rid}")
	public List<Enquiry> getEnquiryById(@PathVariable int rid) {	
		return enquiryService.getEnquiryById(rid);
	}
	
	@PostMapping("/pendingrequests")
	public List<Enquiry> getPendingEnquiry(@RequestBody Enquiry enquiry){
		return enquiryService.pendingEnquiry(enquiry.getEmail(), false);
	}
	
	@GetMapping("/viewallpendingrequests")
	public List<Enquiry> getPendingEnquiry(boolean status){
		return enquiryService.viewAllPendingEnquiry(false);
	}
	
	@GetMapping("/viewcollections")
	public List<Enquiry> viewAllPackages(boolean status){
		return enquiryService.viewAllPackages(status);
	}
	
	@PostMapping("/viewdonations")
	public List<Enquiry> viewpackages(@RequestBody  Enquiry enquiry){
		return enquiryService.viewPackages(enquiry.getEmail(), true);
	}
	@PutMapping("/requests")
	public Enquiry updateEnquiry(@RequestBody Enquiry enquiry) {	
		return 	enquiryService.updateEnquiry(enquiry);
	}
	
	@DeleteMapping("/requests/{rid}")
	public String deleteEnquiry(@PathVariable int rid) {	
		enquiryService.deleteEnquiry(rid); 
			
		 return "Deleted";
	}
	
	
}
