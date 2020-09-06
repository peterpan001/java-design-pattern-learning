package com.panli.factory.factory_method_map.parser.impl;

import com.panli.factory.factory_method_map.parser.IRuleConfigParser;
import com.panli.factory.factory_method_map.parser.IRuleConfigParserFactory;

/**
 * @author lipan
 * @date 2020-09-04
 */
public class PropertiesRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new PropertiesRuleConfigParser();
    }
}
