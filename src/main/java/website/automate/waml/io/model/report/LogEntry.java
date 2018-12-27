package website.automate.waml.io.model.report;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import static java.text.MessageFormat.format;
import static java.util.EnumSet.of;

@JsonPropertyOrder(value = {"level", "time", "message"})
public class LogEntry {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public enum LogLevel {
        INFO, WARN, ERROR, DEBUG
    }

    public static Set<LogLevel> INFO_LEVELS = of(LogLevel.INFO, LogLevel.WARN, LogLevel.ERROR);

    public static Set<LogLevel> DEBUG_LEVELS =
            of(LogLevel.DEBUG, LogLevel.INFO, LogLevel.WARN, LogLevel.ERROR);

    public static Set<LogLevel> WARN_LEVELS = of(LogLevel.WARN, LogLevel.ERROR);

    public static Set<LogLevel> ERROR_LEVELS = of(LogLevel.ERROR);

    private final LogLevel level;

    private final Date time;

    private final String message;

    public LogEntry(LogLevel level, Date time, String message) {
        super();
        this.level = level;
        this.time = time;
        this.message = message;
    }

    @JsonCreator
    public LogEntry(@JsonProperty("level") String level, @JsonProperty("time") String time,
            @JsonProperty("message") String message) {
        this(LogLevel.valueOf(level), deserialize(time), message);
    }

    private static Date deserialize(String time) {
        try {
            return DATE_FORMAT.parse(time);
        } catch (ParseException e) {
            throw new IllegalArgumentException(format("Invalid date time {0} given.", time));
        }
    }

    private String serialize(Date time) {
        return DATE_FORMAT.format(time);
    }

    public LogLevel getLevel() {
        return level;
    }

    public Date getTime() {
        return time;
    }

    public static boolean isIncluded(LogLevel minimalLevel, LogLevel level) {
        switch (minimalLevel) {
            case DEBUG:
                return DEBUG_LEVELS.contains(level);
            case INFO:
                return INFO_LEVELS.contains(level);
            case WARN:
                return WARN_LEVELS.contains(level);
            default:
                return ERROR_LEVELS.contains(level);
        }
    }

    @JsonProperty("time")
    public String getTimeStr() {
        return serialize(time);
    }

    public String getMessage() {
        return message;
    }
}
