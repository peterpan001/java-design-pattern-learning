package com.panli.factory.abstract_factory.parser;

/**
 * @author lipan
 * @date 2020-09-04
 */
public interface IConfigParserFactory {

    IRuleConfigParser createRuleParser();

    ISystemConfigParser createSystemParser();
}
