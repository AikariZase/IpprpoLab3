package main;
import model.Report;
import service.AnalyzerService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        try {
            Properties props = new Properties();
            props.load(new FileInputStream("src/main/resources/app.properties"));
            
            AnalyzerService service = new AnalyzerService();
            Report report = service.analyze(
                props.getProperty("log.file.path"),
                Integer.parseInt(props.getProperty("report.top.ip.count")),
                props.getProperty("filter.user.agent")
            );

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println(gson.toJson(report));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}