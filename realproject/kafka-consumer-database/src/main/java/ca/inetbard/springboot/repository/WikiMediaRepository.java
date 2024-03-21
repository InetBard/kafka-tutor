package ca.inetbard.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.inetbard.springboot.model.WikimediaData;

public interface WikiMediaRepository extends JpaRepository<WikimediaData, Long> {

}
