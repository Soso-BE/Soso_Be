package com.example.soso.domain;


import com.example.soso.controller.request.PostRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post extends Timestamped {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column
    private String imageUrl;

    @Column
    private String fileName;

    @Column
    private int likeNum;

    public Post(PostRequestDto postRequestDto) {
        this.title = postRequestDto.getTitle();
        this.imageUrl = postRequestDto.getImageUrl();
        this.fileName = postRequestDto.getFileName();
    }


    public void update(PostRequestDto postRequestDto) {
        this.title = postRequestDto.getTitle();
        this.imageUrl = postRequestDto.getImageUrl();
        this.fileName = postRequestDto.getFileName();
    }



    ////////////////////////////////////////////////////////////////
    //이부분부터 넣으면 됨
    //@ManyToOne 과 @OneToMany 로 양방향 관계
    //CascadeType.REMOVE로 게시글이 삭제되면 댓글도 삭제
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @OrderBy("id asc") // 댓글 정렬
    private List<Comment> comments;


    private Boolean isHeart = false;

    public void like(){
        this.likeNum +=1;
    }
    public void dislike(){
        this.likeNum -=1;
    }

}

