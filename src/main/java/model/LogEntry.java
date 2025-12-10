package model;

public class LogEntry {
    private String ip;
    private int statusCode;
    private String userAgent;

    public LogEntry(String ip, int statusCode, String userAgent) {
        this.ip = ip;
        this.statusCode = statusCode;
        this.userAgent = userAgent;
    }

    public String getIp() { return ip; }
    public int getStatusCode() { return statusCode; }
    public String getUserAgent() { return userAgent; }
}