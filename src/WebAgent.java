import com.jaunt.JauntException;

public class WebAgent {

    public static void main(String[] args) {
        try {
            LowcyGierAgent agent = new LowcyGierAgent();
            agent.findGame();
            System.out.println(agent.getJson());
        } catch (JauntException e) {
            e.printStackTrace();
        }
    }
}
