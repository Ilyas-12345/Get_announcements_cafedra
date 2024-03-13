package com.example.jpa_announce.service;

import com.example.jpa_announce.component.cach;
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
    @Autowired
    private cach cache;

    public Announce createAnnounce(Announce announce){
        return announceRepository.save(announce);
    }

    public com.example.jpa_announce.model.Announce getAnnounce(Long id) throws AnnounceNotFoundEx{
        Announce announce = announceRepository.findById(id).get();
        if(announce == null){
            throw new AnnounceNotFoundEx("Такого объявления нет!");
        }
        return com.example.jpa_announce.model.Announce.toModel(announce);
    }

    public Long delete(Long id){
        announceRepository.deleteById(id);
        return id;
    }

    public List<Announce> getAnnouncesByStudent(Long cafedra_id) {
        String cacheKey = "announces_" + cafedra_id;

        // Проверяем, есть ли результаты запроса в кэше
        if (cache.containsKey(cacheKey)) {
            return (List<Announce>) cache.get(cacheKey);
        }

        // Если результаты не найдены в кэше, выполняем запрос к базе данных
        List<Announce> announces = announceRepository.findByStudentcafedra_id(cafedra_id);

        // Помещаем результаты запроса в кэш
        cache.put(cacheKey, announces);

        return announces;
    }


}
