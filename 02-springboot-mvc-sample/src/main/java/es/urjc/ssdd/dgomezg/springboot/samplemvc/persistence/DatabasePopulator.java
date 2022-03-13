package es.urjc.ssdd.dgomezg.springboot.samplemvc.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
@Profile("local")
public class DatabasePopulator {

    @Autowired
    private BlogPostRepository repository;

    @PostConstruct
    public void populateDB() {

        repository.saveAll(
                Arrays.asList(
                     new BlogPost("dgomezg", "My first Blog Post", "Lorem ipsum ..."),
                        new BlogPost("dgomezg", "My second blog post", "Nam hendrerit aliquet pharetra..."),
                        new BlogPost("dgomezg", "My third blog post", "Duis ut ultricies urna, ..."),
                        new BlogPost("dgomezg", "My fourth blog post", "Etiam sit amet nulla fringilla, ..."),
                        new BlogPost("dgomezg", "My last blog post today", "Duis feugiat, ...")
                )
        );
    }
}
