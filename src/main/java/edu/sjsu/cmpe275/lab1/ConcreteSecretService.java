package edu.sjsu.cmpe275.lab1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
/**
 * Service class to manage secret
 * @author Xiaoxiao Li
 * @version %I%, %G%
 * @since 1.0
 */
public class ConcreteSecretService implements SecretService {

    @Autowired
    SecretStorage secrets;

    public UUID storeSecret(String userId, Secret secret){
        secret.setOwner(userId);
        secret.setSecretId();
        UUID secretId = secret.getSecretId();
        secrets.setSecret(secretId, secret);
        return secretId;
    }

    public Secret readSecret(String userId, UUID secretId){
        //System.out.println(secretList.toString());
        return secrets.getSecret(secretId);
    }

    public void shareSecret(String userId, UUID secretId, String targetUserId){
        Secret secret = secrets.getSecret(secretId);
        secret.addSharedUser(targetUserId);
    }

    public void unshareSecret(String userId, UUID secretId, String targetUserId){
        if(userId != secrets.getSecret(secretId).getOwner()){
            return;
        }
        secrets.getSecret(secretId).removeSharedUser(targetUserId);
    }

}
