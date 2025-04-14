package com.flantechtree.common.data;

public class TechNode {
    public final String id;
    public final String displayName;
    public final int cost;
    public final String parent;

    public TechNode(String id, String displayName, int cost) {
        this(id, displayName, cost, null);
    }

    public TechNode(String id, String displayName, int cost, String parent) {
        this.id = id;
        this.displayName = displayName;
        this.cost = cost;
        this.parent = parent;
    }

    public boolean hasParent() {
        return parent != null && !parent.isEmpty();
    }
}