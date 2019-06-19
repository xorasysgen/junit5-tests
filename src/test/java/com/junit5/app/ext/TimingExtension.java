package com.junit5.app.ext;

import java.lang.reflect.Method;
import java.util.logging.Logger;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;
import org.junit.jupiter.api.extension.ExtensionContext.Store;

public class TimingExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

    private static final Logger logger = Logger.getLogger(TimingExtension.class.getName());
    private static final String START_TIME = "start time";

    private Store getStore(ExtensionContext context) {
    	Method testMethod = context.getRequiredTestMethod();
    	Class<? extends TimingExtension> clazz=getClass();
    	return context.getStore(Namespace.create(clazz, testMethod));
    }
    
    @Override
    public void beforeTestExecution(ExtensionContext context) throws Exception {
        getStore(context).put(START_TIME, System.currentTimeMillis());
    }

    
    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
        Method testMethod = context.getRequiredTestMethod();
        long startTime = getStore(context).remove(START_TIME, long.class);
        long duration = System.currentTimeMillis() - startTime;

        logger.info(() ->
            String.format("Method [%s] took %s ms.", testMethod.getName(), duration));
    }


}