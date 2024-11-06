package html.list;

import html.HtmlAttribute;
import utility.AttributeMetrics;
import utility.StringUtility;

public class StartAttribute extends HtmlAttribute {

    public StartAttribute() {
        setName("start");
    }

    public StartAttribute(String value) {
        setName("start");
        setValue(value);
    }

    @Override
    public boolean isSyntacticallyValid() {
        int value = Integer.parseInt(
                StringUtility.removeDoubleQuotes(getValue()));

        return value >= AttributeMetrics.MIN_START_VALUE &&
               value <= AttributeMetrics.MAX_START_VALUE;
    }
}
