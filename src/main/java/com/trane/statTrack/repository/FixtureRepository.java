package com.trane.statTrack.repository;

import com.trane.statTrack.model.Fixture;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FixtureRepository extends PagingAndSortingRepository<Fixture, Long> {

//    @RestResource(rel = "title-contains", path = "containsTitle")
//    Page<Fixture> findByTitleContaining(@Param("title") String title, Pageable page);
//
//    @Override
//    @PreAuthorize("hasRole('ROLE_ADMIN') or @fixtureRepository.findOne(#id)?.reviewer?.username == authentication.name")
//    void delete(@Param("id") Long id);
//
//    @Override
//    @PreAuthorize("hasRole('ROLE_ADMIN') or #fixture.reviewer?.username == authentication.name")
//    void delete(@Param("fixture") Fixture entity);

} //class
