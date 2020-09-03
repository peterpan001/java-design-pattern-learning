package com.panli.factory.simple_factory_1.parser.impl;

import com.panli.factory.simple_factory_1.domain.RuleConfig;
import com.panli.factory.simple_factory_1.exception.InvalidRuleConfigException;
import com.panli.factory.simple_factory_1.parser.IRuleConfigParser;

/**
 * @author lipan
 * @date 2020-08-31
 * @desc 简单工厂模式的第一种实现
 */
public class RuleConfigSource {
    public RuleConfig load(String ruleConfigFilePath) {
        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);
        IRuleConfigParser parser = RuleConfigParserFactory.createParser(ruleConfigFileExtension);
        if (parser == null) {
            throw new InvalidRuleConfigException("Rule config file format is not supported:" + ruleConfigFilePath);
        }
        String configText = "";
        // 业务逻辑代码：从ruleConfigFilePath文件中读取配置文本到configText中
        RuleConfig ruleConfig = parser.parse(configText);
        return ruleConfig;
    }

    private String getFileExtension(String filePath) {
        // 业务逻辑代码：解析文件名获取扩展名；比如rule.json，返回json。
        return "json";
    }
}
