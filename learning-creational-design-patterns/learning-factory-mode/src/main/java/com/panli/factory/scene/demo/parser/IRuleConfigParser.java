package com.panli.factory.scene.demo.parser;

import com.panli.factory.scene.demo.domain.RuleConfig;

/**
 * @author lipan
 * @date 2020-08-31
 */
public interface IRuleConfigParser {
    RuleConfig parse(String configText);
}
