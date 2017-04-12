package com.sca.tools;

import com.google.common.base.CaseFormat;

/**
 * Created by ZFTC0418 on 31/03/2015.
 */
public class CamelCasedUnderscored {
    public static void main(String[] args) {
        CamelCasedUnderscored runner = new CamelCasedUnderscored();
        runner.testCaseFormat();

    }

    private void testCaseFormat() {
        String data = "test_data";
        System.out.println(CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL, "test-data"));
        System.out.println(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "test_data"));
        System.out.println(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, "test_data"));
    }
}
