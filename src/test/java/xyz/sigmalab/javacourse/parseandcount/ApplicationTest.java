package xyz.sigmalab.javacourse.parseandcount;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

public class ApplicationTest {

    @Test
    public void useLogParserToRead() throws IOException {
        LogParser parser = new LogParserImplV1ForOurSelf();

        List<ParsedLog> logs =
                parser.parseFile(Paths.get("sample-data/ips-01.txt").toFile());

        assertThat(logs).hasSize(3);
        logs.forEach(i -> System.out.println(i));
    }

    @Test
    public void countViaIpCounter() {

        IpCounter counter = new IpCounterImpl();
        DataSet01 dataset = new DataSet01();

        HashMap<LocalDate, HashMap<String, Integer>> result = counter.countIp(dataset.logs);

        assertThat(result)
                .hasSize(2)
                .containsOnlyKeys(dataset.today, dataset.yesterday);
        assertThat(result.get(dataset.today)).hasSize(2).containsOnlyKeys("1.1.1.1", "2.2.2.2");
        assertThat(result.get(dataset.today).get("1.1.1.1")).isEqualTo(2);
        assertThat(result.get(dataset.today).get("2.2.2.2")).isEqualTo(1);
        assertThat(result.get(dataset.yesterday)).hasSize(1).containsOnlyKeys("2.2.2.2");
        assertThat(result.get(dataset.yesterday).get("2.2.2.2")).isEqualTo(1);
    }

    @Test
    public void findPerDay() {
        PerDayTopIpFinder finder = new PerDayTopIpFinderImpl();

        DataSet01 dataset = new DataSet01();

        HashMap<LocalDate, HashMap<String, Integer>> counts =
                new IpCounterImpl().countIp(dataset.logs);

        HashMap<LocalDate, Pair<String, Integer>> result = finder.findTopIpPerDay(counts);

        assertThat(result).hasSize(2).containsOnlyKeys(dataset.today, dataset.yesterday);
        assertThat(result.get(dataset.today)).isEqualTo(Pair.of("1.1.1.1", 2));
        assertThat(result.get(dataset.yesterday)).isEqualTo(Pair.of("2.2.2.2", 1));
    }

    public static class DataSet01 {
        LocalDate today = LocalDate.from(Instant.now().atOffset(ZoneOffset.UTC));
        LocalDate yesterday = today.minusDays(1);
        ArrayList<ParsedLog> logs = new ArrayList<ParsedLog>() {{
            add(new ParsedLog(today, "1.1.1.1"));
            add(new ParsedLog(today, "1.1.1.1"));
            add(new ParsedLog(today, "2.2.2.2"));
            add(new ParsedLog(yesterday, "2.2.2.2"));
        }};
    }

}
