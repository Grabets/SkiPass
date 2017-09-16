package com.SkiPass.service;

import com.SkiPass.pass.DateBasedSkiPass;
import com.SkiPass.pass.QuantityBasedSkiPass;
import com.SkiPass.pass.SkiPass;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ApplicationStrategyFactory {
    public static  <T extends SkiPass> SkiPassApplicationStrategy createStrategy (T skiPass)
            throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Class strategyClass = skiPass.getType().getApplicationStrategy();
        Constructor ctor = strategyClass.getConstructor(skiPass.getClass());
        Object newInstance = ctor.newInstance(skiPass);
        return (SkiPassApplicationStrategy) newInstance;

    }

    public static SkiPassApplicationStrategy createStrategy(QuantityBasedSkiPass quantityBasedSkiPass){
        return new FixedNumberApplicationStrategy(quantityBasedSkiPass);
    }

    public static SkiPassApplicationStrategy createStrategy(DateBasedSkiPass skiPass){
        return new TimeBasedApplicationStrategy(skiPass);
    }
}
