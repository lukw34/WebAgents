import com.jaunt.JauntException;
import com.jaunt.NotFound;
import com.jaunt.UserAgent;

public class LowcyGierAgent {
    private UserAgent userAgent;
    private JsonCreator creator;


    public LowcyGierAgent() throws JauntException {
        creator = new JsonCreator();
        userAgent = new UserAgent();
        userAgent.visit("http://lowcygier.pl/sledzokazje/?Price_sort=change");
    }

    public void findGame() {
        userAgent.doc.findEach("<tr class=").forEach(game -> {
            try {
                creator.addElement(
                        game.getFirst("<td class=\"table-product\">").innerText(),
                        game.getFirst("<td class=\"table-discount\">").innerText(),
                        game.getFirst("<td class=\"table-sourceprice\">").innerText());
            } catch (NotFound notFound) {
                notFound.printStackTrace();
            }
        });
    }

    public String getJson() {
        return creator.getJson();
    }

}
