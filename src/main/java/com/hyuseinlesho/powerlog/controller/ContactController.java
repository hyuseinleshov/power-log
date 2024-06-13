package com.hyuseinlesho.powerlog.controller;

import com.hyuseinlesho.powerlog.dto.ContactDto;
import com.hyuseinlesho.powerlog.service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactController {
    private static final String CONTACT_MESSAGE_SUCCESS = "Thank you for your message! We'll get back to you soon.";
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/contact")
    public String showContactForm(Model model) {
        model.addAttribute("contactDto", new ContactDto());
        return "contact";
    }

    @PostMapping("/contact")
    public String submitContactForm(ContactDto contactDto, Model model) {
        contactService.saveContact(contactDto);
        model.addAttribute("message", CONTACT_MESSAGE_SUCCESS);
        model.addAttribute("contactDto", new ContactDto());
        return "contact";
    }
}
