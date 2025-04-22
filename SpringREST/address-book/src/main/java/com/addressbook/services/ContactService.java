package com.addressbook.services;

import com.addressbook.dtos.ContactDTO;
import com.addressbook.entities.Contact;
import com.addressbook.mappings.ContactMapper;
import com.addressbook.repositories.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactService {
    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;

    public ContactService(ContactRepository contactRepository, ContactMapper contactMapper) {
        this.contactRepository = contactRepository;
        this.contactMapper = contactMapper;
    }

    public List<ContactDTO> getAllContacts() {
        List<Contact> contacts = contactRepository.findAll();
        return contacts.stream().map(contactMapper::toContactDTO).collect(Collectors.toList());
    }

    public ContactDTO getContactById(int id) {
        Contact contact = contactRepository.findById(id).orElse(null);
        return contactMapper.toContactDTO(contact);
    }

    public ContactDTO addContact(ContactDTO contactDTO) {
        Contact contact = contactMapper.toContact(contactDTO);
        contact = contactRepository.save(contact);
        return contactMapper.toContactDTO(contact);
    }

    public ContactDTO updateContact(Integer id, ContactDTO contactDTO) {
        Contact contact = contactRepository.findById(id).orElse(null);
        if (contact != null) {
            return contactMapper.toContactDTO(contact);
        }
        return null;
    }

    public boolean deleteContact(Integer id) {
        if (contactRepository.findById(id).isPresent()) {
            contactRepository.deleteById(id);
            return true;
        }
        return false;
    }
}