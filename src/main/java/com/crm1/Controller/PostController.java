package com.crm1.Controller;

import com.crm1.Entity.Post;
import com.crm1.Repositry.CommentRepository;
import com.crm1.Repositry.PostRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    private PostRepository postRepository;
    private CommentRepository commentRep;

    public PostController(PostRepository postRepository, CommentRepository commentRep) {
        this.postRepository = postRepository;
        this.commentRep = commentRep;
    }

    @PostMapping
    public String createPost(
            @RequestBody Post post
    ){

        postRepository.save(post);
        return "saved";
    }

    @DeleteMapping
    public void deletePost(){
        postRepository.deleteById(1L);
    }
}
