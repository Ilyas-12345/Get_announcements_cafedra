package com.example.restfull_jpa.service;

import com.example.restfull_jpa.entity.AnnounceDTO;
import com.example.restfull_jpa.repository.AnnounceRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceAnnounce {
    private final AnnounceRepository announceRepository;
    @PersistenceContext
    private EntityManager entityManager;

    public ServiceAnnounce(AnnounceRepository announceRepository) {
        this.announceRepository = announceRepository;
    }

    public AnnounceDTO getAnnounceById(Long id) {
        return announceRepository.findById(id).orElse(null);
    }

    public List<AnnounceDTO> getAllAnnounces() {
        return announceRepository.findAll();
    }

    public AnnounceDTO createAnnounce(AnnounceDTO announceDTO) {
        return announceRepository.save(announceDTO);
    }

    public AnnounceDTO updateAnnounce(Long id, AnnounceDTO announceDTO) {
        if (announceRepository.existsById(id)) {
            announceDTO.setId(id);
            return announceRepository.save(announceDTO);
        } else {
            return null;
        }
    }

    public boolean deleteAnnounce(Long id) {
        if (announceRepository.existsById(id)) {
            announceRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public List<AnnounceDTO> getUsefulAnnouncements(String param1, String param2) {
        Query query = entityManager.createQuery("SELECT a FROM AnnounceDTO a WHERE a.param1 = :param1 AND a.param2 = :param2");
        query.setParameter("param1", param1);
        query.setParameter("param2", param2);
        return query.getResultList();
    }
}
