package es.urjc.ssdd.dgomezg.springboot.samplemvc;

import es.urjc.ssdd.dgomezg.springboot.samplemvc.persistence.BlogPost;
import es.urjc.ssdd.dgomezg.springboot.samplemvc.persistence.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BlogPostController {

    @Autowired
    private BlogPostRepository repository;

    @GetMapping("blog")
    public String list(Model model) {
        List<BlogPost> blogPosts = repository.findAll();
        model.addAttribute("blogPosts", blogPosts);
        return "blog/index";
    }
}
