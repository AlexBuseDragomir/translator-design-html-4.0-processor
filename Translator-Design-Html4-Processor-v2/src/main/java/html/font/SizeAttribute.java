package html.font;

import html.HtmlAttribute;
import utility.AttributeMetrics;
import utility.StringUtility;

public class SizeAttribute extends HtmlAttribute {

    public SizeAttribute() {
        setName("size");
    }

    public SizeAttribute(String value) {
        setName("size");
        setValue(value);
    }

    @Override
    public boolean isSyntacticallyValid() {
        int value = Integer.parseInt(
                StringUtility.removeDoubleQuotes(getValue()));

        return value >= AttributeMetrics.MIN_FONT_SIZE &&
               value <= AttributeMetrics.MAX_FONT_SIZE;
    }
}