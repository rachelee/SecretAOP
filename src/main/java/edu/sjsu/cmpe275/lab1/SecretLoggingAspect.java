package edu.sjsu.cmpe275.lab1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Arrays;
import java.util.UUID;

/**
 * Logging class to track methods executed
 * @author Xiaoxiao Li
 * @version %I%, %G%
 * @since 1.0
 */
@Aspect
public class SecretLoggingAspect {
    /**
     * Logging before the execution of readSecret method of SecretService
     * @param joinPoint the join point to execute the method
     */
    @Before("execution(* edu.sjsu.cmpe275.lab1.ConcreteSecretService.readSecret(..))")
    public void beforeRead(JoinPoint joinPoint){
        String userId = (String)joinPoint.getArgs()[0];
        UUID secretId = (UUID)joinPoint.getArgs()[1];
        System.out.println(userId + " reads a secret with ID " + secretId);
        //System.out.println("**************logBefore*************");
    }

    /**
     * Logging before the execution of shareSecret method of SecretService
     * @param joinPoint the join point to execute the method
     */
    @Before("execution(* edu.sjsu.cmpe275.lab1.ConcreteSecretService.shareSecret(..))")
    public void beforeShare(JoinPoint joinPoint){
        String userId = (String)joinPoint.getArgs()[0];
        UUID secretId = (UUID)joinPoint.getArgs()[1];
        System.out.println(userId + " shares a secret with ID " + secretId);
        //System.out.println("**************logBefore*************");
    }

    /**
     * Logging before the execution of unshareSecret method of SecretService
     * @param joinPoint the join point to execute the method
     */
    @Before("execution(* edu.sjsu.cmpe275.lab1.ConcreteSecretService.unshareSecret(..))")
    public void beforeUnshare(JoinPoint joinPoint){
        String userId = (String)joinPoint.getArgs()[0];
        UUID secretId = (UUID)joinPoint.getArgs()[1];
        System.out.println(userId + " unshares a secret with ID " + secretId);
        //System.out.println("**************logBefore*************");
    }

    /**
     * Logging after returning of storeSecret method of SecretService
     * @param joinPoint the join point to execute the method
     * @param retVal return value of storeSecret method of SecretService
     */
    @AfterReturning(pointcut="execution(* edu.sjsu.cmpe275.lab1.ConcreteSecretService.storeSecret(..))",
            returning= "retVal")
    public void logAfter(JoinPoint joinPoint, Object retVal){
        String userId = (String)joinPoint.getArgs()[0];;
        System.out.println(userId + " creates a secret with ID " + retVal);

    }
}


