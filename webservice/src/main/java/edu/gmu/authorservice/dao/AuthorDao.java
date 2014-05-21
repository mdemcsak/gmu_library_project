package edu.gmu.authorservice.dao;

import edu.gmu.authorservice.model.Author;

import java.util.Collection;

public interface AuthorDao {

    Author getAuthor(Integer id);

    Collection<Author> getAllAuthors();

}
