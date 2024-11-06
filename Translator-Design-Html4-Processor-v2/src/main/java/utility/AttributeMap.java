package utility;

import html.HtmlAttribute;
import html.anchor.ARelAttribute;
import html.anchor.ATypeAttribute;
import html.anchor.HrefAttribute;
import html.anchor.ShapeAttribute;
import html.body.BackgroundAttribute;
import html.common.AlignAttribute;
import html.common.BgColorAttribute;
import html.common.HeightAttribute;
import html.common.WidthAttribute;
import html.font.ColorAttribute;
import html.font.FaceAttribute;
import html.font.SizeAttribute;
import html.img.*;
import html.list.*;
import html.table.BorderAttribute;
import html.table.SummaryAttribute;
import html.table.TableAlignAttribute;
import html.td.ColspanAttribute;
import html.td.NoWrapAttribute;
import html.td.VAlignAttribute;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class AttributeMap {

    private static Map<String, BiFunction<String, String, HtmlAttribute>>
            attributeMap = new HashMap<>();

    public static Map<String, BiFunction<String, String, HtmlAttribute>> generateMap() {
        initializeAttributeMap();
        return attributeMap;
    }

    // initializes the map
    // that will be used for the
    // creation of the attribute list
    private static void initializeAttributeMap() {

        attributeMap.put("rel", (String tagName, String value) -> {
            return new ARelAttribute(value);
        });
        attributeMap.put("href", (String tagName, String value) -> {
            return new HrefAttribute(value);
        });
        attributeMap.put("type", (String tagName, String value) -> {
            switch(tagName) {
                case "a":
                    return new ATypeAttribute(value);
                case "li":
                    return new LiTypeAttribute(value);
                case "ol":
                    return new OlTypeAttribute(value);
                default:
                    return new UlTypeAttribute(value);
            }
        });
        attributeMap.put("shape", (String tagName, String value) -> {
            return new ShapeAttribute(value);
        });
        attributeMap.put("background", (String tagName, String value) -> {
            return new BackgroundAttribute(value);
        });
        attributeMap.put("align", (String tagName, String value) -> {
            switch(tagName) {
                case "img":
                    return new ImgAlignAttribute(value);
                case "table":
                    return new TableAlignAttribute(value);
                default:
                    return new AlignAttribute(value);
            }
        });
        attributeMap.put("bgcolor", (String tagName, String value) -> {
            return new BgColorAttribute(value);
        });
        attributeMap.put("height", (String tagName, String value) -> {
            if (tagName.equals("img")) {
                return new ImgHeightAttribute(value);
            }
            return new HeightAttribute(value);
        });
        attributeMap.put("width", (String tagName, String value) -> {
            if (tagName.equals("img")) {
                return new ImgWidthAttribute(value);
            }
            return new WidthAttribute(value);
        });
        attributeMap.put("color", (String tagName, String value) -> {
            return new ColorAttribute(value);
        });
        attributeMap.put("face", (String tagName, String value) -> {
            return new FaceAttribute(value);
        });
        attributeMap.put("size", (String tagName, String value) -> {
            return new SizeAttribute(value);
        });
        attributeMap.put("alt", (String tagName, String value) -> {
            return new AltAttribute(value);
        });
        attributeMap.put("src", (String tagName, String value) -> {
            return new SrcAttribute(value);
        });
        attributeMap.put("reversed", (String tagName, String value) -> {
            return new ReversedAttribute();
        });
        attributeMap.put("start", (String tagName, String value) -> {
            return new StartAttribute(value);
        });
        attributeMap.put("border", (String tagName, String value) -> {
            return new BorderAttribute(value);
        });
        attributeMap.put("summary", (String tagName, String value) -> {
            return new SummaryAttribute(value);
        });
        attributeMap.put("colspan", (String tagName, String value) -> {
            return new ColspanAttribute(value);
        });
        attributeMap.put("nowrap", (String tagName, String value) -> {
            return new NoWrapAttribute();
        });
        attributeMap.put("valign", (String tagName, String value) -> {
            return new VAlignAttribute(value);
        });
    }
}
