package com.example.demo.services;

import com.example.demo.entities.Contacts;
import com.example.demo.repos.ContactsRepo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContactsServiceTest {

    @Autowired
    private ContactsService contactsService;

    @MockBean
    private ContactsRepo contactsRepo;

    @Test
    public void getContacts() {
        Contacts response = new Contacts();

        Optional<Contacts> optionalContacts = Optional.of(response);

        Mockito.when(contactsService.getContacts()).thenReturn(optionalContacts);
        Assert.assertEquals(contactsService.getContacts(), optionalContacts);
    }
}