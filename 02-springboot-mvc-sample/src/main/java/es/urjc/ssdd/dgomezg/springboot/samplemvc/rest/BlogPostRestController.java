package es.urjc.ssdd.dgomezg.springboot.samplemvc.rest;

import es.urjc.ssdd.dgomezg.springboot.samplemvc.persistence.BlogPost;
import es.urjc.ssdd.dgomezg.springboot.samplemvc.persistence.BlogPostRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;

@RestController
public class BlogPostRestController {

    @Autowired
    private BlogPostRepository repository;

    @GetMapping("/api/blog")
    public Collection<BlogPost> findAll() {
        return repository.findAll();
    }

    @GetMapping("/api/blog/post/{postId}")
    public ResponseEntity view(@PathVariable Long postId){
        Optional<BlogPost> post = repository.findById(postId);

        return post
                .map(p -> ResponseEntity.ok(p))
                .orElseGet(() ->ResponseEntity.notFound().build());

        /**
        if(post.isPresent()) {
            return ResponseEntity.ok(post);
        } else {
            return ResponseEntity.notFound().build();
        }
         **/
    }

}
