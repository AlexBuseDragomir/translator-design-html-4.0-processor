package html.common;

import html.HtmlAttribute;
import utility.AttributeMetrics;
import utility.StringUtility;
import utility.ValidationUtility;

public class WidthAttribute extends HtmlAttribute {

    public WidthAttribute() {
        setName("width");
    }

    public WidthAttribute(String value) {
        setName("width");
        setValue(value);
    }

    @Override
    public boolean isSyntacticallyValid() {
        int value = Integer.parseInt(
                StringUtility.removeDoubleQuotes(getValue()));

        return ValidationUtility.isStringPercentValue(getValue()) ||
               (value >= AttributeMetrics.COMMON_MIN_WIDTH &&
                value < AttributeMetrics.COMMON_MAX_WIDTH);
    }
}