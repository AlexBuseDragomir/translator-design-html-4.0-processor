package html.list;

import html.HtmlAttribute;
import utility.StringUtility;
import utility.ValidationUtility;

public class LiTypeAttribute extends HtmlAttribute {

    public LiTypeAttribute() {
        setName("type");
    }

    public LiTypeAttribute(String value) {
        setName("type");
        setValue(value);
    }

    @Override
    public boolean isSyntacticallyValid() {
        String value = StringUtility.removeDoubleQuotes(getValue());
        return ValidationUtility.isLiTypeValid(value);
    }
}
