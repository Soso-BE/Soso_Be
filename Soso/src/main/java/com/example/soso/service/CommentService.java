package com.example.soso.service;

import com.example.soso.domain.Comment;
import com.example.soso.domain.Member;
import com.example.soso.domain.Post;
import com.example.soso.repository.CommentRepository;
import com.example.soso.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CommentService {

    @Autowired
    private final CommentRepository commentRepository;

    @Autowired
    private final PostRepository postRepository;

    @Autowired
    private final MemberRepository memberRepository;

    public String createComment(Comment comment, Member member, Long boardId){

        Member findMember = memberRepository.findById(member.getMemberId());
        Optional<Post> findBoard = postRepository.findById(boardId);

        comment.setPost(findPost.get());
        comment.setPost(findMember);
        commentRepository.save(comment);

        return "home";
    }

    public String updateComment(Comment comment, Member member, Long boardId){

        Member findMember = memberRepository.findById(member.getMemberId());
        Optional<Post> findBoard = postRepository.findById(boardId);

        comment.setPost(findPost.get());
        comment.setPost(findMember);
        commentRepository.save(comment);

        return "home";
    }

    public String deleteComment(Comment comment){

        commentRepository.delete(comment);

        return "home";
    }

}
