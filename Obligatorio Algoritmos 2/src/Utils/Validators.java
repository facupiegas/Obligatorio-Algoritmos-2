package Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validators {

    private Pattern emailPattern;
    private Pattern ciPattern;
    private Matcher matcher;

    private static final String EMAIL_PATTERN
            = "^((\"[\\w-\\s]+\")|([\\w-]+(?:\\.[\\w-]+)*)|(\"[\\w-\\s]+\")"
            + "([\\w-]+(?:\\.[\\w-]+)*))(@((?:[\\w-]+\\.)*\\w[\\w-]{0,66})\\."
            + "([a-z]{2,6}(?:\\.[a-z]{2})?)$)|(@\\[?((25[0-5]\\.|2[0-4][0-9]\\"
            + ".|1[0-9]{2}\\.|[0-9]{1,2}\\.))"
            + "((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\\.)"
            + "{2}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\\]?$)";

    private static final String CI_PATTERN = "^[0-9]([.][0-9]{3}){2}[-][0-9]$";

    public Validators() {
        emailPattern = Pattern.compile(EMAIL_PATTERN);
        ciPattern = Pattern.compile(CI_PATTERN);

    }

    public boolean validateEmail(final String mail) {
        matcher = emailPattern.matcher(mail);
        return matcher.matches();
    }

    public boolean validateCi(final String ci) {
        matcher = ciPattern.matcher(ci);
        return matcher.matches();
    }
}
