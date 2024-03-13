    package com.example.jpa_announce.entity;

    import jakarta.persistence.*;

    import java.util.List;

    @Entity
    @Table(name = "announce")
    public class Announce {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private int cafedra_id;
        private String employee;
        private String date;
        @OneToMany(cascade = CascadeType.ALL, mappedBy = "group",fetch = FetchType.EAGER)
        private List<StudentGroup> studentGroup;

        public Announce() {
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public int getCafedra_id() {
            return cafedra_id;
        }

        public void setCafedra_id(int cafedra_id) {
            this.cafedra_id = cafedra_id;
        }

        public String getEmployee() {
            return employee;
        }

        public void setEmployee(String employee) {
            this.employee = employee;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public List<StudentGroup> getStudentGroup() {
            return studentGroup;
        }

        public void setStudentGroup(List<StudentGroup> studentGroup) {
            this.studentGroup = studentGroup;
        }
    }
