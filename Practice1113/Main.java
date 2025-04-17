import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            // Парсинг веб-данных
            List<Line> lines = WebParser.parseLines("https://metro.ru/stations");
            List<Station> stations = WebParser.parseStations("https://metro.ru/stations");

            // Поиск файлов
            List<File> jsonFiles = FileFinder.findFiles("data", List.of("json"));
            List<File> csvFiles = FileFinder.findFiles("data", List.of("csv"));

            // Парсинг данных из файлов
            List<StationData> allData = new ArrayList<>();
            for (File f : jsonFiles) {
                allData.addAll(JsonParser.parse(f));
            }
            for (File f : csvFiles) {
                allData.addAll(CsvParser.parse(f));
            }

            // Объединение данных
            Map<String, StationData> mergedData = mergeData(stations, allData);

            // Генерация JSON
            DataWriter.writeStationsJson(new ArrayList<>(mergedData.values()), "stations.json");
            
            Map<String, List<String>> lineStructure = buildLineStructure(lines, stations);
            DataWriter.writeMetroJson(lineStructure, "metro.json");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Map<String, StationData> mergeData(List<Station> stations, List<StationData> fileData) {
        Map<String, StationData> result = new HashMap<>();
        // Логика объединения данных
        return result;
    }

    private static Map<String, List<String>> buildLineStructure(List<Line> lines, List<Station> stations) {
        Map<String, List<String>> result = new HashMap<>();
        // Логика построения структуры линий
        return result;
    }
}