package com.addressbook.mappings;

import com.addressbook.dtos.PhoneDTO;
import com.addressbook.entities.Phone;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ContactMapper.class})
public interface PhoneMapper {
    @Mapping(source = "contact.id", target = "contactId")
    PhoneDTO toPhoneDTO(Phone phone);

    @Mapping(source = "contactId", target = "contact.id")
    Phone toPhone(PhoneDTO phoneDTO);
}