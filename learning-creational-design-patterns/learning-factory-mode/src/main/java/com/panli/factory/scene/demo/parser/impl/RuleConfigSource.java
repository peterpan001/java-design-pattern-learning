package com.panli.factory.scene.demo.parser.impl;


import com.panli.factory.scene.demo.domain.RuleConfig;
import com.panli.factory.scene.demo.exception.InvalidRuleConfigException;
import com.panli.factory.scene.demo.parser.IRuleConfigParser;

/**
 * @author lipan
 * @date 2020-08-31
 * @desc 工厂模式使用场景demo介绍
 */
public class RuleConfigSource {
    public RuleConfig load(String ruleConfigFilePath) {
        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);
        IRuleConfigParser parser = null;
        if ("json".equalsIgnoreCase(ruleConfigFileExtension)) {
            parser = new JsonRuleConfigParser();
        } else if ("xml".equalsIgnoreCase(ruleConfigFileExtension)) {
            parser = new XmlRuleConfigParser();
        } else if ("yaml".equalsIgnoreCase(ruleConfigFileExtension)) {
            parser = new YamlRuleConfigParser();
        } else if ("properties".equalsIgnoreCase(ruleConfigFileExtension)) {
            parser = new PropertiesRuleConfigParser();
        } else {
            throw new InvalidRuleConfigException("Rule config file format is not supported:" + ruleConfigFilePath);
        }
        String configText = "";
        // 从ruleConfigFilePath文件中读取配置文本到configText中
        RuleConfig ruleConfig = parser.parse(configText);
        return ruleConfig;
    }

    private String getFileExtension(String filePath) {
        // 业务逻辑代码：解析文件名获取扩展名；比如rule.json，返回json。
        return "json";
    }
}
