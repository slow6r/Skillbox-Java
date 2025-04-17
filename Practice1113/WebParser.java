import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebParser {
    public static List<Line> parseLines(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        List<Line> lines = new ArrayList<>();
        
        Elements lineElements = doc.select("div.line-data"); // Пример селектора
        for (Element el : lineElements) {
            Line line = new Line();
            line.setNumber(el.attr("data-line"));
            line.setName(el.select(".line-name").text());
            lines.add(line);
        }
        return lines;
    }

    public static List<Station> parseStations(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        List<Station> stations = new ArrayList<>();
        
        Elements stationElements = doc.select("div.station"); // Пример селектора
        for (Element el : stationElements) {
            Station station = new Station();
            station.setName(el.select(".station-name").text());
            station.setLineNumber(el.parent().attr("data-line"));
            stations.add(station);
        }
        return stations;
    }
}