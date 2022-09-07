package com.example.soso.service;



import com.example.soso.controller.response.ResponseDto;
import com.example.soso.domain.Heart;
import com.example.soso.domain.Post;
import com.example.soso.domain.UserDetailsImpl;

import com.example.soso.repository.HeartRepository;
import com.example.soso.repository.MemberRepository;
import com.example.soso.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class HeartService {


    private final PostRepository postRepository;

    private final HeartRepository heartRepository;

    //좋아요를 등록합
    @Transactional
    public ResponseDto<?> postLike(Long postId, Long memberId, @AuthenticationPrincipal UserDetailsImpl details) {

        //게시글 아이디가 존재하고
        Post post = isPresentPost(postId);
        if (null == post) {
            return ResponseDto.fail("NOT_FOUND", "존재하지 않는 게시글 id 입니다.");
        }

        //맴버 아이디가 현재 요청 들어온 유저 디테일의 아이디랑 같을때
        if (heartRepository.findByMemberId(memberId).equals(details.getMember().getId())) {
            //현재 isLike가 true면 삭제하기
            Heart heart = null;
            if (heart.isLike.equals(true)) {
                heart.setIsLike(false);
                post.dislike();
                heartRepository.delete(heart);
                return ResponseDto.success("dislike success");
                //현재 isLike가 false면 등록하기
            } else {
                heart = Heart.builder()
                        .post(post)
                        .member(details.getMember())
                        .isLike(true)
                        .build();

                post.like();

                heartRepository.save(heart);

            }
        }
        return ResponseDto.success("like success");
    }

        @Transactional(readOnly = true)
        public Post isPresentPost (Long id){
            Optional<Post> optionalPost = postRepository.findById(id);
            return optionalPost.orElse(null);
        }


    }

