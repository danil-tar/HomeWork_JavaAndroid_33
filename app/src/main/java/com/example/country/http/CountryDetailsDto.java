package com.example.country.http;

import java.util.List;

public class CountryDetailsDto {

    public Name name;

    public List<String> capital;

    public Integer area;
    public Integer population;
    public Flags flags;

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

}
