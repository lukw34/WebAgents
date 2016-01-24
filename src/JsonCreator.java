import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;

public class JsonCreator {

    private JsonArrayBuilder arrayBuilder;

    public JsonCreator() {
        arrayBuilder = Json.createArrayBuilder();
    }

    public void addElement(String title, String discount, String priceNew) {
        arrayBuilder.add(Json.createObjectBuilder().add("title", title)
                .add("priceNew", priceNew).add("discount", discount));
    }

    public String getJson() {
        return arrayBuilder.build().toString();
    }
}
