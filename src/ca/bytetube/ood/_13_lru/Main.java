package ca.bytetube.ood._13_lru;

public class Main {
    public static void main(String[] args) {
//        testWebQueryCache();
        testGenericLRUCache();
    }

    public static void testWebQueryCache() {
        WebQueryCache queryCache = new WebQueryCache(2);

        System.out.println("query 1 result:" + queryCache.getQueryResult("select * from users"));
        System.out.println("query 2 result:" + queryCache.getQueryResult("select * from orders"));
        System.out.println("query 1  again result:" + queryCache.getQueryResult("select * from users"));

        System.out.println("query 3 result:" + queryCache.getQueryResult("select * from products"));
        System.out.println();

    }

    private static void testGenericLRUCache() {
        System.out.println("=== Testing Generic LRU Cache ===");
        Cache<Integer, String> cache = new LRUCache<>(3);


        System.out.println("Adding entries to cache...");
        cache.put(1, "One");
        cache.put(2, "Two");
        cache.put(3, "Three");

        System.out.println("Cache size: " + cache.size());
        System.out.println("Get 1: " + cache.get(1));
        System.out.println("Get 2: " + cache.get(2));
        System.out.println("Get 3: " + cache.get(3));


        System.out.println("\nTesting LRU functionality...");
        System.out.println("Adding 4 (should evict 1)...");
        cache.put(4, "Four");

        System.out.println("Get 1 (should be null): " + cache.get(1));
        System.out.println("Get 2: " + cache.get(2));
        System.out.println("Get 3: " + cache.get(3));
        System.out.println("Get 4: " + cache.get(4));

        System.out.println("==============================================================");

        System.out.println("\nTesting update...");
        cache.put(2, "Two Updated");
        System.out.println("Get 2 (should be updated): " + cache.get(2));


        System.out.println("\nTesting remove...");
        cache.remove(3);
        System.out.println("Get 3 (should be null): " + cache.get(3));
        System.out.println("Cache size: " + cache.size());


        System.out.println("\nTesting clear...");
        cache.clear();
        System.out.println("Cache size after clear: " + cache.size());
    }
}
