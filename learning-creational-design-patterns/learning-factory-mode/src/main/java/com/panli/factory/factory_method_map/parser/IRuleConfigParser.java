package com.panli.factory.factory_method_map.parser;

import com.panli.factory.factory_method_map.domain.RuleConfig;

/**
 * @author lipan
 * @date 2020-09-04
 */
public interface IRuleConfigParser {
    RuleConfig parse(String configText);
}
