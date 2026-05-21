package clinicavet.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class DateUtils {
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

    private DateUtils() {
    }

    public static LocalDate parseDate(String value) {
        return value == null || value.isBlank() ? null : LocalDate.parse(value, DATE_FORMAT);
    }

    public static LocalDateTime parseDateTime(String value) {
        return value == null || value.isBlank() ? null : LocalDateTime.parse(value, DATE_TIME_FORMAT);
    }

    public static String formatDate(LocalDate value) {
        return value == null ? "" : value.format(DATE_FORMAT);
    }

    public static String formatDateTime(LocalDateTime value) {
        return value == null ? "" : value.format(DATE_TIME_FORMAT);
    }
}
