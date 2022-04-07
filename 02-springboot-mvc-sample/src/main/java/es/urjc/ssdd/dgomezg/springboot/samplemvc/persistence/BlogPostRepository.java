package es.urjc.ssdd.dgomezg.springboot.samplemvc.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {

    List<BlogPost> findByAuthor(String author);

    List<BlogPost> findByTitle(String title);

    List<BlogPost> findByAuthorAndTag(String author, String tag);
}
