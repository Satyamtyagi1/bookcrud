package com.contact.contactcrud;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    ContactRepository repo;

    // CREATE
    @PostMapping
    public Contact addContact(@RequestBody Contact contact) {
        return repo.save(contact);
    }

    // READ
    @GetMapping
    public List<Contact> getContacts() {
        return repo.findAll();
    }

    // UPDATE
    @PutMapping("/{id}")
    public Contact updateContact(@PathVariable int id, @RequestBody Contact contact) {
        contact.setId(id);
        return repo.save(contact);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable int id) {
        repo.deleteById(id);
    }
}
