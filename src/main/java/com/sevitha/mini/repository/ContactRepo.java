package com.sevitha.mini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sevitha.mini.entities.Contact;

@Repository
public interface ContactRepo extends JpaRepository<Contact, Integer> {

}
