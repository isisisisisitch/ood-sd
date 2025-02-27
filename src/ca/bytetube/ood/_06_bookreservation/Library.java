package ca.bytetube.ood._06_bookreservation;

import java.util.List;

public class Library {
    private ResourceManager manager;

    public Library() {
        manager = new ResourceManager();
    }

    public Resource getResource(String resourceId){
        return manager.getResource(resourceId);
    }

    public void addResource(Resource resource) {
        manager.addResource(resource);
    }

    public List<Resource> search(String keyword) {
        return  manager.search(keyword);
    }

    public boolean reserve(String resourceId, String userId) {

        return  manager.reserve(resourceId,userId);
    }

    public void release(String resourceId, String userId) {
        manager.release(resourceId,userId);
    }
}
