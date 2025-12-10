package service;
import model.LogEntry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser {
    private static final Pattern LOG_PATTERN = Pattern.compile("^(\\S+) .*? \"[^\"]+\" (\\d{3}) .*? \"[^\"]*\" \"(.*?)\"$");

    public LogEntry parse(String line) {
        Matcher matcher = LOG_PATTERN.matcher(line);
        if (matcher.find()) {
            return new LogEntry(matcher.group(1), Integer.parseInt(matcher.group(2)), matcher.group(3));
        }
        return null;
    }
}