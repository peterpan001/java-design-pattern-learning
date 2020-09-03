package com.panli.factory.simple_factory_1.parser;

import com.panli.factory.simple_factory_1.domain.RuleConfig;

/**
 * @author lipan
 * @date 2020-08-31
 */
public interface IRuleConfigParser {

    RuleConfig parse(String configText);
}
