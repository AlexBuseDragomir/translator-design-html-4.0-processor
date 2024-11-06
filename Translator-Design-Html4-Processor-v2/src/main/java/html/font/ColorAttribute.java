package html.font;

import html.HtmlAttribute;
import utility.StringUtility;
import utility.ValidationUtility;

public class ColorAttribute extends HtmlAttribute {

    public ColorAttribute() {
        setName("color");
    }

    public ColorAttribute(String value) {
        setName("color");
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
