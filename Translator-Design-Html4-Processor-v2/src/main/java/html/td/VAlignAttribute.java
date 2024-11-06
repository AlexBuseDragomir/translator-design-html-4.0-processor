package html.td;

import html.HtmlAttribute;
import utility.StringUtility;
import utility.ValidationUtility;

public class VAlignAttribute extends HtmlAttribute {

    public VAlignAttribute() {
        setName("valign");
    }

    public VAlignAttribute(String value) {
        setName("valign");
        setValue(value);
    }

    @Override
    public boolean isSyntacticallyValid() {
        String value = StringUtility.removeDoubleQuotes(getValue());
        return ValidationUtility.isVerticalAlignValid(value);
    }
}
