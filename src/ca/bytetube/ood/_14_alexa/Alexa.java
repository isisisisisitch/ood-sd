package ca.bytetube.ood._14_alexa;

import java.util.HashMap;
import java.util.Map;

public class Alexa {
    //commandFactories装载rule和command的对应关系
    Map<Rule, CommandFactory> commandFactories;
    ErrorHandler errorHandler;

    public Alexa() {
        commandFactories = new HashMap<>();
        errorHandler = new ErrorHandler();
        initializeCommands();
    }

    //创建weatherRule规则，用来匹配 weatherCommandFactory
    private void initializeCommands() {
        addCommand(new WeatherRule(), input -> {
            //findMathingRule(input)遍历commandFactories的key（rule），找到与输入匹配的rule
            WeatherRule rule = (WeatherRule) findMathingRule(input);
            System.out.println(rule);
            String location = rule.extractLocation(input);
            return new WeatherCommand(location);
        });
    }

    public void addCommand(Rule rule, CommandFactory factory) {
        commandFactories.put(rule, factory);
    }

    public void processInput(String input) {
        Rule rule = findMathingRule(input);
        System.out.println(rule);
        //分2种情况：
        //1.匹配失败
        if (rule == null) {
            System.out.println("Sorry, I dont understand your command!");
            return;
        }
        try {
            //2.匹配成功
            //使用factory生成对应的command
            //验证input，如果是无效输入，handleError()处理错误
            //执行command，完成对应指令
            Command command = commandFactories.get(rule).createCommand(input);
            if (!command.validate()) {
                handleError(rule);
                return;
            }
            command.execute();
        } catch (Exception e) {
            errorHandler.handleError(rule);
        }
    }


    private Rule findMathingRule(String input) {
        for (Rule rule : commandFactories.keySet()) {
            if (rule.matches(input)) {
                return rule;
            }
        }
        return null;
    }

    private void handleError(Rule rule) {
        errorHandler.handleError(rule);
    }
}
