package html.img;

import html.HtmlAttribute;
import utility.StringUtility;
import utility.ValidationUtility;

public class SrcAttribute extends HtmlAttribute {

    public SrcAttribute() {
        setName("src");
    }

    public SrcAttribute(String value) {
        setName("src");
        setValue(value);
    }

    @Override
    public boolean isSyntacticallyValid() {
        String value = StringUtility.removeDoubleQuotes(getValue());

        return ValidationUtility.isHttpUrlValid(value) ||
               ValidationUtility.isFilePathUrlValid(value);
    }
}
