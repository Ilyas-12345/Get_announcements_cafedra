package com.example.jpa_announce.service;

import com.example.jpa_announce.component.Cach;
import com.example.jpa_announce.entity.Announce;
import com.example.jpa_announce.exception.AnnounceNotFoundEx;
import com.example.jpa_announce.repository.AnnounceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnounceService {
    @Autowired
    private AnnounceRepository announceRepository;
    private Cach cache;

    public Announce createAnnounce(Announce announce){
        return announceRepository.save(announce);
    }

    public com.example.jpa_announce.model.Announce getAnnounce(Long id) {
        Announce announce = announceRepository.findById(id).get();
        return com.example.jpa_announce.model.Announce.toModel(announce);
    }

    public Long delete(Long id){
        announceRepository.deleteById(id);
        return id;
    }

    /*public List<Announce> getAnnouncesByStudent(Long departmentId) {
        String cacheKey = "announces_" + departmentId;

        // Проверяем, есть ли результаты запроса в кэше
        Object cachedObject = cache.get(cacheKey);
        if (cachedObject instanceof List<?>) {
            return (List<Announce>) cachedObject;
        }

        // Если результаты не найдены в кэше, выполняем запрос к базе данных
        List<Announce> announces = announceRepository.findByStudentDepartmentId(departmentId);

        // Помещаем результаты запроса в кэш
        cache.put(cacheKey, announces);

        return announces;
    }*/
}
