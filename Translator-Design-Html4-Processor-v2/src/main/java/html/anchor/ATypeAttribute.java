package html.anchor;

import html.HtmlAttribute;
import utility.StringUtility;
import utility.ValidationUtility;

public class ATypeAttribute extends HtmlAttribute {

    public ATypeAttribute() {
        setName("type");
    }

    public ATypeAttribute(String value) {
        setName("type");
        setValue(value);
    }

    @Override
    public boolean isSyntacticallyValid() {
        String value = StringUtility.removeDoubleQuotes(getValue());
        return ValidationUtility.isMediaTypeValid(value);
    }
}