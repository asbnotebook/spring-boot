package com.asbnotebook.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Around("execution(* com.asbnotebook.service.*.*(..))")
    public Object logServiceMethods(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] params = joinPoint.getArgs();
        String methodName = joinPoint.getSignature().getName();

        log.info("Entering into service:{} with params: {}",methodName, params);
        Object result = joinPoint.proceed();
        log.info("Returning from service method:{} with response: {}", methodName, result);

        return result;
    }

    @Before("@annotation(LogIt)")
    public void logWithAnnotation(JoinPoint joinPoint){
        log.info("Before entering the method:{} with params:{}", joinPoint.getSignature().getName(), joinPoint.getArgs());
    }
}
