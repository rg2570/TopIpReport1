package xyz.sigmalab.javacourse.parseandcount;

import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class PerDayTopIpFinderImpl implements PerDayTopIpFinder
{
    @Override
    public HashMap<LocalDate, Pair<String, Integer>> findTopIpPerDay(HashMap<LocalDate, HashMap<String, Integer>> countedLogs)
    {

        HashMap<LocalDate, Pair<String, Integer>> topIpPerDayResult = new HashMap<>();
        for (Map.Entry<LocalDate, HashMap<String, Integer>> countedLog : countedLogs.entrySet())
        {
            topIpPerDayResult.put(countedLog.getKey(), findTopIp(countedLog.getValue()));
        }

        return topIpPerDayResult;

    }

    public Pair<String, Integer> findTopIp(HashMap<String, Integer> ipCounts)
    {
        String topIp = null;
        Integer maxCount = 0;

        for(Map.Entry<String, Integer> ipCount : ipCounts.entrySet())
        {
            if (ipCount.getValue() > maxCount)
            {
                maxCount = ipCount.getValue();
                topIp = ipCount.getKey();
            }
        }
        Pair<String, Integer> listResult = new MutablePair<>(topIp, maxCount);
        return listResult;
    }

}
