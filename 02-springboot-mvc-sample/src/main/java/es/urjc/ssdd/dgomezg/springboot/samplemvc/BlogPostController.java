package es.urjc.ssdd.dgomezg.springboot.samplemvc;

import es.urjc.ssdd.dgomezg.springboot.samplemvc.persistence.BlogPost;
import es.urjc.ssdd.dgomezg.springboot.samplemvc.persistence.BlogPostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
    public String saveBlogPost(BlogPost blogPost) {
        LOGGER.trace("Received Blog post from {} with title {}", blogPost.getAuthor(), blogPost.getTitle());
        blogPost.setPublishDate(LocalDateTime.now());

        repository.save(blogPost);
        LOGGER.info("New Blog post {} from {} saved with id {}", blogPost.getTitle(), blogPost.getAuthor(), blogPost.getId());

        return "redirect:/blog";
    }
}
