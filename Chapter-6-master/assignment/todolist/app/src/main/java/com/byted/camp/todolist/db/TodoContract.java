package com.byted.camp.todolist.db;

import android.provider.BaseColumns;

import com.byted.camp.todolist.operation.db.FeedReaderContract;

/**
 * Created on 2019/1/22.
 *
 * @author xuyingyi@bytedance.com (Yingyi Xu)
 */
public final class TodoContract {

    // TODO 定义表结构和 SQL 语句常量
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TodoContract.TodoEntry.TABLE_NAME + " (" +
                    TodoContract.TodoEntry._ID + " INTEGER PRIMARY KEY," +
                    TodoEntry.COLUMN_NAME_Content + " TEXT," +
                    TodoEntry.COLUMN_NAME_STATE + " INT," +
                    TodoContract.TodoEntry.COLUMN_NAME_TIMESTAMP + " TEXT)";

    public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + TodoEntry.TABLE_NAME;


    private TodoContract() {
    }

    public static class TodoEntry implements BaseColumns {

        public static final String TABLE_NAME = "todo";

        public static final String COLUMN_NAME_Content = "content";

        public static final String COLUMN_NAME_TIMESTAMP = "timestamp";

        public  static final String COLUMN_NAME_STATE = "state";
    }

}
