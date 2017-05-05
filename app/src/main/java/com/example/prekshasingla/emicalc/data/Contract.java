package com.example.prekshasingla.emicalc.data;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by prekshasingla on 05/05/17.
 */
public class Contract {

    public static final String CONTENT_AUTHORITY = "com.example.prekshasingla.emicalc.app";

    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);


    public static final String PATH_EMIDB = "EMIDB";


    public static final class EMIEntry implements BaseColumns {

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_EMIDB).build();

        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_EMIDB;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_EMIDB;

        // Table name
        public static final String TABLE_NAME = "emiData";

        public static final String COLUMN_USERID = "userid";
        public static final String COLUMN_PRINCIPALAMOUNT = "principalamount";
        public static final String COLUMN_TENURE = "trenure";
        public static final String COLUMN_TIMESTAMP = "timestamp";



        public static Uri buildEMIUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }


}
