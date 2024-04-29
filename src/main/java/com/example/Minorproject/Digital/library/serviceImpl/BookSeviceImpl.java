package com.example.Minorproject.Digital.library.serviceImpl;

import com.example.Minorproject.Digital.library.Models.Author;
import com.example.Minorproject.Digital.library.Models.Book;
import com.example.Minorproject.Digital.library.enums.BookFilterType;
import com.example.Minorproject.Digital.library.enums.Genre;
import com.example.Minorproject.Digital.library.repository.BookRepositoryInterf;
import com.example.Minorproject.Digital.library.requests.BookCreateRequest;
import com.example.Minorproject.Digital.library.service.AuthorServiceInterf;
import com.example.Minorproject.Digital.library.service.BookServiceInterf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class BookSeviceImpl implements BookServiceInterf {
    @Autowired
    BookRepositoryInterf bookRepositoryInterf;

    @Autowired
    AuthorServiceInterf authorServiceInterf;

    @Autowired
    EntityManager entityManager;

    @Override
    public Book saveBook(BookCreateRequest bookCreateRequest) {
        Book book = bookCreateRequest.toBook();
        //logic to check if the book is duplicate
        Author author = book.getAuthor();
        //logic to check if the author is duplicate
        Author authorFromdb = authorServiceInterf.findByEmail(author.getEmail());

        if (authorFromdb == null) {
            authorFromdb = authorServiceInterf.saveAuthor(author);
        }
        book.setAuthor(authorFromdb);
        return bookRepositoryInterf.save(book);

    }

    @Override
    public List<Book> findBooks(BookFilterType bookFilterType, String value) {
        switch (bookFilterType) {
            case NAME:
                return bookRepositoryInterf.findByName(value);
            case AUTHOR_NAME:
                return bookRepositoryInterf.findByAuthor_name(value);
            case GENRE:
                return bookRepositoryInterf.findByGenre(Genre.valueOf(value));
            case COST:
                return bookRepositoryInterf.findByCost(Integer.parseInt(value));
            case ID:
                return bookRepositoryInterf.findAllById(new ArrayList<Integer>(Integer.parseInt(value)));
            default:
                return new ArrayList<Book>();

        }
    }

    @Override
    public Optional<Book> findBYId(Integer id) {
        return bookRepositoryInterf.findById(id);
    }

    @Override
    public Book save(Book book) {
        return bookRepositoryInterf.save(book);
    }

    public List<Book> getBooksByCriteria(BookCreateRequest bookCreateRequest){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);

        Root<Book> book = cq.from(Book.class);
        List<Predicate> predicates = new ArrayList<>();

        // select * from book where name like %java%
        if(bookCreateRequest.getName() != null){
            predicates.add(cb.like(book.get("name"),"%"+bookCreateRequest.getName()+"%"));
        }

        if(bookCreateRequest.getCost() != 0){
            predicates.add(cb.ge(book.get("cost"),bookCreateRequest.getCost()));
        }

        cq.where(predicates.toArray(new Predicate[0]));
        return entityManager.createQuery(cq).getResultList();
    }
}