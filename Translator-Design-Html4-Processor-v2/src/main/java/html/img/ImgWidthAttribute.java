package html.img;

import html.HtmlAttribute;
import utility.AttributeMetrics;
import utility.StringUtility;

public class ImgWidthAttribute extends HtmlAttribute {

    public ImgWidthAttribute() {
        setName("width");
    }

    public ImgWidthAttribute(String value) {
        setName("width");
        setValue(value);
    }

    @Override
    public boolean isSyntacticallyValid() {
        int value = Integer.parseInt(
                StringUtility.removeDoubleQuotes(getValue()));

        return (value >= AttributeMetrics.MIN_IMG_WIDTH &&
                value <= AttributeMetrics.MAX_IMG_WIDTH);
    }
}
