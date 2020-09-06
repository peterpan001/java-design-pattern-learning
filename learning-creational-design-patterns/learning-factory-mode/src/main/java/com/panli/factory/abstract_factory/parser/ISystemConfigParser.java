package com.panli.factory.abstract_factory.parser;

import com.panli.factory.abstract_factory.domain.SystemConfig;

/**
 * @author lipan
 * @date 2020-09-04
 */
public interface ISystemConfigParser {

    SystemConfig parse(String configText);
}
