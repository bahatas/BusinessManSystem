package com.cybertek.business.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
@Slf4j
public class LoggingAspect {

    @Pointcut("execution(* com.cybertek.business.controller.ProjectController.*(..)) || execution(* com.cybertek.business.controller.TaskController.*(..))")
    private void anyControllerOperation() {
    }

    @Before("anyControllerOperation()")
    public void anyBeforeControllerOperationAdvice(JoinPoint joinPoint) {


//    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        log.info("Before  Method :{}- Parameters: {} ",joinPoint.getSignature().toString(),joinPoint.getArgs());

    }


    @AfterReturning(pointcut ="anyControllerOperation()",returning ="results" )
    public void anyAfterReturningControllerOperationAdvice(JoinPoint joinPoint, Object results){
       //    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
       // log.info("AfterReturning(User : {} Method : {} - Results : {}",auth.getName(),joinPoint.getSignature().toShortString(),results.toString());

        log.info("AfterReturning( Method : {} - Results : {}",joinPoint.getSignature().toShortString(),results.toString());

    }

    @AfterThrowing(pointcut = "anyControllerOperation()",throwing = "exception")
    public void anyAfterThrowingControllerOperationAdvice(JoinPoint joinPoint,RuntimeException exception){


        log.info("After throwing -->( Method : {} - Exception : {}",exception.getLocalizedMessage());

    }

    }
