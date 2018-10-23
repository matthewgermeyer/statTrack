package com.trane.statTrack.player;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface PlayerRepository extends PagingAndSortingRepository<Player,Long> {
    Player findByName(String name);
}
