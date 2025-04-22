package com.addressbook.services;

import com.addressbook.dtos.PhoneDTO;
import com.addressbook.entities.Phone;
import com.addressbook.mappings.PhoneMapper;
import com.addressbook.repositories.PhoneRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhoneService {
    private final PhoneRepository phoneRepository;
    private final PhoneMapper phoneMapper;

    public PhoneService(final PhoneRepository phoneRepository, final PhoneMapper phoneMapper) {
        this.phoneRepository = phoneRepository;
        this.phoneMapper = phoneMapper;
    }

    public List<PhoneDTO> getAllPhones() {
        List<Phone> phones = phoneRepository.findAll();
        return phones.stream().map(phoneMapper::toPhoneDTO).collect(Collectors.toList());
    }

    public PhoneDTO getPhoneById(int id) {
        Phone phone = phoneRepository.findById(id).orElse(null);
        return phoneMapper.toPhoneDTO(phone);
    }

    public PhoneDTO createPhone(PhoneDTO phoneDTO) {
        Phone phone = phoneMapper.toPhone(phoneDTO);
        phone = phoneRepository.save(phone);
        return phoneMapper.toPhoneDTO(phone);
    }

    public PhoneDTO updatePhone(int id, PhoneDTO phoneDTO) {
        Phone phone = phoneRepository.findById(id).orElse(null);
        if (phone != null) {
            return phoneMapper.toPhoneDTO(phone);
        }
        return null;
    }

    public boolean deletePhone(int id) {
        if (phoneRepository.findById(id).isPresent()) {
            phoneRepository.deleteById(id);
            return true;
        }
        return false;
    }
}