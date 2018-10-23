package com.trane.statTrack.fixture;

import com.trane.statTrack.config.BaseEntity;
import com.trane.statTrack.team.Team;
import com.trane.statTrack.review.Review;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Fixture extends BaseEntity {
    @NotNull
    private Team homeTeam;
    @NotNull
    private Team awayTeam;
    @NotNull
    @Size(min = 2, max = 140)
    private String venue;
    @NotNull
    @Size(min = 2, max = 140)
    private String date;
    private List<Review> reviews;

    //constructors

    protected Fixture() {
        super();
        reviews = new ArrayList<>();
    }

    public Fixture(Team homeTeam, Team awayTeam) {
        this();
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.venue = homeTeam.getHomeGround();
        LocalDateTime timeNow = LocalDateTime.now();
        LocalDate dateToday = timeNow.toLocalDate();
        System.out.println("dateToday: " + dateToday);
        this.date = dateToday.toString();
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void addReview(Review review) {
        review.setFixture(this);
        reviews.add(review);
    }

    //getters and setters

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    //overriden methods


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Fixture fixture = (Fixture) o;
        return Objects.equals(homeTeam, fixture.homeTeam) &&
            Objects.equals(awayTeam, fixture.awayTeam) &&
            Objects.equals(venue, fixture.venue) &&
            Objects.equals(date, fixture.date) &&
            Objects.equals(reviews, fixture.reviews);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeTeam, awayTeam, venue, date, reviews);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Fixture{");
        sb.append("homeTeam=").append(homeTeam);
        sb.append(", awayTeam=").append(awayTeam);
        sb.append(", venue='").append(venue).append('\'');
        sb.append(", date='").append(date).append('\'');
        sb.append(", reviews=").append(reviews);
        sb.append('}');
        return sb.toString();
    }
}
