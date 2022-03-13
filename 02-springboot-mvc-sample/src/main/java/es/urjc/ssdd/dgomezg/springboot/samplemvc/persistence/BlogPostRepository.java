package es.urjc.ssdd.dgomezg.springboot.samplemvc.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {

    List<BlogPost> findByAuthor(String author);

    List<BlogPost> findByTitle(String title);

    //DONE 1 : Add convenient methods to get the post list ordered by :
    //       -  author,
    List<BlogPost> findAllByOrderByAuthor();

    //DONE 2: - author and title
    List<BlogPost> findAllByOrderByAuthorAscTitleAsc();

    //DONE 3: - Descending publishDate
    List<BlogPost> findAllByOrderByPublishDateDesc();


}
