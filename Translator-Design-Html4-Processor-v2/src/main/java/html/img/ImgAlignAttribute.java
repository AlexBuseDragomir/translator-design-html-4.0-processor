package html.img;

import html.HtmlAttribute;
import utility.StringUtility;
import utility.ValidationUtility;

public class ImgAlignAttribute extends HtmlAttribute {

    public ImgAlignAttribute() {
        setName("align");
    }

    public ImgAlignAttribute(String value) {
        setName("align");
        setValue(value);
    }

    @Override
    public boolean isSyntacticallyValid() {
        String value = StringUtility.removeDoubleQuotes(getValue());
        return ValidationUtility.isImgAlignValid(value);
    }
}
