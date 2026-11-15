class UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean union(int x1, int x2) {
        int p1 = find(x1);
        int p2 = find(x2);
        if (p1 == p2) {
            return false;
        }
        if (rank[p1] > rank[p2]) {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }
        return true;
    }
}

class Solution {
    /*
    list[0] = name
    list[1-n] = emails

    intuition:
    - merge accounts under these conditions:
        - same eamil in the List
    - a person can have any number of accounts initially, but all of their accounts definitely have the same name
        - duplications, set or check key to filter out
    
    - the emails need to be in sorted order after the merge

    -> Use the disjoint set, create disjoint sets and merge the parents
    -> assign each account an id, uniotn accounts that share the same email

    */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        UnionFind uf = new UnionFind(n);
        Map<String, Integer> emailToAcc = new HashMap<>();

        for(int i = 0; i < n; i++){
            List<String> account = accounts.get(i);
            for(int j = 1; j < account.size(); j++){
                String email = account.get(j);
                if(emailToAcc.containsKey(email)){
                    uf.union(i, emailToAcc.get(email));
                } else {
                    emailToAcc.put(email, i);
                }
            }
        }

        Map<Integer, List<String>> emailGroup = new HashMap<>();
        for (Map.Entry<String, Integer> entry : emailToAcc.entrySet()) {
            String email = entry.getKey();
            int accId = entry.getValue();
            int leader = uf.find(accId);
            emailGroup.putIfAbsent(leader, new ArrayList<>());
            emailGroup.get(leader).add(email);
        }

        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<Integer, List<String>> entry : emailGroup.entrySet()){
            int accId = entry.getKey();
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            List<String> merged = new ArrayList<>();
            merged.add(accounts.get(accId).get(0));
            merged.addAll(emails);
            res.add(merged);
        }

        return res;
    }
}