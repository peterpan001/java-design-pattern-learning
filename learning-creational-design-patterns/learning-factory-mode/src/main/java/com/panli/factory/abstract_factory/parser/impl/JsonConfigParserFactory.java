package com.panli.factory.abstract_factory.parser.impl;

import com.panli.factory.abstract_factory.parser.IConfigParserFactory;
import com.panli.factory.abstract_factory.parser.IRuleConfigParser;
import com.panli.factory.abstract_factory.parser.ISystemConfigParser;

/**
 * @author lipan
 * @date 2020-09-04
 */
public class JsonConfigParserFactory implements IConfigParserFactory {
    @Override
    public IRuleConfigParser createRuleParser() {
        return new JsonRuleConfigParser();
    }

    @Override
    public ISystemConfigParser createSystemParser() {
        return new JsonSystemConfigParser();
    }
}
