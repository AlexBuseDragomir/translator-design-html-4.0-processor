package html.img;

import html.HtmlAttribute;
import utility.AttributeMetrics;

public class AltAttribute extends HtmlAttribute {

    public AltAttribute() {
        setName("alt");
    }

    public AltAttribute(String value) {
        setName("alt");
        setValue(value);
    }

    @Override
    public boolean isSyntacticallyValid() {
        return getValue().length() >= AttributeMetrics.MIN_ALT_SIZE &&
               getValue().length() <= AttributeMetrics.MAX_ALT_SIZE;
    }
}
