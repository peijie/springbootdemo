package com.mountainwind.tutorial.actuator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contacts")
public class ContactRestController {
  
  @Autowired
  @Qualifier("CustomContactRepository")
  private ContactRepository repo;
  
  @RequestMapping(method=RequestMethod.GET)
  public List<Contact> getAll() {
    return repo.findAll();
  }
  
  @RequestMapping(value="/{id}", method=RequestMethod.GET)
  public Contact find(@PathVariable String id) {
	  return repo.findOne(id);
  }
  
  @RequestMapping(method=RequestMethod.POST)
  public Contact create(@RequestBody Contact contact) {
    return repo.save(contact);
  }
  
  @RequestMapping(method=RequestMethod.DELETE, value="{id}")
  public void delete(@PathVariable String id) {
    repo.delete(id);
  }
  
  @RequestMapping(method=RequestMethod.PUT, value="{id}")
  public Contact update(@PathVariable String id, @RequestBody Contact contact) {
    Contact update = repo.findOne(id);
    update.setAddress(contact.getAddress());
    update.setEmail(contact.getEmail());
    update.setFacebookProfile(contact.getFacebookProfile());
    update.setFirstName(contact.getFirstName());
    update.setGooglePlusProfile(contact.getGooglePlusProfile());
    update.setLastName(contact.getLastName());
    update.setLinkedInProfile(contact.getLinkedInProfile());
    update.setPhoneNumber(contact.getPhoneNumber());
    update.setTwitterHandle(contact.getTwitterHandle());
    return repo.save(update);
  }

}