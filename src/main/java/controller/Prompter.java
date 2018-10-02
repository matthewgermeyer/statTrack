package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import model.Fixture;
import model.Team;

public class Prompter {
  private BufferedReader reader;

  public Prompter() {
    this.reader = new BufferedReader(new InputStreamReader(System.in));
  }

//  public Fixture buildFixture() throws IOException {
//    System.out.print("Let's start by adding a fixture. %n Are spurs at home? Y/N");
//    String response = reader.readLine().toLowerCase();
//    boolean home = response.equals("y");
//    System.out.print("Who are Spurs playing?");
//    String opponent = reader.readLine();
//    System.out.printf("%n%nOk lets confirm: %n Home: %s%n Opponent: %s%n", home, opponent);
//    List<Team> teams = Arrays.asList(
//        new Team("Spurs"), new Team(opponent));
//    if (home) {
//      Fixture homeFixture = new Fixture("Spurs", opponent, teams);
//      homeFixture.setVenue("White Hart Lane");
//      return homeFixture;
//    }
//    Fixture awayFixture = new Fixture(opponent, "Spurs", teams);
//    return awayFixture;
//  }

//  public Fixture buildTestFixture() {
//    List<Team> teams = Arrays.asList(
//        Team.generateSpursTeam(),
//        Team.generateArsenalTeam()
//    );
//    Fixture testFixture = new Fixture(
//        teams.get(0).getTeamName(),
//        teams.get(1).getTeamName(),
//        teams);
//    return testFixture;
//  }

  public Fixture fullTestSpursArsenal() {
    List<Team> teams = Arrays.asList(
        Team.generateSpursTeam(),
        Team.generateArsenalTeam()
    );
    Fixture testFixture = new Fixture(Team.generateSpursTeam(),Team.generateArsenalTeam());
    return testFixture;
  }
}//class

