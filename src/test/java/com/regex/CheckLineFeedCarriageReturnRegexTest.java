package com.regex;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;

public class CheckLineFeedCarriageReturnRegexTest {

    @Test
    public void shouldMatchAllExceptCR_LF_TAB_DOLLAR() {
        String input = "Vente par Mme SAUCE et Mme SCHMIT à Mr DETRY Daniel (D:2220917|374)" + "\n\r\f\tVos certificats PEB et électriques.";
        String regexp = "^$|^[\\u000A\\u000D\\u000C\\u0009\\u0020-\\u007E\\u00A0-\\u02AF\\u20A0-\\u20BF]+$";
        Pattern pattern = Pattern.compile(regexp);
        Matcher m = pattern.matcher(input);
        boolean isMatched = m.matches();
        assertTrue(isMatched);

        Map<String, String> map = new HashMap<>();
        map.put("one", input);
    }

    @Test
    public void testSorting() {
        List<String> sorts = Arrays.asList("name2,asc");
        String[] strings = sorts.stream().toArray(String[]::new);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
