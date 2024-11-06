package html.font;

import html.HtmlAttribute;
import utility.StringUtility;
import utility.ValidationUtility;

public class FaceAttribute extends HtmlAttribute {

    public FaceAttribute() {
        setName("face");
    }

    public FaceAttribute(String value) {
        setName("face");
        setValue(value);
    }

    @Override
    public boolean isSyntacticallyValid() {
        String value = StringUtility.removeDoubleQuotes(getValue());
        return ValidationUtility.isFontFaceValid(value);
    }
}