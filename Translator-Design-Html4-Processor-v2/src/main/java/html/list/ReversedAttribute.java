package html.list;

import html.HtmlAttribute;

// boolean attribute
// the list is ordered ascending
// if the attribute is absent
// and descending if the attribute
// is present; so no added content
public class ReversedAttribute extends HtmlAttribute {

    public ReversedAttribute() {
        setName("reversed");
    }

    @Override
    public boolean isSyntacticallyValid() {
        return true;
    }
}
