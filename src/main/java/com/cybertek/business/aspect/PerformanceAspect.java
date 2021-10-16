package com.cybertek.business.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
@Slf4j
public class PerformanceAspect {


    @Pointcut("@annotation(com.cybertek.business.annotation.ExecutionTime)")
    private void anyExecutionTimeOperation(){}



    @Around("anyExecutionTimeOperation()")
    public Object anyExecutionTimeOperationAdvice(ProceedingJoinPoint joinPoint){
        long beforeTime = System.currentTimeMillis();
        Object result = null;


        try {
            result = joinPoint.proceed();
        }catch (Throwable throwable){

            throwable.printStackTrace();
        }

        long afterTime = System.currentTimeMillis();

        log.info("Time taken to execute : {} ms(Method : {} - Parameters :{} ",(afterTime-beforeTime),joinPoint.getSignature().toLongString(),joinPoint.getArgs());


        return result;
    }


}
