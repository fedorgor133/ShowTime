package model;
import java.lang.reflect.Constructor;
import model.Jocs.GameClass;

public class StrategyFactory {
    public static MemberStrategy createGameStrategy(String type, Params params) {
        try {
            String basePackage = GameClass.class.getPackage().getName();
            Class<?> clazz = Class.forName(basePackage + "." + type);
            Constructor<?> constructor = clazz.getConstructor(Params.class);
            return (MemberStrategy) constructor.newInstance(params);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
