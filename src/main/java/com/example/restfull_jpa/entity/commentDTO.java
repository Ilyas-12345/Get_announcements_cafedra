package com.example.restfull_jpa.entity;

import com.example.restfull_jpa.entity.AnnounceDTO;
import jakarta.persistence.*;

@Entity
public class commentDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    @Column(name = "announce_id", insertable = false, updatable = false)
    private Long announce_id;
    @ManyToOne
    @JoinColumn(name= "announce_id")
    private AnnounceDTO announceDTO;

    public commentDTO(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public AnnounceDTO getAnnounceDTO() {
        return announceDTO;
    }

    public void setAnnounceDTO(AnnounceDTO announceDTO) {
        this.announceDTO = announceDTO;
    }


    public Long getAnnounce_id() {
        return announce_id;
    }

    public void setAnnounce_id(Long announce_id) {
        this.announce_id = announce_id;
    }
}
