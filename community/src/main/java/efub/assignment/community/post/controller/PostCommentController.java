package efub.assignment.community.post.controller;


import efub.assignment.community.comment.dto.request.CommentRequest;
import efub.assignment.community.comment.service.CommentService;
import efub.assignment.community.post.dto.response.PostCommentResponse;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts/{postId}/comments")
public class PostCommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<Void> createComment(@PathVariable("postId") Long postId,
                                              @RequestBody CommentRequest request){
        Long id = commentService.createComment(postId, request);
        return ResponseEntity.created(URI.create("/posts/"+postId+"/comments"+id)).build();
    }

    @GetMapping
    public ResponseEntity<PostCommentResponse> getComments(@PathVariable("postId") Long postId){
        return ResponseEntity.ok(commentService.getPostCommentList(postId));
    }

}
