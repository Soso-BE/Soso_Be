package com.example.soso.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "comments")
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String nickname;

    @Column(name = "created_date")
    @CreatedDate
    private String createdDate;

    @Column(name = "modified_date")
    @CreatedDate
    private String modifiedDate;
    @ManyToOne
    @JoinColumn(name = "postId")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "memberId")
    private Member member;


    public Comment toEntity() {
        Comment comments = Comment.builder()
                .id(id)
                .content(content)
                .createdDate(createdDate)
                .modifiedDate(modifiedDate)
                .member(member)
                .post(post)
                .build();
        return comments;
    }

    public void CommentResponse(Comment comment) {
        this.id = comment.getId();
        this.content = comment.getContent();
        this.createdDate = comment.getCreatedDate();
        this.modifiedDate = comment.getModifiedDate();
        this.nickname = comment.getMember().getNickname();
        this.postId = comment.getPost().getId();
    }
}
