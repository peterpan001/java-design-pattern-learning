package com.panli.factory.abstract_factory;


import com.panli.factory.abstract_factory.domain.RuleConfig;
import com.panli.factory.abstract_factory.domain.SystemConfig;
import com.panli.factory.abstract_factory.exception.InvalidRuleConfigException;
import com.panli.factory.abstract_factory.parser.IConfigParserFactory;
import com.panli.factory.abstract_factory.parser.IRuleConfigParser;
import com.panli.factory.abstract_factory.parser.ISystemConfigParser;
import com.panli.factory.abstract_factory.parser.impl.JsonConfigParserFactory;
import com.panli.factory.abstract_factory.parser.impl.XmlConfigParserFactory;

/**
 * @author lipan
 * @date 2020-09-04
 */
public class RuleConfigSource {

    public RuleConfig loadRule(String ruleConfigFilePath) {

        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);

        IConfigParserFactory parserFactory = null;
        if ("json".equalsIgnoreCase(ruleConfigFileExtension)) {
            parserFactory = new JsonConfigParserFactory();
        } else if ("xml".equalsIgnoreCase(ruleConfigFileExtension)) {
            parserFactory = new XmlConfigParserFactory();
        } else {
            throw new InvalidRuleConfigException("Rule config file format is not supported:" + ruleConfigFilePath);
        }
        IRuleConfigParser parser = parserFactory.createRuleParser();

        String configText = "";

        // 从ruleConfigFilePath文件中读取配置文本到configText中
        RuleConfig ruleConfig = parser.parse(configText);
        return ruleConfig;
    }

    public SystemConfig loadSystem(String systemConfigFilePath) {
        String systemConfigFileExtension = getFileExtension(systemConfigFilePath);
        IConfigParserFactory parserFactory = null;
        if ("json".equalsIgnoreCase(systemConfigFileExtension)) {
            parserFactory = new JsonConfigParserFactory();
        } else if ("xml".equalsIgnoreCase(systemConfigFileExtension)) {
            parserFactory = new XmlConfigParserFactory();
        } else {
            throw new InvalidRuleConfigException("Rule config file format is not supported:" + systemConfigFilePath);
        }
        ISystemConfigParser parser = parserFactory.createSystemParser();

        String configText = "";
        // 从ruleConfigFilePath文件中读取配置文本到configText中
        SystemConfig systemConfig = parser.parse(configText);
        return systemConfig;
    }

    private String getFileExtension(String filePath) {

        // ...解析文件名获取扩展名，比如rule.json，返回json
        return "json";
    }
}
