package ca.bytetube.ood._05_linkedin;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AccountRegister {

    Map<Account, Map<Account, Status>> relationships = new HashMap<>();

    public Account createAccount(String name) {
        Account newUser = new Account(relationships.size(), name);
        Map<Account, Status> tmpMap = new HashMap<>();
        relationships.put(newUser, tmpMap);
        return newUser;
    }

    public void addRelationship(Account accountA, Account accountB, Status first, Status second) {
        Map<Account, Status> relationshipB = relationships.get(accountB);
        Map<Account, Status> relationshipA = relationships.get(accountA);
        relationshipA.put(accountB, first);
        relationshipB.put(accountA, second);
        relationships.put(accountA, relationshipA);
        relationships.put(accountB, relationshipB);
    }

    public Account findAccount(int userId) {
        Account ans = null;

        for (Map.Entry<Account, Map<Account, Status>> entry : relationships.entrySet()) {
            if (entry.getKey().getUserId() == userId) {
                ans = entry.getKey();
                break;
            }
        }
        return ans;
    }
}
