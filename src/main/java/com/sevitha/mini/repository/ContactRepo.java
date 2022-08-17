package com.sevitha.mini.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sevitha.mini.entities.Contact;

public interface ContactRepo extends JpaRepository<Contact, Integer> {

}
