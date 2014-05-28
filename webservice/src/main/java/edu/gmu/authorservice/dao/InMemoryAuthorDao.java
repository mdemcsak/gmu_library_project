package edu.gmu.authorservice.dao;

import edu.gmu.authorservice.model.Author;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class InMemoryAuthorDao implements AuthorDao {

    private Author _author;

    private Collection<Author> _authorlist;

    public void populateAuthors(){
        _authorlist = new ArrayList<Author>();
        Date now = new Date();
        _author = new Author(1, "J. R. R. Tolkien", now, "British", "John Ronald Reuel Tolkien, CBE (tol-keen; 3 January 1892 – 2 September 1973) was an English writer, poet, philologist, and university professor, best known as the author of the classic high fantasy works The Hobbit, The Lord of the Rings, and The Silmarillion.", null, "http://upload.wikimedia.org/wikipedia/commons/b/b4/Tolkien_1916.jpg");
        _authorlist.add(_author);
        _author = new Author(2, "Ayn Rand", now, "United States", "Ayn Rand (born Alisa Zinovyevna Rosenbaum; February 2 [O.S. January 20] 1905 – March 6, 1982) was an American novelist, philosopher,[2] playwright, and screenwriter. She is known for her two best-selling novels, The Fountainhead and Atlas Shrugged, and for developing a philosophical system she called Objectivism. Born and educated in Russia, Rand moved to the United States in 1926. She had a play produced on Broadway in 1935–1936. After two early novels that were initially unsuccessful in America, she achieved fame with her 1943 novel, The Fountainhead.", "Prometheus Award - Hall of Fame (1983 Atlas Shrugged, 1987 Anthem)", "http://upload.wikimedia.org/wikipedia/en/3/32/Ayn_Rand1.jpg");
        _authorlist.add(_author);
        _author = new Author(3, "Orson Scott Card", now, "United States", "Orson Scott Card (born August 24, 1951)[5] is an American novelist, critic, public speaker, essayist and columnist. He writes in several genres but is known best for science fiction. His novel Ender\"s Game (1985) and its sequel Speaker for the Dead (1986) both won Hugo and Nebula Awards, making Card the only author to win both science fiction\"s top U.S. prizes in consecutive years.", "Hugo Award (Enders Game; 1986 Speaker for the Dead, 1987; How to Write Science Fiction and Fantasy, 1991), Nebula Award (Enders Game, 1986; Speaker for the Dead, 1987; Eye for Eye, 1988)", "http://upload.wikimedia.org/wikipedia/commons/thumb/6/6e/Orson_Scott_Card_at_BYU_Symposium_20080216_closeup.jpg/500px-Orson_Scott_Card_at_BYU_Symposium_20080216_closeup.jpg");
        _authorlist.add(_author);
        _author = new Author(4, "William Shakespeare", now, "British", "William Shakespeare (26 April 1564 (baptised) – 23 April 1616) was an English poet, playwright and actor, widely regarded as the greatest writer in the English language and the worlds pre-eminent dramatist. He is often called Englands national poet and the \"Bard of Avon\". His extant works, including some collaborations, consist of about 38 plays, 154 sonnets, two long narrative poems, and a few other verses, the authorship of some of which is uncertain. His plays have been translated into every major living language and are performed more often than those of any other playwright.", null, "http://upload.wikimedia.org/wikipedia/commons/thumb/a/a2/Shakespeare.jpg/500px-Shakespeare.jpg");
        _authorlist.add(_author);
        _author = new Author(5, "Daniel Suarez", now, "United States", "Daniel Suarez (born December 21, 1964) is an American information technology consultant turned author. He initially published under the pseudonym Leinad Zeraus (his name spelled backwards). His career as an author began with a pair of techno-thriller novels. The first one, Daemon, originally was self-published under his own company Verdugo Press in late 2006. It was later picked up by the major publishing house Dutton and re-released on January 8, 2009. His follow-up book FreedomTM was released on January 7, 2010.", null, "http://upload.wikimedia.org/wikipedia/commons/thumb/6/61/Daniel_Suarez_2014_%28cropped%29.jpg/440px-Daniel_Suarez_2014_%28cropped%29.jpg");
        _authorlist.add(_author);
        _author = new Author(6, "Neal Stephenson", now, "United States", "Neal Town Stephenson (born October 31, 1959) is an American author and game designer known for his works of speculative fiction. His novels have been variously categorized as science fiction, historical fiction, cyberpunk, and postcyberpunk. Other labels, such as baroque, often appear. Stephenson explores subjects such as mathematics, cryptography, philosophy, currency, and the history of science. He also writes non-fiction articles about technology in publications such as Wired.", "Hugo, Nebula, and Prometheus Awards", "http://upload.wikimedia.org/wikipedia/commons/thumb/c/c2/Neal_Stephenson_2008_crop.jpg/440px-Neal_Stephenson_2008_crop.jpg");
        _authorlist.add(_author);
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
