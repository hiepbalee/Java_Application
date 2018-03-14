package org.pnv.functions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CapsLock {

    public static StringBuffer capstext(String str) {
        
        System.out.println(str);
        StringBuffer stringbf = new StringBuffer();
        Matcher m = Pattern.compile("([a-z])([a-z]*)",
                Pattern.CASE_INSENSITIVE).matcher(str);
        while (m.find()) {
            m.appendReplacement(stringbf,
                    m.group(1).toUpperCase() + m.group(2).toLowerCase());
        }
        System.out.println(m.appendTail(stringbf).toString());
        return stringbf;
        
    }

}
