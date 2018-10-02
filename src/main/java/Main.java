import java.io.IOException;
import controller.GameRunner;
import controller.Prompter;
import model.Fixture;

public class Main {
  public static void main(String[] args) throws IOException {
    Prompter prompter = new Prompter();
    GameRunner runner = new GameRunner(Fixture.northLondonDerby());


  }
}
