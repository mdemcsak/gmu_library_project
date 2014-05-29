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
        _author = new Author(1, "Michael Crichton", now, "American", "John Michael Crichton, MD was an American best-selling author, physician, producer, director, and screenwriter, best known for his work in the science fiction, medical fiction, and thriller genres. His books have sold over 200 million copies worldwide, and many have been adapted into films. In 1994 Crichton became the only creative artist ever to have works simultaneously charting at No. 1 in US television, film, and book sales (with ER, Jurassic Park, and Disclosure, respectively). His literary works are usually based on the action genre and heavily feature technology. His novels epitomize the techno-thriller genre of literature, often exploring technology and failures of human interaction with it, especially resulting in catastrophes with biotechnology. Many of his future history novels have medical or scientific underpinnings, reflecting his medical training and science background. He was the author of, among others, The Andromeda Strain, Jurassic Park, Congo, Travels, Sphere, Rising Sun, Disclosure, The Lost World, Airframe, Timeline, Prey, State of Fear, Next (the final book published before his death), Pirate Latitudes (published November 24, 2009), and a final unfinished techno-thriller, Micro, which was published in November 2011.", "1969 Edgar Award", "http://upload.wikimedia.org/wikipedia/commons/thumb/a/af/MichaelCrichton_2.jpg/220px-MichaelCrichton_2.jpg");
        _authorlist.add(_author);
        _author = new Author(2, "Stephen King", now, "American", "Stephen Edwin King is an American author of contemporary horror, suspense, science fiction and fantasy. His books have sold more than 350 million copies and many of them have been adapted into feature films, television movies and comic books. King has published fifty novels, including seven under the pen name Richard Bachman, and five non-fiction books. He has written nearly two hundred short stories, most of which have been collected in nine collections of short fiction. Many of his stories are set in his home state of Maine.", "Medal for Distinguished Contribution to American Letters, Hugo Award, Bram Stoker Award, World Fantasy Award", "http://upload.wikimedia.org/wikipedia/commons/thumb/e/e3/Stephen_King%2C_Comicon.jpg/220px-Stephen_King%2C_Comicon.jpg");
        _authorlist.add(_author);
        _author = new Author(3, "Joseph Heller", now, "American", "Joseph Heller was an American satirical novelist, short story writer, and playwright. The title of one of his works, Catch-22, entered the English lexicon to refer to a vicious circle wherein an absurd, no-win choice, particularly in situations in which the desired outcome of the choice is an impossibility, and regardless of choice, a same negative outcome is a certainty. Although he is remembered primarily for Catch-22, his other works center on the lives of various members of the middle class and remain examples of modern satire.", null, "http://upload.wikimedia.org/wikipedia/commons/thumb/7/78/Joseph_heller_1986.jpg/220px-Joseph_heller_1986.jpg");
        _authorlist.add(_author);
        _author = new Author(4, "Justin Cronin", now, "American", "Justin Cronin is an American author. He has written four novels: Mary and O''Neil and The Summer Guest, as well as two of three books of a vampire trilogy: The Passage and The Twelve. Born and raised in New England, Cronin is a graduate of Harvard University and the Iowa Writers'' Workshop. He taught creative writing and was the \"Author in-residence\" at La Salle University in Philadelphia, PA from 1992 to 2003. He lives with his wife and children in Houston, Texas, where he is a former professor of English at Rice University.", "Hemingway Foundation/PEN Award, Stephen Crane Prize, Whiting Writer's Award", "http://upload.wikimedia.org/wikipedia/commons/thumb/8/81/Justin_cronin_2012.jpg/220px-Justin_cronin_2012.jpg");
        _authorlist.add(_author);
        _author = new Author(5, "Hugh Howey", now, "American", "Hugh Howey is an American author, known for his popular series Wool, which he independently published through Amazon.com''s Kindle Direct Publishing system. Howey was raised in Monroe, North Carolina and prior to publishing his books, he worked as a yacht captain, roofer, and audio technician.", null, "http://upload.wikimedia.org/wikipedia/commons/thumb/1/16/Hugh_Howey_2013.jpg/220px-Hugh_Howey_2013.jpg");
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
