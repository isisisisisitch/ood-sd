package ca.bytetube.ood._14_alexa;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WeatherRule implements Rule {
    static final Pattern PATTERN = Pattern.compile("what(?:'s| is) the weather(?: like)? in (.+)", Pattern.CASE_INSENSITIVE);

    @Override
    public boolean matches(String input) {
        return PATTERN.matcher(input).matches();
    }

    public String extractLocation(String input) {
        Matcher matcher = PATTERN.matcher(input);
        if (matcher.find()) {
            return matcher.group(1).trim();
        }
        return null;
    }
}
