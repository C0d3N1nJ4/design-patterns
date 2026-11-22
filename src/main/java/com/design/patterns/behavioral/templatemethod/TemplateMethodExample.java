package com.design.patterns.behavioral.templatemethod;

import java.util.Objects;

/** Fixed report generation algorithm with format-specific steps. */
public final class TemplateMethodExample {
    private TemplateMethodExample() {
    }

    public abstract static class ReportExporter {
        public final String export(String content) {
            if (content == null || content.isBlank()) {
                throw new IllegalArgumentException("content must not be blank");
            }
            return header() + format(content) + footer();
        }

        protected abstract String header();

        protected abstract String format(String content);

        protected String footer() {
            return "";
        }
    }

    public static final class CsvExporter extends ReportExporter {
        @Override
        protected String header() {
            return "value\n";
        }

        @Override
        protected String format(String content) {
            return "\"" + content.replace("\"", "\"\"") + "\"\n";
        }
    }

    public static final class HtmlExporter extends ReportExporter {
        @Override
        protected String header() {
            return "<html>";
        }

        @Override
        protected String format(String content) {
            return "<p>" + content.replace("&", "&amp;").replace("<", "&lt;")
                    .replace(">", "&gt;") + "</p>";
        }

        @Override
        protected String footer() {
            return "</html>";
        }
    }
}
