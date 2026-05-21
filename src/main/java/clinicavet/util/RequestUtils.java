package clinicavet.util;

import jakarta.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

public final class RequestUtils {
    private RequestUtils() {
    }

    public static Long getLong(HttpServletRequest request, String parameter) {
        String value = request.getParameter(parameter);
        return value == null || value.isBlank() ? null : Long.valueOf(value);
    }

    public static BigDecimal getBigDecimal(HttpServletRequest request, String parameter) {
        String value = request.getParameter(parameter);
        return value == null || value.isBlank() ? null : new BigDecimal(value);
    }

    public static boolean getBoolean(HttpServletRequest request, String parameter) {
        return "on".equalsIgnoreCase(request.getParameter(parameter)) || "true".equalsIgnoreCase(request.getParameter(parameter));
    }
}
