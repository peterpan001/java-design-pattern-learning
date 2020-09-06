package com.panli.factory.abstract_factory.parser;

import com.panli.factory.abstract_factory.domain.RuleConfig;

/**
 * @author lipan
 * @date 2020-09-04
 */
public interface IRuleConfigParser {
    RuleConfig parse(String configText);
}
