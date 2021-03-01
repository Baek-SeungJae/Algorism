package seoyoon;

import org.apache.commons.lang3.StringUtils;

public class seoyoon {
    public static void main(String[] args) {
        String[] str= tagNameSplit("테9,테8,고정비용");
        for (String data : str){
            System.out.println(data);
        }
    }

    public static String[] tagNameSplit(String tagNames) {
        if (StringUtils.isEmpty(tagNames)) {
            return null;
        }

        String cleaned = cleanTagNames(tagNames);
        System.out.println("확인:" + cleaned);
        if (StringUtils.isEmpty(cleaned)) {
            return null;
        } else {
            return cleaned.split(",");
        }
    }

    public static String cleanTagNames(String tagNames) {
        if (StringUtils.isEmpty(tagNames)) {
            return null;
        }

        tagNames = tagNames.replaceAll("[^\u3131-\u318E\uAC00-\uD7A3a-zA-Z0-9,]", "").replaceAll(",+", ",");
        tagNames = StringUtils.removeStart(tagNames, ",");
        tagNames = StringUtils.removeEnd(tagNames, ",");
        if (StringUtils.isEmpty(tagNames)) {
            return null;
        } else {
            return tagNames;
        }
    }
}