package com.election.Online.Voting.System.repository;

import com.election.Online.Voting.System.model.ResourceFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //integer is primary key data type of ResourceFile
public interface ResourceFileRepository extends JpaRepository<ResourceFile,Integer> {
}
