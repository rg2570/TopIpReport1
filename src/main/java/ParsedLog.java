import java.time.LocalDate;
import java.util.Objects;

public class ParsedLog {
    private final LocalDate timeStamp;
    private final String ipAddress;

    public ParsedLog(LocalDate timeStamp, String ipAddress) {
        this.timeStamp = timeStamp;
        this.ipAddress = ipAddress;
    }

    public LocalDate getTimeStamp() {
        return timeStamp;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParsedLog log = (ParsedLog) o;
        return timeStamp.equals(log.timeStamp) &&
                ipAddress.equals(log.ipAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeStamp, ipAddress);
    }

    @Override
    public String toString() {
        return "Log{" +
                "timeStamp=" + timeStamp +
                ", ipAddress='" + ipAddress + '\'' +
                '}';
    }
}
