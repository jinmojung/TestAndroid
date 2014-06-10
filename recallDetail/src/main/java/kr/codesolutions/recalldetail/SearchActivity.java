package kr.codesolutions.recalldetail;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

import kr.codesolutions.recalldetail.adapter.MultiSelectAdapter;
import kr.codesolutions.recalldetail.common.AppLauncherApplication;
import kr.codesolutions.recalldetail.common.Const;
import kr.codesolutions.recalldetail.vo.MultiSelectVo;


public class SearchActivity extends ActionBarActivity {

    EditText modelQueryFields;
    Button searchBtn;
    Spinner modelQueryDistinct;
    ListView listView;
    AlertDialog.Builder builder;

    private DialogInterface.OnClickListener mOnClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            // build new spinner text & delimiter management
            boolean isOneMoreChecked = false;
            StringBuffer spinnerBuffer = new StringBuffer();
            AppLauncherApplication.searchQueryShowFieldCheckedNameList.clear();
            for (int i = 0; i < AppLauncherApplication.searchQueryShowFieldNameList.length; i++) {
                if (AppLauncherApplication.searchQueryShowFieldCheckedList[i]) {
                    spinnerBuffer.append(AppLauncherApplication.searchQueryShowFieldNameList[i]);
                    spinnerBuffer.append(", ");
                    AppLauncherApplication.searchQueryShowFieldCheckedNameList.add(AppLauncherApplication.searchQueryShowFieldNameList[i]);
                    isOneMoreChecked = true;
                }
            }

            // Remove trailing comma
            if (isOneMoreChecked) {
                spinnerBuffer.setLength(spinnerBuffer.length() - 2);
                modelQueryFields.setText("출력 필드="+spinnerBuffer.toString());
            }else{
                modelQueryFields.setText("");
            }

            // hide dialog
            dialog.dismiss();
        }
    };

    private DialogInterface.OnMultiChoiceClickListener mOnMultiChoiceClickListener = new DialogInterface.OnMultiChoiceClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
            AppLauncherApplication.searchQueryShowFieldCheckedList[which] = isChecked;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        if(AppLauncherApplication.searchQueryShowFieldNameList == null){
            AppLauncherApplication.searchQueryShowFieldNameList = getResources().getStringArray(R.array.recallDetailContent);
            if (AppLauncherApplication.searchQueryShowFieldNameList != null) {
                AppLauncherApplication.searchQueryShowFieldCheckedList = new boolean[AppLauncherApplication.searchQueryShowFieldNameList.length]; // false-filled by default
            }
        }
        listView = (ListView) getLayoutInflater().inflate(R.layout.alert_multiselect_list,null);
        ArrayAdapter<MultiSelectVo> adapter = new ArrayAdapter<MultiSelectVo>(SearchActivity.this,
                android.R.layout.simple_list_item_multiple_choice, AppLauncherApplication.searchQueryShowFieldList);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setAdapter(adapter);
        builder = new AlertDialog.Builder(SearchActivity.this)
                .setTitle("출력 필드 선택11")
                .setView(listView)
                .setPositiveButton(android.R.string.ok, mOnClickListener);
//        SharedPreferences prefs = getSharedPreferences("modelQueryFields", MODE_PRIVATE);
//        SharedPreferences.Editor ed = prefs.edit();
//        ed.putString("gmailID", "snazzy7979");
//        ed.putString("gmailPWD", "pwd12345");
//        ed.commit();
//
//        String gmailID = prefs.getString("gmailID", "");
//        String gmailPWD = prefs.getString("gmailPWD", "");
//        Log.d(Const.TAG, "gmailID" + gmailID);
//        Log.d(Const.TAG, "gmailPWD" + gmailPWD);
        //modelQueryFields = (Spinner)findViewById(R.id.modelQueryFields);
//        String[] company = getResources().getStringArray(R.array.recallDetailContent);
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_multichoice, company);
//        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
//        modelQueryFields.setAdapter(adapter);
//        Class<RecallDetailContent> cls = RecallDetailContent.class;
//        Field[] declaredFields = cls.getDeclaredFields();
//        for(Field declaredField:declaredFields){
//        }
//
//        List<String> list = RecallDetailContent.getList();
//
//
//        for(String st:list){
//            Log.i("test1122", "sdfds"+st);
//        }
        modelQueryFields = (EditText)findViewById(R.id.modelQueryFields);
        searchBtn = (Button)findViewById(R.id.searchBtn);
        modelQueryFields.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewGroup listViewParent = (ViewGroup)listView.getParent();
                if(listViewParent != null){
                    listViewParent.removeView(listView);
                }
                listView.setItemChecked(0,true);
                builder.show();
            }
        });

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SearchActivity.this, ResultActivity.class));
            }
        });

    }

}
