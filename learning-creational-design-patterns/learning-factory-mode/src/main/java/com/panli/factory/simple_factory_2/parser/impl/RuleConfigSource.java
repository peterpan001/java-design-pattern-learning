package com.panli.factory.simple_factory_2.parser.impl;

import com.panli.factory.simple_factory_2.domain.RuleConfig;
import com.panli.factory.simple_factory_2.parser.IRuleConfigParser;

/**
 * @author lipan
 * @date 2020-08-31
 * @desc 简单工厂模式-2
 */
public class RuleConfigSource {

    public RuleConfig load(String ruleConfigFilePath) {
        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);
        IRuleConfigParser parser = RuleConfigParserFactory.createParser(ruleConfigFileExtension);
        String configText = "";
        // 从ruleConfigFilePath文件中读取配置文本到configText中
        RuleConfig ruleConfig = parser.parser(configText);
        return ruleConfig;
    }

    private String getFileExtension(String filePath) {
        // 业务逻辑代码：解析文件名获取扩展名；比如rule.json，返回json。
        return "json";
    }
}
