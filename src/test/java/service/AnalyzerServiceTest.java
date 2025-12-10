package service;
import model.LogEntry;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AnalyzerServiceTest {
    @Test
    void testParser() {
        LogParser parser = new LogParser();
        String line = "192.168.1.1 - - [10/Nov/2023] \"GET / HTTP/1.1\" 200 1234 \"-\" \"Mozilla/5.0\"";
        LogEntry entry = parser.parse(line);
        assertNotNull(entry);
        assertEquals("192.168.1.1", entry.getIp());
    }
}