package com.addressbook.mappings;



import com.addressbook.dtos.ContactDTO;
import com.addressbook.entities.Contact;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMapper {
    ContactDTO toContactDTO(Contact contact);

    Contact toContact(ContactDTO contactDTO);
}
