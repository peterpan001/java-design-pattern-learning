package com.panli.factory.simple_factory_2.parser;

import com.panli.factory.simple_factory_2.domain.RuleConfig;

/**
 * @author lipan
 * @date 2020-08-31
 */
public interface IRuleConfigParser {
    RuleConfig parser(String configText);
}
