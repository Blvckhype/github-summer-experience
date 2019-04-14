package pl.allegro.summer.experience.github.parser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataParser {

    private static final String GITHUB_DATA_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";

    public static Date parseDate(String date) throws ParseException {
        try {
            return new SimpleDateFormat(GITHUB_DATA_FORMAT).parse(date);
        } catch (ParseException e) {
            throw new ParseException(e.getMessage(), 0);
        }
    }
}
