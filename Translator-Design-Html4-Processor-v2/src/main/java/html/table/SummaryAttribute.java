package html.table;

import html.HtmlAttribute;
import utility.AttributeMetrics;

public class SummaryAttribute extends HtmlAttribute {

    public SummaryAttribute() {
        setName("summary");
    }

    public SummaryAttribute(String value) {
        setName("summary");
        setValue(value);
    }

    @Override
    public boolean isSyntacticallyValid() {
        return getValue().length() >= AttributeMetrics.MIN_SUMMARY_SIZE &&
               getValue().length() <= AttributeMetrics.MAX_SUMMARY_SIZE;
    }
}