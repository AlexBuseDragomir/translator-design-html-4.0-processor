package html.td;

import html.HtmlAttribute;
import utility.AttributeMetrics;
import utility.StringUtility;

public class ColspanAttribute extends HtmlAttribute {

    public ColspanAttribute() {
        setName("colspan");
    }

    public ColspanAttribute(String value) {
        setName("colspan");
        setValue(value);
    }

    @Override
    public boolean isSyntacticallyValid() {
        int value = Integer.parseInt(
                StringUtility.removeDoubleQuotes(getValue()));

        return value >= AttributeMetrics.MIN_COL_SPAN &&
               value <= AttributeMetrics.MAX_COL_SPAN;
    }
}
