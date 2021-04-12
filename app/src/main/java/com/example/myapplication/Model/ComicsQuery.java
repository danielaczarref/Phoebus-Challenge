package com.example.myapplication.Model;

import android.text.format.DateUtils;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

public class ComicsQuery {

    private String format;
    private boolean noVariants;
    private String date;
    private String title;
    private int digitalId;
    private int issueNumber;
    private int limit;
    private int offset;

    ComicsQuery(String format, boolean noVariants,
                String date, String title, int digitalId, int issueNumber,
                int limit, int offset) {
        this.format = format;
        this.noVariants = noVariants;
        this.date = date;
        this.title = title;
        this.digitalId = digitalId;
        this.issueNumber = issueNumber;
        this.limit = limit;
        this.offset = offset;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> returnRes = new HashMap<>();

        if (format != null) {
            returnRes.put("format", format);
        }
        if (noVariants) {
            returnRes.put("noVariants", noVariants);
        }
        if (date != null) {
            returnRes.put("date", date);
        }
        if (title != null) {
            returnRes.put("title", title);
        }
        if (digitalId > 0) {
            returnRes.put("digitalId", digitalId);
        }
        if (issueNumber > 0) {
            returnRes.put("issueNumber", issueNumber);
        }
        if (limit > 0) {
            returnRes.put("limit", limit);
        }
        if (offset > 0) {
            returnRes.put("offset", offset);
        }
        return returnRes;
    }

    @Getter
    @Setter
    public static class Builder {
        private Format format;
        private boolean noVariants;
        private String date;
        private String title;
        private int digitalId;
        private int issueNumber;
        private int limit;
        private int offset;

        public static Builder create() {
            return new Builder();
        }

        public Builder getAndSetOffset(int offset) {
            this.offset = offset;
            return this;
        }

        public Builder getAndSetLimit(int limit) {
            this.limit = limit;
            return this;
        }

        public ComicsQuery build() {
            String formatString = (format != null) ? format.toString() : null;

            return new ComicsQuery(formatString, noVariants, date, title, digitalId,
                    issueNumber, limit, offset);
        }

    }



}
