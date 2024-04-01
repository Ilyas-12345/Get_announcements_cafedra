    package com.example.restfull_jpa.repository;

    import com.example.restfull_jpa.entity.commentDTO;
    import org.springframework.data.jpa.repository.JpaRepository;

    import java.util.List;

    public interface CommentRepository extends JpaRepository<commentDTO,Long> {
        List<commentDTO> findByAnnounceDTO_Id(Long announceDTOId); // Используйте правильное имя свойства (announceDTO)
        void deleteByIdAndAnnounceDTO_Id(Long id, Long announceDTOId);
    }
