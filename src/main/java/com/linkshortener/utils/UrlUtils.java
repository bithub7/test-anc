package com.linkshortener.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlUtils {

    public static String URL_REGEX = "^((https?|ftp)://|(www|ftp)\\.)?[a-z0-9-]+(\\.[a-z0-9-]+)+([/?].*)?$";

    public static boolean isURL(String url) {
        if(url == "" || url == null){
            return false;
        }
        Pattern p = Pattern.compile(URL_REGEX);
        Matcher m = p.matcher(url);
        if (m.find()) {
            return true;
        }
        return false;
    }
}
