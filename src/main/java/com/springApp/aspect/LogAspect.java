package com.springApp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LogAspect {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Before("execution(* com.springApp.controller.*Controller.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("[CALLING FOR]: " + joinPoint.getSignature().getName());
        Object[] args = joinPoint.getArgs();
        if (args != null && args.length > 0) {
            logger.info("[ARGUMENTS TO BE RECEIVED]: ");
            for (Object arg : args) {
                logger.info(arg.toString());
            }
        }
    }
}
