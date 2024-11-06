package html.td;

import html.HtmlAttribute;

// boolean attribute
// does not permit text wrapping
// if present
public class NoWrapAttribute extends HtmlAttribute {

    public NoWrapAttribute() {
        setName("nowrap");
    }

    @Override
    public boolean isSyntacticallyValid() {
        return true;
    }
}
