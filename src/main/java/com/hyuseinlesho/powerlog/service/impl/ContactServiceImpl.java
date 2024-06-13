package com.hyuseinlesho.powerlog.service.impl;

import com.hyuseinlesho.powerlog.dto.ContactDto;
import com.hyuseinlesho.powerlog.mapper.ContactMapper;
import com.hyuseinlesho.powerlog.model.Contact;
import com.hyuseinlesho.powerlog.repository.ContactRepository;
import com.hyuseinlesho.powerlog.service.ContactService;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public Contact saveContact(ContactDto contactDto) {
        Contact contact = ContactMapper.INSTANCE.contactDtoToContact(contactDto);

        return contactRepository.save(contact);
    }
}