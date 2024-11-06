package html.list;

import html.HtmlAttribute;
import utility.StringUtility;
import utility.ValidationUtility;

public class OlTypeAttribute extends HtmlAttribute {

    public OlTypeAttribute() {
        setName("type");
    }

    public OlTypeAttribute(String value) {
        setName("type");
        setValue(value);
    }

    @Override
    public boolean isSyntacticallyValid() {
        String value = StringUtility.removeDoubleQuotes(getValue());
        return ValidationUtility.isOlTypeValid(value);
    }
}
