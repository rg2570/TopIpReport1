import org.apache.commons.lang3.tuple.Pair;
import java.time.LocalDate;
import java.util.HashMap;

public interface PerDayTopIpFinder {
    HashMap<LocalDate, Pair<String, Integer>> findTopIpPerDay(HashMap<LocalDate, HashMap<String, Integer>> countedLog);
}
