import com.jaunt.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class WebAgent {

    public static void main(String[] args) {

        try{
            UserAgent userAgent = new UserAgent();
            userAgent.visit("http://lowcygier.pl/sledzokazje/?Price_sort=change");
            userAgent.doc.findEach("<tr class=").forEach(game -> {
                System.out.println(game);
                game.getChildNodes().forEach(System.out::print);
            });


        }
        catch(JauntException e){
            System.err.println(e);
        }
    }
}
