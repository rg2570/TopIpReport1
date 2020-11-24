import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LogParserImpl implements LogParser {

    @Override
    public List<ParsedLog> parseFile(File file) throws IOException
    {
        Path path = Paths.get("./" , "serverlog");
        List<String> logFileLines = Files.readAllLines(path);
        List<ParsedLog> dateAndIp = new List<ParsedLog>()
        {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<ParsedLog> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] ts) {
                return null;
            }

            @Override
            public boolean add(ParsedLog log) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends ParsedLog> collection) {
                return false;
            }

            @Override
            public boolean addAll(int i, Collection<? extends ParsedLog> collection) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> collection) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public ParsedLog get(int i) {
                return null;
            }

            @Override
            public ParsedLog set(int i, ParsedLog log) {
                return null;
            }

            @Override
            public void add(int i, ParsedLog log) {

            }

            @Override
            public ParsedLog remove(int i) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<ParsedLog> listIterator() {
                return null;
            }

            @Override
            public ListIterator<ParsedLog> listIterator(int i) {
                return null;
            }

            @Override
            public List<ParsedLog> subList(int i, int i1) {
                return null;
            }

        };

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
