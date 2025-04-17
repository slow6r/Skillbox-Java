import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvParser {
    public static List<StationData> parse(File file) throws IOException {
        List<StationData> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            br.readLine(); // Пропуск заголовка
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                StationData sd = new StationData();
                sd.setName(values[0]);
                sd.setLine(values[1]);
                // Заполнение остальных полей
                data.add(sd);
            }
        }
        return data;
    }
}