package ca.bytetube.ood._06_bookreservation;

import java.util.*;
import java.util.stream.Collectors;

public class ResourceManager {
    private Map<String, Resource> resources;

    public ResourceManager() {
        resources = new HashMap<>();
    }

    public void addResource(Resource resource) {
        resources.put(resource.getId(), resource);
    }

    public Resource getResource(String resourceId) {

        return resources.get(resourceId);
    }

    public List<Resource> search(String keyword) {

        return resources.values().stream().filter(r -> r.getName().contains(keyword)).
                collect(Collectors.toList());
    }

    public boolean reserve(String resourceId, String userId) {
        Resource resource = resources.get(resourceId);
        if (resource == null) return false;

        synchronized (resource) {
            if (resource.getAvailableQuantity() > 0) {
                resource.setAvailableQuantity(resource.getAvailableQuantity() - 1);
                return true;
            } else {//如果没有可用的，则把用户id存入waitinglist中
                resource.getWaitingList().offer(userId);
                return false;
            }
        }

    }

    public void release(String resourceId, String userId) {
        Resource resource = resources.get(resourceId);
        if (resource == null) return;

        synchronized (resource){
            resource.setAvailableQuantity(resource.getAvailableQuantity() + 1);

            //检查waitinglist
            String nextUser = resource.getWaitingList().peek();
            if (nextUser != null && resource.getAvailableQuantity() > 0) {
                if (reserve(resourceId,nextUser)) {
                    resource.getWaitingList().poll();
                }
            }
        }

    }


}
