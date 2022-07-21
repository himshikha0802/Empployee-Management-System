package com.election.Online.Voting.System.dto;

public class RoleUpdateDto {
  private   int id;

  private   String name;

    public RoleUpdateDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
