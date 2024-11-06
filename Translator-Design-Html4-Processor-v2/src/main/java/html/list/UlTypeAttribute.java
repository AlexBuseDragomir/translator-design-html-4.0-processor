package html.list;

import html.HtmlAttribute;
import utility.StringUtility;
import utility.ValidationUtility;

public class UlTypeAttribute extends HtmlAttribute {

    public UlTypeAttribute() {
        setName("type");
    }

    public UlTypeAttribute(String value) {
        setName("type");
        setValue(value);
    }

    @Override
    public boolean isSyntacticallyValid() {
        String value = StringUtility.removeDoubleQuotes(getValue());
        return ValidationUtility.isUlTypeValid(value);
    }
}
