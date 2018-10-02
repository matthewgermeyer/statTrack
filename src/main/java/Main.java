import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import controller.Tracker;
import model.Fixture;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
    Tracker tracker = new Tracker(Fixture.northLondonDerby());
    tracker.track();

  }




}
