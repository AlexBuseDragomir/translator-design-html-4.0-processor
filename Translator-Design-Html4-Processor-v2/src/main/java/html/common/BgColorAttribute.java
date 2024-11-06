package html.common;

import html.HtmlAttribute;
import utility.StringUtility;
import utility.ValidationUtility;

public class BgColorAttribute extends HtmlAttribute {

    public BgColorAttribute() {
        setName("bgcolor");
    }

    public BgColorAttribute(String value) {
        setName("bgcolor");
        setValue(value);
    }

    @Override
    public boolean isSyntacticallyValid() {
        String value = StringUtility.removeDoubleQuotes(getValue());

        return ValidationUtility.isHexColorValid(value) ||
               ValidationUtility.isRgbColorValid(value) ||
               ValidationUtility.isColorNameValid(value);
    }
}
