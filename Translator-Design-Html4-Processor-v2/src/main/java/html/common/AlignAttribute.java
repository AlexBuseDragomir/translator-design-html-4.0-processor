package html.common;

import html.HtmlAttribute;
import utility.StringUtility;
import utility.ValidationUtility;

public class AlignAttribute extends HtmlAttribute {

    public AlignAttribute() {
        setName("align");
    }

    public AlignAttribute(String value) {
        setName("align");
        setValue(value);
    }

    @Override
    public boolean isSyntacticallyValid() {
        String value = StringUtility.removeDoubleQuotes(getValue());
        return ValidationUtility.isAlignValid(value);
    }
}
