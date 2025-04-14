package com.flantechtree.common.data;

import java.util.*;

public class TechTree {
    private final String name;
    private final Map<String, List<TechNode>> sections = new HashMap<>();

    public TechTree(String name) {
        this.name = name;
    }

    public void addNode(String section, TechNode node) {
        sections.computeIfAbsent(section.toLowerCase(), k -> new ArrayList<>()).add(node);
    }

    public List<TechNode> getSection(String section) {
        return sections.getOrDefault(section.toLowerCase(), Collections.emptyList());
    }

    public Set<String> getSections() {
        return sections.keySet();
    }

    public String getName() {
        return name;
    }

    public Map<String, List<TechNode>> getAllSections() {
        return sections;
    }
}