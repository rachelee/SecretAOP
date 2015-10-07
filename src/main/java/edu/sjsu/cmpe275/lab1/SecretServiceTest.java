package edu.sjsu.cmpe275.lab1;

/**
 * Created by xiaoxiaoli on 9/25/15.
 */


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.UUID;

public class SecretServiceTest {

    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    SecretService secretService = context.getBean(SecretService.class);
    @Before
    public void setUp() throws Exception {

    }


    @Test(expected = UnauthorizedException.class)
    public void testA() {

        System.out.println("testA");
        UUID aliceSecret = secretService.storeSecret("Alice", new Secret());
        secretService.readSecret("Bob", aliceSecret);
    }

    @Test
     public void testB(){
        System.out.println("testB");
        UUID aliceSecret = secretService.storeSecret("Alice", new Secret());
        secretService.shareSecret("Alice", aliceSecret, "Bob");
        secretService.readSecret("Bob",aliceSecret);
    }

    @Test
    public void testC(){
        System.out.println("testC");
        UUID aliceSecret = secretService.storeSecret("Alice", new Secret());
        secretService.shareSecret("Alice", aliceSecret, "Bob");
        secretService.shareSecret("Bob", aliceSecret, "Carl");
        secretService.readSecret("Carl",aliceSecret);
    }


    @Test(expected = UnauthorizedException.class)
    public void testD(){
        System.out.println("testD");
        UUID aliceSecret = secretService.storeSecret("Alice", new Secret());
        secretService.shareSecret("Alice", aliceSecret, "Bob");
        UUID carlSecret = secretService.storeSecret("Carl", new Secret());
        secretService.shareSecret("Bob", carlSecret, "Alice");
    }

    @Test(expected = UnauthorizedException.class)
    public void testE(){
        System.out.println("testE");
        UUID aliceSecret = secretService.storeSecret("Alice", new Secret());
        secretService.shareSecret("Alice", aliceSecret, "Bob");
        secretService.shareSecret("Bob", aliceSecret, "Carl");
        secretService.unshareSecret("Alice", aliceSecret, "Carl");
        secretService.readSecret("Carl", aliceSecret);
    }

    @Test(expected = UnauthorizedException.class)
    public void testF(){
        System.out.println("testF");
        UUID aliceSecret = secretService.storeSecret("Alice", new Secret());
        secretService.shareSecret("Alice", aliceSecret, "Bob");
        secretService.shareSecret("Alice", aliceSecret, "Carl");
        secretService.shareSecret("Carl", aliceSecret, "Bob");
        secretService.unshareSecret("Alice", aliceSecret, "Bob");
        secretService.readSecret("Bob", aliceSecret);
    }

    @Test(expected = UnauthorizedException.class)
    public void testG(){
        System.out.println("testG");
        UUID aliceSecret = secretService.storeSecret("Alice", new Secret());
        secretService.shareSecret("Alice", aliceSecret, "Bob");
        secretService.shareSecret("Bob", aliceSecret, "Carl");
        secretService.shareSecret("Carl", aliceSecret, "Bob");
        secretService.unshareSecret("Alice", aliceSecret, "Bob");
        secretService.readSecret("Bob", aliceSecret);
    }

    @Test(expected = UnauthorizedException.class)
    public void testH(){
        System.out.println("testH");
        UUID aliceSecret = secretService.storeSecret("Alice", new Secret());
        secretService.shareSecret("Alice", aliceSecret, "Bob");
        secretService.unshareSecret("Carl", aliceSecret, "Bob");

    }

    @Test(expected = UnauthorizedException.class)
    public void testI(){
        System.out.println("testI");
        UUID aliceSecret = secretService.storeSecret("Alice", new Secret());
        secretService.shareSecret("Alice", aliceSecret, "Bob");
        secretService.shareSecret("Bob", aliceSecret, "Carl");
        secretService.unshareSecret("Alice", aliceSecret, "Bob");
        secretService.shareSecret("Bob", aliceSecret, "Carl");
    }

    @Test
    public void testJ(){
        System.out.println("testJ");
        Secret secret = new Secret();
        UUID aliceSecret1 = secretService.storeSecret("Alice", secret);
        UUID aliceSecret2 = secretService.storeSecret("Alice", secret);
        Assert.assertNotEquals(aliceSecret1, aliceSecret2);
    }








    //...
}


