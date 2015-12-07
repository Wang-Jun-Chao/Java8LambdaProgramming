package lambdabehave;

/**
 * Author: 王俊超
 * Date: 2015/12/7 17:04
 * All Rights Reserved !!!
 */
public final class Lets {
    public static void describe(String name, Suite behavior) {
        Description description = new Description(name);
        behavior.specifySuite(description);
    }
}
