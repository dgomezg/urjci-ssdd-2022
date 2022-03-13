package es.urjc.ssdd.dgomezg.springboot.samplemvc.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {

    List<BlogPost> findByAuthor(String author);

    List<BlogPost> findByTitle(String title);

    //TODO 1 : Add convenient methods to get the post list ordered by :
    //       -  user,

    //TODO 2: - User and title

    //TODO 3: - Descending publishDate


}
