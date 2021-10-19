package com.droveda.sbproject.repository;

import com.droveda.sbproject.model.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookRepository {

    @PersistenceContext
    private EntityManager em;

    public Book findById(long id) {
        return em.find(Book.class, id);
    }

    public Book save(Book book) {
        return em.merge(book);
    }

    public void deleteById(long id) {
        Book person = findById(id);
        em.remove(person);
    }

    public List<Book> findAll() {
        TypedQuery<Book> namedQuery = em.createNamedQuery("find_all_books", Book.class);
        return namedQuery.getResultList();
    }

}
