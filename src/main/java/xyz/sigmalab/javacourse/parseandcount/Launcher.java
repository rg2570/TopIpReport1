package xyz.sigmalab.javacourse.parseandcount;

import org.apache.commons.lang3.tuple.Pair;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Launcher {

    public static void main(String[] args) throws IOException {

        LogParser logParser = new LogParserImplV1ForOurSelf();
        IpCounter ipCounter = new IpCounterImpl();
        PerDayTopIpFinder topIpFinder = new PerDayTopIpFinderImpl();

        File file = Paths.get("./sample-data/ips.txt").toFile();
        HashMap<LocalDate, Pair<String, Integer>> result =
                topIpFinder.findTopIpPerDay(ipCounter.countIp(logParser.parseFile(file)));

        for(Map.Entry<LocalDate, Pair<String, Integer>> i: result.entrySet())
            System.out.println(i);
    }
}
