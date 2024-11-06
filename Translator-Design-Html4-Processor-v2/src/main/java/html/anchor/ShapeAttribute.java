package html.anchor;

import html.HtmlAttribute;
import utility.StringUtility;
import utility.ValidationUtility;

public class ShapeAttribute extends HtmlAttribute {

    public ShapeAttribute() {
        setName("shape");
    }

    public ShapeAttribute(String value) {
        setName("shape");
        setValue(value);
    }

    @Override
    public boolean isSyntacticallyValid() {
        String value = StringUtility.removeDoubleQuotes(getValue());
        return ValidationUtility.isShapeValid(value);
    }
}