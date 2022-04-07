package es.urjc.ssdd.dgomezg.springboot.samplemvc.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class BlogPost {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String author;
    private String title;
    private String content;
    private String tag;
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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getPublishDate() {
        return publishDate;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPublishDate(LocalDateTime publishDate) {
        this.publishDate = publishDate;
    }

    public String getFormattedPublishedDate() {
        return publishDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }

    @Override
    public String toString() {
        return "BlogPost{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", publishDate=" + publishDate +
                '}';
    }
}
