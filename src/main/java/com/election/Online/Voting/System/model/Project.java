package com.election.Online.Voting.System.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")

public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    private String pname;
    private String description;
    private Integer phr;
    private Integer tmembers;
    private Integer pamount;

    public  Project(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPhr() {
        return phr;
    }

    public void setPhr(Integer phr) {
        this.phr = phr;
    }

    public Integer getTmembers() {
        return tmembers;
    }

    public void setTmembers(Integer tmembers) {
        this.tmembers = tmembers;
    }

    public Integer getPamount() {
        return pamount;
    }

    public void setPamount(Integer pamount) {
        this.pamount = pamount;
    }
}
