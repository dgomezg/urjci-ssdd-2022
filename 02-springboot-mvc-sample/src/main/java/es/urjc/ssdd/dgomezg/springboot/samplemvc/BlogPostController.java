package es.urjc.ssdd.dgomezg.springboot.samplemvc;

import es.urjc.ssdd.dgomezg.springboot.samplemvc.persistence.BlogPost;
import es.urjc.ssdd.dgomezg.springboot.samplemvc.persistence.BlogPostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class BlogPostController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogPostController.class);

    @Autowired
    private BlogPostRepository repository;

    @GetMapping("/blog")
    public String list(Model model) {
        List<BlogPost> blogPosts = repository.findAll();
        model.addAttribute("blogPosts", blogPosts);
        return "blog/index";
    }

    @PostMapping("/blog/save-new-post")
    public ResponseEntity<Object> saveBlogPost(BlogPost blogPost) {
        LOGGER.trace("Received Blog post from {} with title {}", blogPost.getAuthor(), blogPost.getTitle());
        blogPost.setPublishDate(LocalDateTime.now());

        repository.save(blogPost);
        LOGGER.info("New Blog post {} from {} saved with id {}", blogPost.getTitle(), blogPost.getAuthor(), blogPost.getId());

        //return "redirect:/blog";
        return ResponseEntity.status(HttpStatus.FOUND)
                .header(HttpHeaders.LOCATION, "/blog/post/" + blogPost.getId())
                .build();
    }

    @GetMapping("/blog/post/{blogPostId}")
    public String view(Model model, @PathVariable Long blogPostId) {
        BlogPost blogPost = repository.getById(blogPostId);
        model.addAttribute("blogPost", blogPost);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String publishDateFormatted = blogPost.getPublishDate().format(dateTimeFormatter);
        model.addAttribute("publishDateFormatted", publishDateFormatted);

        return "blog/view-blog-post";
    }
}
