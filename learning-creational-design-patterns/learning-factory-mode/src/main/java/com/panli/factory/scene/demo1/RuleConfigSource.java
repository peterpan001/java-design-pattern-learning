package com.panli.factory.scene.demo1;

import com.panli.factory.scene.demo1.domain.RuleConfig;
import com.panli.factory.scene.demo1.exception.InvalidRuleConfigException;
import com.panli.factory.scene.demo1.parser.IRuleConfigParser;
import com.panli.factory.scene.demo1.parser.impl.PropertiesRuleConfigParser;
import com.panli.factory.scene.demo1.parser.impl.XmlRuleConfigParser;
import com.panli.factory.scene.demo1.parser.impl.YamlRuleConfigParser;
import com.panli.factory.scene.demo1.parser.impl.JsonRuleConfigParser;

/**
 * @author lipan
 * @date 2020-08-31
 * @desc 针对demo.RuleConfigSource类的load方法进行了优化，将parser创建部分逻辑剥离出来，抽象成createParser()函数
 */
public class RuleConfigSource {

    public RuleConfig load(String ruleConfigFilePath) {
        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);
        IRuleConfigParser parser = createParser(ruleConfigFileExtension);
        if (parser == null) {
            throw new InvalidRuleConfigException("Rule config file format is not supported:" + ruleConfigFilePath);
        }
        String configText = "";
        // 从ruleConfigFilePath文件中读取配置文本到configText中
        RuleConfig ruleConfig = parser.parse(configText);
        return ruleConfig;
    }

    private String getFileExtension(String filePath) {
        // 解析文件名获取扩展名，比如rule.json，返回json
        return "json";
    }

    /**
     * 将parser部分单独抽象出来
     *
     * @param configFormat
     * @return
     */
    private IRuleConfigParser createParser(String configFormat) {
        IRuleConfigParser parser = null;
        if ("json".equalsIgnoreCase(configFormat)) {
            parser = new JsonRuleConfigParser();
        } else if ("xml".equalsIgnoreCase(configFormat)) {
            parser = new XmlRuleConfigParser();
        } else if ("yaml".equalsIgnoreCase(configFormat)) {
            parser = new YamlRuleConfigParser();
        } else if ("properties".equalsIgnoreCase(configFormat)) {
            parser = new PropertiesRuleConfigParser();
        }
        return parser;
    }
}
