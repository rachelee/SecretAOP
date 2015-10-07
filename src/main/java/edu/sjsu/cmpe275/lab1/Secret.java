package edu.sjsu.cmpe275.lab1;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Class to define secret
 * @author Xiaoxiao Li
 * @version %I%, %G%
 * @since 1.0
 */
public class Secret {
    private String owner;
    private Set<String> sharedList;
    private UUID secretId;

    /**
     * Creates a new Secret object
     */
    public Secret(){
        sharedList = new HashSet<String>();
    }

    /**
     * @return owner owner of the secret
     */
    public String getOwner(){
        return owner;
    }


    public Set<String> getSharedList(){
        return sharedList;
    }

    /**
     * @return secretId id of the secret
     */
    public UUID getSecretId(){
        return secretId;
    }


    public void setSecretId(){
        secretId = UUID.randomUUID();
    }

    /**
     * @param userId owner of the secret to set
     */
    public void setOwner(String userId){
        owner = userId;
    }

    /**
     * @param userId shared user of the secret to set
     */
    public void addSharedUser(String userId){
        sharedList.add(userId);
    }

    /**
     * @param targetUserId user of the secret to unshare
     */
    public void removeSharedUser(String targetUserId){
        sharedList.remove(targetUserId);
    }

}
