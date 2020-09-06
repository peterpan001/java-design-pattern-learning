package com.panli.factory.factory_method_map;

import com.panli.factory.factory_method_map.exception.InvalidRuleConfigException;
import com.panli.factory.factory_method_map.domain.RuleConfig;
import com.panli.factory.factory_method_map.parser.IRuleConfigParser;
import com.panli.factory.factory_method_map.parser.IRuleConfigParserFactory;

/**
 * @author lipan
 * @date 2020-09-04
 */
public class RuleConfigSource {


    public RuleConfig load(String ruleConfigFilePath) {
        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);
        IRuleConfigParserFactory parserFactory = RuleConfigParserFactoryMap.getParserFactory(ruleConfigFileExtension);
        if (parserFactory == null) {
            throw new InvalidRuleConfigException("Rule config file format is not supported:" + ruleConfigFilePath);
        }
        IRuleConfigParser parser = parserFactory.createParser();

        String configText = "";
        // 从ruleConfigFilePath文件中读取配置文本到 configText 中
        RuleConfig ruleConfig = parser.parse(configText);
        return ruleConfig;
    }


    private String getFileExtension(String filePath) {

        // ...解析文件名获取扩展名，比如rule.json，返回json
        return "json";
    }
}
