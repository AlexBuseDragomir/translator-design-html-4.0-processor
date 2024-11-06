package html.body;

import html.HtmlAttribute;
import utility.StringUtility;
import utility.ValidationUtility;

public class BackgroundAttribute extends HtmlAttribute {

    public BackgroundAttribute() {
        setName("background");
    }

    public BackgroundAttribute(String value) {
        setName("background");
        setValue(value);
    }

    @Override
    public boolean isSyntacticallyValid() {
        String value = StringUtility.removeDoubleQuotes(getValue());

        return ValidationUtility.isHttpUrlValid(getValue()) ||
               ValidationUtility.isFilePathUrlValid(value);
    }
}
