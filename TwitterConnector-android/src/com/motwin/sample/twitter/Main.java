package com.motwin.sample.twitter;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.motwin.android.exception.ExceptionContainer;
import com.motwin.android.streamdata.ContinuousQueryController;
import com.motwin.android.streamdata.ContinuousQueryController.Callback;
import com.motwin.android.streamdata.ContinuousQueryController.SyncStatus;
import com.motwin.android.streamdata.Query;

public class Main extends DefaultActivity {

    private static final String       QUERY_STRING = "SELECT * FROM Tweets ORDER BY date DESC LIMIT 50";

    private ContinuousQueryController continuousQueryController;
    private CursorAdapter             adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, null, new String[] {
                M.Tweets.USER_SCREEN_NAME, M.Tweets.TEXT }, new int[] { android.R.id.text1, android.R.id.text2 });

        ListView listView;
        listView = (ListView) findViewById(R.id.listView);

        listView.setAdapter(adapter);

        continuousQueryController = MotwinFacade.getContinuousQueryFactory().newContinuousQueryController(
                new Query(QUERY_STRING));
        continuousQueryController.addListener(new Callback() {

            @Override
            public void continuousQuerySyncStatusChanged(ContinuousQueryController aQueryController,
                                                         SyncStatus aSyncStatus) {
                // TODO handle status changed here. For instance :
                // - show / hide spinning wheel

            }

            @Override
            public void continuousQueryDataChanged(ContinuousQueryController aQueryController, Cursor aQueryData) {
                // TODO handle new data. For instance :
                adapter.changeCursor(aQueryData);
                // WARNING : aQueryData can be null if no data available.

            }

            @Override
            public void continuousQueryExceptionCaught(ContinuousQueryController aArg0, ExceptionContainer aArg1) {
                // TODO handle exception throws by continuous query

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        // start the continuous query when activity is displayed
        continuousQueryController.start();
    }

    @Override
    protected void onPause() {
        super.onPause();

        // stop the continuous query when activity is no longer visible
        continuousQueryController.stop();
    }
}