package mycontact.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mycontact.web.entity.Contact;
import mycontact.web.service.ContactService;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;
	
	@GetMapping("/contact")	//nhan HTTP request có HTTP method là GET và URI pattern là /contact
	public String list(Model model) {
		//Model transfer data from controller to view
		model.addAttribute("contacts", contactService.findAll());
		return "list"; //view : list.html
	}
	
	//method search to process submit form action
	@GetMapping("/contact/search") //value of action of search form
	public String search(@RequestParam("term") String term, Model model) {//term : value of name property of input
	    if (StringUtils.isEmpty(term)) {
	        return "redirect:/contact";
	    }

	    model.addAttribute("contacts", contactService.search(term));
	    return "list";
	}
	
	//display contact form
	@GetMapping("/contact/add")
	public String add(Model model) {
		//pass a model with name: contact
		//every prop of model relative to 1 input of form.html
	    model.addAttribute("contact", new Contact());
	    return "form";
	}
	
	//validation input
	@PostMapping("/contact/save")
	public String save(@Valid Contact contact, BindingResult result, RedirectAttributes redirect) {
	    if (result.hasErrors()) {
	        return "form";
	    }
	    contactService.save(contact);
	    redirect.addFlashAttribute("successMessage", "Saved contact successfully!");
	    return "redirect:/contact";
	}
	//contact: obj pass from add() to form (save info which user input)
	//FlashAttribute : mess annotate that saved sucessfully
	
	//
	@GetMapping("/contact/{id}/edit")
	public String edit(@PathVariable("id") Integer id, Model model) {
	    model.addAttribute("contact", contactService.findOne(id));
	    return "form";
	}
	
	@GetMapping("/contact/{id}/delete")
	public String delete(@PathVariable int id, RedirectAttributes redirect) {
	    contactService.delete(id);
	    redirect.addFlashAttribute("successMessage", "Deleted contact successfully!");
	    return "redirect:/contact";
	}
	
	//======================================================
	
	
	//add method by me ^^
	@GetMapping("/contact/searchbyname") //value of action of search form
	public String searchByName(@RequestParam("name") String name, Model model) {
	    if (StringUtils.isEmpty(name)) {
	        return "redirect:/contact";
	    }

	    model.addAttribute("contacts", contactService.searchByName(name));
	    return "list";
	}
	
	@GetMapping("/contact/searchbyemail") //value of action of search form
	public String searchByEmail(@RequestParam("email") String email, Model model) {
	    if (StringUtils.isEmpty(email)) {
	        return "redirect:/contact";
	    }

	    model.addAttribute("contacts", contactService.searchByEmail(email));
	    return "list";
	}
	
	@GetMapping("/contact/searchbyaddress") //value of action of search form
	public String searchByAddress(@RequestParam("addressname") String address, Model model) {
	    if (StringUtils.isEmpty(address)) {
	        return "redirect:/contact";
	    }

	    model.addAttribute("contacts", contactService.searchByAddress(address));
	    return "list";
	}
	
	

}
