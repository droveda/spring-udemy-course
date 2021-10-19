package com.droveda.sbproject.repository;

import com.droveda.sbproject.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookSpringDataRepository extends JpaRepository<Book, Long> {


}
