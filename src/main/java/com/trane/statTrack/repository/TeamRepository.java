package com.trane.statTrack.repository;

import com.trane.statTrack.model.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Long> {
    Team findByName(String name);
}
