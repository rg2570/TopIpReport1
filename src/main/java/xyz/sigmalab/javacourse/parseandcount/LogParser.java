package xyz.sigmalab.javacourse.parseandcount;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface LogParser {
    List<ParsedLog> parseFile(File file) throws IOException;
}
