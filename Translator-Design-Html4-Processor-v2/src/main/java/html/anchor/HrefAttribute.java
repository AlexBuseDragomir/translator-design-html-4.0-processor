package html.anchor;

import html.HtmlAttribute;
import utility.StringUtility;
import utility.ValidationUtility;

public class HrefAttribute extends HtmlAttribute {

    public HrefAttribute() {
        setName("href");
    }

    public HrefAttribute(String value) {
        setName("href");
        setValue(value);
    }

    @Override
    public boolean isSyntacticallyValid() {
        String value = StringUtility.removeDoubleQuotes(getValue());

        return ValidationUtility.isHttpUrlValid(value) ||
                ValidationUtility.isFilePathUrlValid(value);
    }
}
