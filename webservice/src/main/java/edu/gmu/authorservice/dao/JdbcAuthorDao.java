package edu.gmu.authorservice.dao;

import edu.gmu.authorservice.model.Author;

import javax.activation.DataSource;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import org.sqlite.SQLiteDataSource;

public class JdbcAuthorDao implements AuthorDao {

    private Author _author;

    private Collection<Author> _authorlist;

    public void populateAuthors(SQLiteDataSource ds){
        _authorlist = new ArrayList<Author>();
        String sql = "SELECT * FROM authors";
        try (Connection conn = ds.getConnection())
        {
            java.sql.Statement stmt = conn.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                Author auth = new Author();
                auth.setId(rs.getInt("id"));
                auth.setName(rs.getString("name"));
                auth.setDob(rs.getDate("dob"));
                auth.setNationality(rs.getString("nationality"));
                auth.setBiography(rs.getString("biography"));
                auth.setAwards(rs.getString("awards"));
                auth.setImage_url(rs.getString("image_url"));
                _authorlist.add(auth);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Author getAuthor(Integer id) {
        for (Author author: _authorlist){
            if(author.getId() == id)
            {
                return author;
            }
        }
        return null;
    }

    @Override
    public Collection<Author> getAllAuthors() {
        return _authorlist;
    }
}

