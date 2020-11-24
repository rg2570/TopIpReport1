import java.time.LocalDate;
import java.util.Objects;

public class CountedIp {
    private final LocalDate timeStamp;
    private final String ipAddress;
    private final Integer ipCount;


    public CountedIp(LocalDate timeStamp, String ipAddress, Integer ipCount) {
        this.timeStamp = timeStamp;
        this.ipAddress = ipAddress;
        this.ipCount = ipCount;
    }

    public LocalDate getTimeStamp() {
        return timeStamp;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public Integer getIpCount() {
        return ipCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountedIp countedIp = (CountedIp) o;
        return timeStamp.equals(countedIp.timeStamp) &&
                ipAddress.equals(countedIp.ipAddress) &&
                ipCount.equals(countedIp.ipCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeStamp, ipAddress, ipCount);
    }

    @Override
    public String toString() {
        return "CountedIp{" +
                "timeStamp=" + timeStamp +
                ", ipAddress='" + ipAddress + '\'' +
                ", ipCount=" + ipCount +
                '}';
    }
}
