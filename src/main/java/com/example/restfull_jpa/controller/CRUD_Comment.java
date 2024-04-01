package com.example.restfull_jpa.controller;

import com.example.restfull_jpa.service.ServiceComment;
import com.example.restfull_jpa.entity.commentDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CRUD_Comment {
    private final ServiceComment commentService;

    public CRUD_Comment(ServiceComment commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/{announceId}")
    public ResponseEntity<List<commentDTO>> getCommentsByAnnounceId(@PathVariable Long announceId) {
        List<commentDTO> comments = commentService.getCommentsByAnnounceId(announceId);
        return ResponseEntity.ok(comments);
    }

    @PostMapping("/{announceId}")
    public ResponseEntity<commentDTO> addCommentToAnnounce(@PathVariable Long announceId, @RequestBody commentDTO comment_DTO) {
        commentDTO savedComment = commentService.addCommentToAnnounce(announceId, comment_DTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedComment);
    }

    @PutMapping("/{announceId}/comments/{commentId}")
    public ResponseEntity<commentDTO> updateComment(@PathVariable Long announceId, @PathVariable Long commentId, @RequestBody commentDTO commentDTO) {
        commentDTO updatedComment = commentService.updateComment(announceId, commentId, commentDTO);
        if (updatedComment != null) {
            return ResponseEntity.ok(updatedComment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{announceId}/comments/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long announceId, @PathVariable Long commentId) {
        commentService.deleteComment(announceId, commentId);
        return ResponseEntity.noContent().build();
    }
}
