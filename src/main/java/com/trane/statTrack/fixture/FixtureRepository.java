package com.trane.statTrack.fixture;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.prepost.PreAuthorize;

public interface FixtureRepository extends PagingAndSortingRepository<Fixture, Long> {

    @RestResource(rel = "title-contains", path = "containsTitle")
    Page<Fixture> findByTitleContaining(@Param("title") String title, Pageable page);

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN') or @fixtureRepository.findOne(#id)?.reviewer?.username == authentication.name")
    void delete(@Param("id") Long id);

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN') or #fixture.reviewer?.username == authentication.name")
    void delete(@Param("fixture") Fixture entity);

} //class
