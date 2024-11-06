package html.table;

import html.HtmlAttribute;
import utility.StringUtility;
import utility.ValidationUtility;

public class BorderAttribute extends HtmlAttribute {

    public BorderAttribute() {
        setName("border");
    }

    public BorderAttribute(String value) {
        setName("border");
        setValue(value);
    }

    @Override
    public boolean isSyntacticallyValid() {
        String value = StringUtility.removeDoubleQuotes(getValue());
        return ValidationUtility.isBorderValid(value);
    }
}