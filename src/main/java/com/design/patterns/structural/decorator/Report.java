package com.design.patterns.structural.decorator;

import java.util.Objects;

/** Decorators augment report rendering without changing the wrapped report. */
public interface Report {
    String render();
}

final class PlainReport implements Report {
    private final String content;

    PlainReport(String content) {
        this.content = Objects.requireNonNull(content, "content");
    }

    @Override
    public String render() {
        return content;
    }
}

final class TimestampedReport implements Report {
    private final Report delegate;

    TimestampedReport(Report delegate) {
        this.delegate = Objects.requireNonNull(delegate, "delegate");
    }

    @Override
    public String render() {
        return "[2026-01-01] " + delegate.render();
    }
}

final class SignedReport implements Report {
    private final Report delegate;

    SignedReport(Report delegate) {
        this.delegate = Objects.requireNonNull(delegate, "delegate");
    }

    @Override
    public String render() {
        return delegate.render() + " | signed";
    }
}
