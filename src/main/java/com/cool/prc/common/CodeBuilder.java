package com.cool.prc.common;

import com.core.generators.CoolGenerator;

/**
 * Created by vincent on 2019-06-04
 */
public class CodeBuilder {

    public static void main(String[] args) throws Exception {
        CoolGenerator generator = new CoolGenerator();
        generator.url="localhost:3306/prc";
        generator.username="root";
        generator.password="xltys1995";
        generator.table="man_rule_log";
        generator.packagePath="com.cool.prc.manager";
        generator.build();
    }

}
