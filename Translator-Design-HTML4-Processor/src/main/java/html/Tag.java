package html;

public enum Tag {
    BODY(TagClosing.CLOSING), FRAMESET(TagClosing.CLOSING), FRAME(TagClosing.NOT_CLOSING),
    NOFRAME(TagClosing.NOT_CLOSING), FORM(TagClosing.CLOSING), INPUT(TagClosing.NOT_CLOSING),
    SELECT(TagClosing.CLOSING), OPTION(TagClosing.NOT_CLOSING), TABLE(TagClosing.CLOSING),
    TR(TagClosing.CLOSING), TD(TagClosing.CLOSING), TH(TagClosing.CLOSING), THEAD(TagClosing.CLOSING),
    TBODY(TagClosing.CLOSING), IMG(TagClosing.NOT_CLOSING), A(TagClosing.NOT_CLOSING),
    LINK(TagClosing.NOT_CLOSING), UL(TagClosing.CLOSING), OL(TagClosing.CLOSING), LI(TagClosing.CLOSING),
    B(TagClosing.CLOSING), I(TagClosing.CLOSING), U(TagClosing.CLOSING), SMALL(TagClosing.CLOSING),
    SUP(TagClosing.CLOSING), SUB(TagClosing.CLOSING), CENTER(TagClosing.CLOSING),
    FONT(TagClosing.CLOSING), H1(TagClosing.CLOSING), H2(TagClosing.CLOSING), H3(TagClosing.CLOSING),
    H4(TagClosing.CLOSING), H5(TagClosing.CLOSING), H6(TagClosing.CLOSING), P(TagClosing.CLOSING),
    HR(TagClosing.NOT_CLOSING), BR(TagClosing.NOT_CLOSING);

    private final TagClosing closingOption;

    Tag(TagClosing closingOption) {
        this.closingOption = closingOption;
    }

    private TagClosing getClosingOption() {
        return this.closingOption;
    }
}