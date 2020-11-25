package xyz.sigmalab.javacourse.parseandcount;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public class IpCounterImpl implements IpCounter {

    @Override
    public HashMap<LocalDate, HashMap<String, Integer>> countIp(List<ParsedLog> logs) {
        HashMap<LocalDate, HashMap<String, Integer>> result = new HashMap<>();

        for (ParsedLog log : logs)
        {
            if(!result.containsKey(log.getTimeStamp()))
            {
                result.put(log.getTimeStamp(), new HashMap<String, Integer>());
            }
            if(!result.get(log.getTimeStamp()).containsKey(log.getIpAddress()))
            {
                result.get(log.getTimeStamp()).put(log.getIpAddress(), 0);
            }
            int newCount = result.get(log.getTimeStamp()).get(log.getIpAddress()) + 1;
            result.get(log.getTimeStamp()).put(log.getIpAddress(), newCount);
        }

        return result;
    }
}
