package com.panli.factory.factory_method.parser;

import com.panli.factory.factory_method.domain.RuleConfig;

/**
 * @author lipan
 * @date 2020-08-31
 */
public interface IRuleConfigParser {
    RuleConfig parse(String configText);
}
