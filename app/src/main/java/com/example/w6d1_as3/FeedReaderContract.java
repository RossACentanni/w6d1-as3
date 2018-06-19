package com.example.w6d1_as3;

import android.provider.BaseColumns;

public final class FeedReaderContract {
    public FeedReaderContract(){}

    public static abstract class FeedEntry implements BaseColumns{
        public static final String TABLE_NAME = "news";
        public static final String COLUMN_NAME_ENTRY_ID = "news_id";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_SUBTITLE = "subtitle";
    }
}
