package com.panli.factory.factory_method.parser.impl;

import com.panli.factory.factory_method.parser.IRuleConfigParser;
import com.panli.factory.factory_method.parser.IRuleConfigParserFactory;

/**
 * @author lipan
 * @date 2020-09-03
 */
public class XmlRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new XmlRuleConfigParser();
    }
}
