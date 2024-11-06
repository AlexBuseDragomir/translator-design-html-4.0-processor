package html.anchor;

import html.HtmlAttribute;
import utility.StringUtility;
import utility.ValidationUtility;

public class ARelAttribute extends HtmlAttribute {

    public ARelAttribute() {
        setName("rel");
    }

    public ARelAttribute(String value) {
        setName("rel");
        setValue(value);
    }

    @Override
    public boolean isSyntacticallyValid() {
        String value = StringUtility.removeDoubleQuotes(getValue());
        return ValidationUtility.isRelationshipValid(value);
    }
}
