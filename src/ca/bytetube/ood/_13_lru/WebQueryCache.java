package ca.bytetube.ood._13_lru;

public class WebQueryCache {
    Cache<String, String> cache;

    public WebQueryCache(int capacity) {
        this.cache = new LRUCache<>(capacity);
    }

    public String getQueryResult(String query) {
        String result = cache.get(query);
        if (result == null) {
            //第一次执行，无条件执行正常的query语句
            result = executeQuery(query);
            cache.put(query, result);
        }

        return result;
    }

    private String executeQuery(String query) {
        //实际执行query查询，调用服务完成query
        return "Result for query:" + query;
    }

}
