package com.panli.factory.factory_method;


import com.panli.factory.factory_method.domain.RuleConfig;
import com.panli.factory.factory_method.exception.InvalidRuleConfigException;
import com.panli.factory.factory_method.parser.IRuleConfigParser;
import com.panli.factory.factory_method.parser.IRuleConfigParserFactory;
import com.panli.factory.factory_method.parser.impl.JsonRuleConfigParserFactory;
import com.panli.factory.factory_method.parser.impl.PropertiesRuleConfigParserFactory;
import com.panli.factory.factory_method.parser.impl.XmlRuleConfigParserFactory;
import com.panli.factory.factory_method.parser.impl.YamlRuleConfigParserFactory;

/**
 * @author lipan
 * @date 2020-09-03
 */
public class RuleConfigSource {

    public RuleConfig load(String ruleConfigFilePath) {

        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);

        IRuleConfigParserFactory parserFactory = null;
        if ("json".equalsIgnoreCase(ruleConfigFileExtension)) {
            parserFactory = new JsonRuleConfigParserFactory();
        } else if ("xml".equalsIgnoreCase(ruleConfigFileExtension)) {
            parserFactory = new XmlRuleConfigParserFactory();
        } else if ("yaml".equalsIgnoreCase(ruleConfigFileExtension)) {
            parserFactory = new YamlRuleConfigParserFactory();
        } else if ("properties".equalsIgnoreCase(ruleConfigFileExtension)) {
            parserFactory = new PropertiesRuleConfigParserFactory();
        } else {
            throw new InvalidRuleConfigException("Rule config file format is not supported:" + ruleConfigFilePath);
        }
        IRuleConfigParser parser = parserFactory.createParser();

        String configText = "";

        // 从ruleConfigFilePath文件中读取配置文本到configText中
        RuleConfig ruleConfig = parser.parse(configText);
        return ruleConfig;
    }

    private String getFileExtension(String filePath) {

        // ...解析文件名获取扩展名，比如rule.json，返回json
        return "json";
    }
}
