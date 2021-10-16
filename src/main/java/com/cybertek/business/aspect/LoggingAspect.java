package com.cybertek.business.aspect;


import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
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
//        log.info();

    }




    }
