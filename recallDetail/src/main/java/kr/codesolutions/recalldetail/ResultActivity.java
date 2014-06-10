package kr.codesolutions.recalldetail;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import kr.codesolutions.recalldetail.adapter.RecallDetailContentListAdapter;
import kr.codesolutions.recalldetail.common.AppLauncherApplication;
import kr.codesolutions.recalldetail.common.Const;
import kr.codesolutions.recalldetail.http.HttpClient;
import kr.codesolutions.recalldetail.vo.RecallDetail;
import kr.codesolutions.recalldetail.vo.RequestModelQueryPageable;
import kr.codesolutions.recalldetail.vo.RequestModelQueryPageableSortOrders;


public class ResultActivity extends ActionBarActivity {

    ListView listView;
    RecallDetailContentListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        listView = (ListView) findViewById(R.id.listViews);
        listAdapter =  new RecallDetailContentListAdapter(getApplicationContext(),R.layout.adapter_retail_list);
        listView.setAdapter(listAdapter);
        Gson gson = new Gson();
        RequestModelQueryPageable pageQuery = new RequestModelQueryPageable();
        List sortOrders = new ArrayList<RequestModelQueryPageableSortOrders>();
        RequestModelQueryPageableSortOrders sortOrder = new RequestModelQueryPageableSortOrders();
        sortOrder.setDirection(1);
        sortOrder.setProperty("linkID");
        sortOrders.add(sortOrder);
        pageQuery.setEnable(true);
        pageQuery.setPageNumber(2);
        pageQuery.setPageSize(2);
        pageQuery.setSortOrders(sortOrders);

        String result = gson.toJson(pageQuery);
        Log.d(Const.TAG, "pageQuery="+result);
        RequestParams params = new RequestParams();
        params.put("model_query_pageable", result);
        Map<String,Integer> modelQueryFields = new HashMap<String, Integer>();
        for (int i = 0; i < AppLauncherApplication.searchQueryShowFieldNameList.length; i++) {
            if (AppLauncherApplication.searchQueryShowFieldCheckedList[i]) {
                modelQueryFields.put(AppLauncherApplication.searchQueryShowFieldNameList[i],1);
            }
        }
        String model_query_fieldsresult = gson.toJson(modelQueryFields);
        Log.d(Const.TAG, "model_query_fields="+model_query_fieldsresult);
        params.put("model_query_fields", model_query_fieldsresult);
        HttpClient.get(params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(String content) {
                super.onSuccess(content);
                Log.d(Const.TAG, "content=" + content);
                Gson gson = new Gson();
                RecallDetail result = gson.fromJson(content, new TypeToken<RecallDetail>() {
                }.getType());
                Log.d(Const.TAG, "content=" + result.getContent().get(0).getHarmLevel());
                listAdapter.setData(result.getContent());
            }

        });
        Log.d(Const.TAG, "333333333333");


    }

}
