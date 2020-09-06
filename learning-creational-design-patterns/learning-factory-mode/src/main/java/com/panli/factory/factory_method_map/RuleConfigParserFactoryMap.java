package com.panli.factory.factory_method_map;

import com.panli.factory.factory_method_map.parser.IRuleConfigParserFactory;
import com.panli.factory.factory_method_map.parser.impl.JsonRuleConfigParserFactory;
import com.panli.factory.factory_method_map.parser.impl.PropertiesRuleConfigParserFactory;
import com.panli.factory.factory_method_map.parser.impl.XmlRuleConfigParserFactory;
import com.panli.factory.factory_method_map.parser.impl.YamlRuleConfigParserFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lipan
 * @date 2020-09-04
 */
public class RuleConfigParserFactoryMap {

    private static final Map<String, IRuleConfigParserFactory> cachedFactories = new HashMap<String, IRuleConfigParserFactory>();

    static {
        cachedFactories.put("json", new JsonRuleConfigParserFactory());
        cachedFactories.put("xml", new XmlRuleConfigParserFactory());
        cachedFactories.put("yaml", new YamlRuleConfigParserFactory());
        cachedFactories.put("properties", new PropertiesRuleConfigParserFactory());
    }

    public static IRuleConfigParserFactory getParserFactory(String type) {
        if (type == null || type.isEmpty()) {
            return null;
        }
        IRuleConfigParserFactory parserFactory = cachedFactories.get(type.toLowerCase());
        return parserFactory;
    }
}
