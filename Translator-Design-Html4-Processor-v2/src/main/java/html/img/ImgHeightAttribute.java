package html.img;

import html.HtmlAttribute;
import utility.AttributeMetrics;
import utility.StringUtility;

public class ImgHeightAttribute extends HtmlAttribute {

    public ImgHeightAttribute() {
        setName("height");
    }

    public ImgHeightAttribute(String value) {
        setName("height");
        setValue(value);
    }

    @Override
    public boolean isSyntacticallyValid() {
        int value = Integer.parseInt(
                StringUtility.removeDoubleQuotes(getValue()));

        return (value >= AttributeMetrics.MIN_IMG_HEIGHT &&
                value <= AttributeMetrics.MAX_IMG_HEIGHT);
    }
}
