package es.urjc.ssdd.dgomezg.springboot.samplemvc.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {

}
