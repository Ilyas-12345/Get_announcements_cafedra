package com.example.restfull_jpa.service;

import com.example.restfull_jpa.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.restfull_jpa.entity.commentDTO;

import java.util.List;

@Service
public class ServiceComment {
    private final CommentRepository commentRepository;

    @Autowired
    public ServiceComment(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<commentDTO> getCommentsByAnnounceId(Long announceId) {
        return commentRepository.findByAnnounceDTO_Id(announceId);
    }

    public commentDTO addCommentToAnnounce(Long announceId, commentDTO commentDTO) {
        // Set announceId to the commentDTO before saving it
        commentDTO.setAnnounce_id(announceId);
        return commentRepository.save(commentDTO);
    }

    public commentDTO updateComment(Long announceId, Long commentId, commentDTO commentDTO) {
        if (commentRepository.existsById(commentId)) {
            // Set announceId to the commentDTO before updating it
            commentDTO.setAnnounce_id(announceId);
            commentDTO.setId(commentId);
            return commentRepository.save(commentDTO);
        } else {
            return null;
        }
    }

    public void deleteComment(Long announceId, Long commentId) {
        commentRepository.deleteByIdAndAnnounceDTO_Id(commentId, announceId);
    }
}

