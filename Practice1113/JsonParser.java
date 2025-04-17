import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class JsonParser {
    public static List<StationData> parse(File file) throws IOException {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(file)) {
            Type listType = new TypeToken<List<StationData>>(){}.getType();
            return gson.fromJson(reader, listType);
        }
    }
}