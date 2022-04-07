package es.urjc.ssdd.dgomezg.springboot.samplemvc;

import es.urjc.ssdd.dgomezg.springboot.samplemvc.persistence.BlogPost;
import es.urjc.ssdd.dgomezg.springboot.samplemvc.persistence.BlogPostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @GetMapping("/blog/author/{authorId}/date/{date}") //2022-03-17
    public String listByAuthor(Model model, @PathVariable String authorId, @PathVariable("topic") String tags){
        List<BlogPost> byAuthor = repository.findByAuthorAndTag(authorId, tags);
        model.addAttribute("blogPosts", byAuthor);
        return "blog/index";
    }

    @GetMapping("/blog-page")
    public String pagePosts(Model model, Pageable page) {
        Page<BlogPost> blogPostPage = repository.findAll(page);
        model.addAttribute("blogPosts", blogPostPage);
        LOGGER.trace("Returning Blog Post page : " + blogPostPage);
        return "blog/index";
    }


    @PostMapping("/blog/save-new-post")

    public String saveBlogPost(Model model, BlogPost blogPost) {


        LOGGER.trace("Received Blog post from {} with title {}", blogPost.getAuthor(), blogPost.getTitle());
        blogPost.setPublishDate(LocalDateTime.now());

        repository.save(blogPost);
        LOGGER.info("New Blog post {} from {} saved with id {}", blogPost.getTitle(), blogPost.getAuthor(), blogPost.getId());

        model.addAttribute("blogPost", blogPost);
        //return "blog/view-blog-post";

        return "redirect:/blog/post/"+ blogPost.getId();
        /*return ResponseEntity.status(HttpStatus.FOUND)
                .header(HttpHeaders.LOCATION, "/blog/post/" + blogPost.getId())
                .build();*/
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
