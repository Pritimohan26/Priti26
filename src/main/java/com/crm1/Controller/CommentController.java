package com.crm1.Controller;

import com.crm1.Entity.Comment;
import com.crm1.Entity.Post;
import com.crm1.Repositry.CommentRepository;
import com.crm1.Repositry.PostRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {

    private PostRepository postRepository;
    private CommentRepository commentRepository;

    public CommentController(PostRepository postRepository,CommentRepository commentRepository){
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    @PostMapping
    public String createComment(
            @RequestBody Comment comment ,
            @RequestParam long postId
    ){

        Post post = postRepository.findById(postId).get();
        comment.setPost(post);

        commentRepository.save(comment);

        return "Comment created successfully";
    }
}
