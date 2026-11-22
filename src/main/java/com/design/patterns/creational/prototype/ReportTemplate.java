package com.design.patterns.creational.prototype;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Prototype with defensive copies: copies may be customized independently.
 * No Cloneable or Object.clone() required.
 */
public final class ReportTemplate {
    private final String title;
    private final List<String> sections;

    public ReportTemplate(String title, List<String> sections) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title must not be blank");
        }
        Objects.requireNonNull(sections, "sections");
        if (sections.stream().anyMatch(s -> s == null || s.isBlank())) {
            throw new IllegalArgumentException("sections must be nonblank");
        }
        this.title = title;
        this.sections = new ArrayList<>(sections);
    }

    public String title() {
        return title;
    }

    public List<String> sections() {
        return List.copyOf(sections);
    }

    public void addSection(String section) {
        if (section == null || section.isBlank()) {
            throw new IllegalArgumentException("section must not be blank");
        }
        sections.add(section);
    }

    public ReportTemplate copyFor(String newTitle) {
        return new ReportTemplate(newTitle, sections);
    }

    @Override
    public String toString() {
        return "ReportTemplate[title=" + title + ", sections=" + sections + "]";
    }
}
