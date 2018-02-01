package com.guillaumetalbot.springdatarest.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.guillaumetalbot.springdatarest.entite.Donnee;

public interface DonneeRepository extends PagingAndSortingRepository<Donnee, Long> {

}
