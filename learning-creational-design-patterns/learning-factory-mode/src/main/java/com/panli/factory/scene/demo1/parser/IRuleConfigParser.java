package com.panli.factory.scene.demo1.parser;

import com.panli.factory.scene.demo1.domain.RuleConfig;

/**
 * @author lipan
 * @date 2020-09-03
 */
public interface IRuleConfigParser {
    RuleConfig parse(String configText);
}
