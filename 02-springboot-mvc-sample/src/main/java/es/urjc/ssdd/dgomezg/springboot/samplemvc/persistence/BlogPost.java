package es.urjc.ssdd.dgomezg.springboot.samplemvc.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class BlogPost {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String author;
    private String title;
    private String content;
    private LocalDateTime publishDate;

    public BlogPost() {
    }

    public BlogPost(String author, String title, String content) {
        this(author, title, content, LocalDateTime.now());
    }

    public BlogPost(String author, String title, String content, LocalDateTime publishDate) {
        this.author = author;
        this.title = title;
        this.content = content;
        this.publishDate = publishDate;
    }

}
