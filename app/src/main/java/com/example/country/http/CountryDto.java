package com.example.country.http;

import com.google.gson.annotations.SerializedName;

public class CountryDto {
    @SerializedName("cca2")
    private String code;
    private Name name;
    private Flags flags;

    public static class Name {
        private String common;
        private String official;

        public String getCommon() {
            return common;
        }

        public String getOfficial() {
            return official;
        }
    }

    public static class Flags {
        private String svg;
        private String png;
        public String alt;

        public String getSvg() {
            return svg;
        }

        public String getPng() {
            return png;
        }

        public String getAlt() {
            return alt;
        }
    }

    public String getCode() {
        return code;
    }

    public Name getName() {
        return name;
    }

    public Flags getFlags() {
        return flags;
    }
}
