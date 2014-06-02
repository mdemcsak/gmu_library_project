package edu.gmu.authorservice.dao;

import edu.gmu.authorservice.model.Author;
import org.sqlite.SQLiteDataSource;

import javax.activation.DataSource;
import java.util.Collection;

public interface AuthorDao {

    void populateAuthors(SQLiteDataSource ds);

    Author getAuthor(Integer id);

    Collection<Author> getAllAuthors();

}
