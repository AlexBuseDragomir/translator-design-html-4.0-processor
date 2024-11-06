package html.common;

import html.HtmlAttribute;
import utility.AttributeMetrics;
import utility.StringUtility;
import utility.ValidationUtility;

public class HeightAttribute extends HtmlAttribute {

    public HeightAttribute() {
        setName("height");
    }

    public HeightAttribute(String value) {
        setName("height");
        setValue(value);
    }

    @Override
    public boolean isSyntacticallyValid() {
        int value = Integer.parseInt(
                StringUtility.removeDoubleQuotes(getValue()));

        return ValidationUtility.isStringPercentValue(getValue()) ||
                (value >= AttributeMetrics.COMMON_MIN_HEIGHT &&
                 value <= AttributeMetrics.COMMON_MAX_HEIGHT);
    }
}
