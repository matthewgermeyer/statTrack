package com.trane.statTrack.config;

import com.trane.statTrack.fixture.Fixture;
import com.trane.statTrack.fixture.FixtureRepository;
import com.trane.statTrack.team.Team;
import com.trane.statTrack.review.Review;
import com.trane.statTrack.team.TeamRepository;
import com.trane.statTrack.user.User;
import com.trane.statTrack.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class DatabaseLoader implements ApplicationRunner {
  private final FixtureRepository fixtures;
  private final UserRepository users;
  private final TeamRepository teams;

  @Autowired
  public DatabaseLoader(FixtureRepository fixtures, UserRepository users, TeamRepository teams) {
    this.fixtures = fixtures;
    this.users = users;
    this.teams = teams;
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    Fixture fixture = new Fixture(teams.findByName("Spurs"),teams.findByName("Arsenal"));
    fixture.addReview(new Review(3, "You ARE a dork!!!"));
    fixtures.save(fixture);

    //TODO: Populate this with the other 18 PL teams.
    //TODO: Add badges to the teams.
    Team[] premTeams = {
        new Team(),
    };

    String[] buzzwords = {
        "A cracker!",
        "A classic!",
        "One for the Ages!",
        "Dull",
        "Drab",
        "Listless",
    };

    List<User> reviewers = Arrays.asList(
        new User("rHonigstein", "Raphael", "Honigstein", "password", new String[]{"ROLE_USER"}),
        new User("gMarcotti", "Gabriele", "Marcotti", "password", new String[]{"ROLE_USER"}),
        new User("tVickery", "Tim", "Vickery", "password", new String[]{"ROLE_USER"}),
        new User("gBalague", "Guillem", "Balague", "password", new String[]{"ROLE_USER"}),
        new User("sLowe", "Sid", "Lowe", "password", new String[]{"ROLE_USER"}),
        new User("jHorncastle", "James", "Horncastle", "password", new String[]{"ROLE_USER"}),
        new User("aBrassell", "Andy", "Brassell", "password", new String[]{"ROLE_USER"}),
        new User("pBandini", "Paolo", "Bandini", "password", new String[]{"ROLE_USER"})
    );
    users.save(reviewers);
    users.save(new User("mattyTrane", "Matt", "Germeyer", "password",
        new String[]{"ROLE_USER", "ROLE_ADMIN"}));

    List<Fixture> bunchOfFixtures = new ArrayList<>();
    IntStream.range(0, 100)
        .forEach(i -> {
          Team home = premTeams[i % premTeams.length];
          Team away = premTeams[i % premTeams.length];
          String buzzword = buzzwords[i % buzzwords.length];

          Fixture fix = new Fixture(home, away);
          Review review = new Review((i % 5) + 1, String
              .format("Moar %s please!!!", buzzword));
          review.setReviewer(reviewers.get(i % reviewers.size()));
          fix.addReview(review);
          bunchOfFixtures.add(fix);
        });
    fixtures.save(bunchOfFixtures);
  }
}
