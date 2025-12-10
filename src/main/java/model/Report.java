package model;
import java.util.Map;

public class Report {
    private Map<String, Long> topIps;
    private Map<Integer, Long> statusCodes;
    private long userAgentHits;

    public Report(Map<String, Long> topIps, Map<Integer, Long> statusCodes, long userAgentHits) {
        this.topIps = topIps;
        this.statusCodes = statusCodes;
        this.userAgentHits = userAgentHits;
    }
}