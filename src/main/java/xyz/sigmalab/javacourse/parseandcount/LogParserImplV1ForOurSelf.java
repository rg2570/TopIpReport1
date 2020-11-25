package xyz.sigmalab.javacourse.parseandcount;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;

public class LogParserImplV1ForOurSelf implements LogParser {

    @Override
    public List<ParsedLog> parseFile(File file) throws IOException
    {
        // Path path = Paths.get("./" , "serverlog");
        List<String> logFileLines = Files.readAllLines(file.toPath());
        List<ParsedLog> dateAndIp = new ArrayList<ParsedLog>();


        for (String line : logFileLines)
        {
            String[] splitted = line.split(" ");
            LocalDate timeStamp = LocalDate.parse(splitted[0]);
            String ipAddress = splitted[1];
            ParsedLog logs = new ParsedLog(timeStamp, ipAddress);
            dateAndIp.add(logs);
        }

        return dateAndIp;
    }
}
