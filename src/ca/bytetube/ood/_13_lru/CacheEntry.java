package ca.bytetube.ood._13_lru;

public interface CacheEntry<V> {
    V getValue();

    void setValue(V value);

    long getLastAccessTime();

    void updateLastAccessTime();
}
