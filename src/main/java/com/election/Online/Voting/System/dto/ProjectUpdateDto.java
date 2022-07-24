package com.election.Online.Voting.System.dto;

public class ProjectUpdateDto {
    private  Integer id;
    private String  pname;
    private String description;
    private Integer phr;
    private Integer tmembers;
    private Integer pamount;

    public ProjectUpdateDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
