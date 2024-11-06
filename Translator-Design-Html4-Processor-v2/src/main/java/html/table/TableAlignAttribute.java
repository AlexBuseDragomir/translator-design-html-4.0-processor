package html.table;

import html.HtmlAttribute;
import utility.StringUtility;
import utility.ValidationUtility;

public class TableAlignAttribute extends HtmlAttribute {

    public TableAlignAttribute() {
        setName("align");
    }

    public TableAlignAttribute(String value) {
        setName("align");
        setValue(value);
    }

    @Override
    public boolean isSyntacticallyValid() {
        String value = StringUtility.removeDoubleQuotes(getValue());
        return ValidationUtility.isTableAlignValid(value);
    }
}
