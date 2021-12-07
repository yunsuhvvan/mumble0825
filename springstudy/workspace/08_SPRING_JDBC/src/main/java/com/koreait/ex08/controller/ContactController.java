package com.koreait.ex08.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koreait.ex08.domain.Contact;
import com.koreait.ex08.service.ContactService;

@Controller
@RequestMapping(value = "contact")
public class ContactController {
	
	//field
	@Autowired
	private ContactService service;

	//method
	@GetMapping("findAllContact")
	public String findAllContact(Model model) {
		model.addAttribute("list", service.findAllContact());
		return "contact/list";
	}
	
	@GetMapping(value = "contactPage")
	public String contactPage() {
		return "contact/insert";
	}
	
	@PostMapping(value = "addContact" )
	public String addContact(Contact contact) {
		service.addContact(contact);
		return "redirect:findAllContact";
	}
	@GetMapping(value = "findContact")
	public String findContact(Contact contact, Model model) {
		model.addAttribute("contact", service.findContact(contact)); // 의 결과
		return "contact/detail";
	}

	@GetMapping(value = "updateContact")
	public String updateContact(Contact contact) {
		service.updateContact(contact);
		return "redirect:findContact?no=" + contact.getNo();
	}
	
	@GetMapping(value = "deleteContact")
	public String deleteContact(Contact contact) {
		service.deleteContact(contact);
		return "redirect:findAllContact";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}