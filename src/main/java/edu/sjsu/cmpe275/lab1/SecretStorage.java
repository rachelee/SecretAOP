package edu.sjsu.cmpe275.lab1;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by xiaoxiaoli on 9/25/15.
 */
/**
 * Class to store secret in memory
 * @author Xiaoxiao Li
 * @version %I%, %G%
 * @since 1.0
 */
public class SecretStorage {
    private Map<UUID, Secret> secretList=new HashMap<UUID, Secret>();
    /**
     * @return secret a secret is returned according to the secretId
     */
    public Secret getSecret(UUID secretId){
        return secretList.get(secretId);
    }
    /**
     * Save a new secret to the class
     */
    public void setSecret(UUID secretId, Secret secret){
        secretList.put(secretId, secret);
    }
}
