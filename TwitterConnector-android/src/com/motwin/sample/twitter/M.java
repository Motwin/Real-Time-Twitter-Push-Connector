/**
 * 
 */
package com.motwin.sample.twitter;

public final class M {
    public static final class RealTimePush {

        public static String getTableName() {
            return RealTimePush.class.getName();
        }

        public static final String   TITLE            = "title";
        public static final Class<?> CLASS_OF_TITLE   = java.lang.String.class;
        public static final String   PRICE            = "price";
        public static final Class<?> CLASS_OF_PRICE   = java.lang.Long.class;
        public static final String   PROFILE          = "profile";
        public static final Class<?> CLASS_OF_PROFILE = java.lang.Integer.class;
    }

    public static final class News {

        public static String getTableName() {
            return News.class.getName();
        }

        public static final String   ID                = "id";
        public static final Class<?> CLASS_OF_ID       = java.lang.Long.class;
        public static final String   LANGUAGE          = "language";
        public static final Class<?> CLASS_OF_LANGUAGE = java.lang.String.class;
        public static final String   TITLE             = "title";
        public static final Class<?> CLASS_OF_TITLE    = java.lang.String.class;
        public static final String   CONTENT           = "content";
        public static final Class<?> CLASS_OF_CONTENT  = java.lang.String.class;
    }

    public static final class Tweets {

        public static String getTableName() {
            return Tweets.class.getName();
        }

        public static final String   ID                        = "id";
        public static final Class<?> CLASS_OF_ID               = java.lang.Long.class;
        public static final String   DATE                      = "date";
        public static final Class<?> CLASS_OF_DATE             = java.lang.Long.class;
        public static final String   TEXT                      = "text";
        public static final Class<?> CLASS_OF_TEXT             = java.lang.String.class;
        public static final String   SOURCE                    = "source";
        public static final Class<?> CLASS_OF_SOURCE           = java.lang.String.class;
        public static final String   USER_SCREEN_NAME          = "userScreenName";
        public static final Class<?> CLASS_OF_USER_SCREEN_NAME = java.lang.String.class;
    }
}