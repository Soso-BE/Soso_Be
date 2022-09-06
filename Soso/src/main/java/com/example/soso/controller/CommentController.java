package com.example.soso.controller;

import com.example.soso.domain.Comment;
import com.example.soso.domain.Member;
import com.example.soso.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
public class CommentController {
    @Autowired
    private final CommentService commentService;

    @PostMapping("/api/auth/comment/{id}")
    public String createComment(@ModelAttribute Comment comment, Long postId, @SessionAttribute(required = false)
    Member member){

        return commentService.createComment(comment, member, postId);

    }

    @PutMapping("/api/auth/comment/{id}")
    public String updateComment(@ModelAttribute Comment comment, Long postId, @SessionAttribute(required = false)
    Member member){

        return commentService.updateComment(comment, member, postId);

    }

    @DeleteMapping("/api/auth/comment/{id}")
    public String deleteComment(@ModelAttribute Comment comment, @SessionAttribute(required = false)
    Member member){


        return commentService.deleteComment(comment);
    }
}
