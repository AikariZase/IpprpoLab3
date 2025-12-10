package service;
import model.LogEntry;
import model.Report;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.LinkedHashMap;

public class AnalyzerService {
    private final LogParser parser = new LogParser();

    public Report analyze(String filePath, int topIpCount, String targetAgent) throws IOException {
        List<LogEntry> entries = Files.lines(Path.of(filePath))
                .map(parser::parse)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        Map<String, Long> topIps = entries.stream()
                .collect(Collectors.groupingBy(LogEntry::getIp, Collectors.counting()))
                .entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(topIpCount)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        Map<Integer, Long> statuses = entries.stream()
                .collect(Collectors.groupingBy(LogEntry::getStatusCode, Collectors.counting()));

        long hits = entries.stream().filter(e -> e.getUserAgent().contains(targetAgent)).count();
        return new Report(topIps, statuses, hits);
    }
}