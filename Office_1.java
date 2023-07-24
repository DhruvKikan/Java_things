import javax.lang.model.type.NullType;
import com.google.gson.*;
import org.json.*;


public class Office_1 {

    public void f1(NullType nullType){
//        ObjectNode on = new ObjectNode();
//        ObjectMapper om = new ObjectMapper();
        JsonObject jo = new JsonObject(); // GSON (com.google.)
        JSONObject job = new JSONObject(); // JSON (org.json.)
        Gson gs = new Gson();
        JsonArray jsa = new JsonArray();
        GsonBuilder gb = new GsonBuilder();
        JsonParser jp;
    }

    // Mapper and gson and jsonnode and objectnode implementation and learn pojo
    public static void main(String[] args) {
        System.out.println("Wow");
    }
}
