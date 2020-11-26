package xyz.sigmalab.javacourse.parseandcount;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public interface IpCounter {
    HashMap<LocalDate, HashMap<String, Integer>> countIp(List<ParsedLog> logs);
}
