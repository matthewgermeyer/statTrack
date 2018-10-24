package com.trane.statTrack.repository;

import com.trane.statTrack.model.Player;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PlayerRepository extends PagingAndSortingRepository<Player,Long> {
    Player findByName(String name);
}
