package com.example.soso.controller;




import com.example.soso.controller.response.ResponseDto;
import com.example.soso.domain.UserDetailsImpl;
import com.example.soso.service.HeartService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class HeartController {

    private final HeartService heartService;


//    @PostMapping("/api/auth/like/{id}")
//    public ResponseDto<?> postLike(@PathVariable Long id, HttpServletRequest request) {
//        return heartService.postLike(id,request);
//    }

//    @DeleteMapping("/api/auth/like/{id}")
//    public ResponseDto<?> postDisLike(@PathVariable Long id, HttpServletRequest request) {
//        return heartService.postDisLike(id,request);
//    }

    //
    @PostMapping("/api/auth/like/{id}")
    public ResponseDto<?> postLike(@PathVariable Long id,
                                   @PathVariable Long memberId,
                                   @AuthenticationPrincipal UserDetailsImpl details) {
        return heartService.postLike(id,memberId,details);
    }


}