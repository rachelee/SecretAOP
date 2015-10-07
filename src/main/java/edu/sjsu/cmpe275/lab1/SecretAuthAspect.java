package edu.sjsu.cmpe275.lab1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

/**
 * Authorization class to check whether a user is the owner of a secret
 * @author Xiaoxiao Li
 * @version %I%, %G%
 * @since 1.0
 */
@Aspect
public class SecretAuthAspect {
    @Autowired
    private SecretStorage secrets;
    /**
     * Check if the user is the owner or in the share list of the secret
     * @param joinPoint the join point to execute the method
     * @exception RuntimeException if the user is not the owner of the secret
     */

    @Before("execution(* edu.sjsu.cmpe275.lab1.SecretService.*(String, java.util.UUID,..))")
    public void ownerAuth(JoinPoint joinPoint) throws Throwable{

        UUID secretId = (UUID)joinPoint.getArgs()[1];
        Secret secret = secrets.getSecret(secretId);
        String userId = (String)joinPoint.getArgs()[0];
        //System.out.println("Checking whether user " + userId + " has the access to read secret "+secret.getSecretId());
        if(!secret.getOwner().equals(userId)&&
                !secret.getSharedList().contains(userId)){
            throw new UnauthorizedException();
        }


    }


}
