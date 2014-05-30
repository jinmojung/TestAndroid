package kr.codesolutions.landlord;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.provider.CalendarContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.format.Time;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import kr.codesolutions.landlord.adapter.TenantListAdapter;
import kr.codesolutions.landlord.common.Const;
import kr.codesolutions.landlord.db.DbOpenHelper;
import kr.codesolutions.landlord.receiver.SmsReceiver;
import kr.codesolutions.landlord.vo.Tenant;

import static android.provider.CalendarContract.Calendars;


public class MainActivity extends ActionBarActivity {

    EditText nameTxt, smsKeyWordTxt, priceTxt, addressTxt;
    ListView tenantListView;
    Button addBtn;
    TenantListAdapter tenantListAdapter;
    DbOpenHelper dbHelper;
    SmsReceiver smsReceiver;
    SharedPreferences defaultSharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        defaultSharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        IntentFilter intentFilter = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
        smsReceiver = new SmsReceiver();
        registerReceiver(smsReceiver, intentFilter);
        dbHelper = new DbOpenHelper(this);
        dbHelper.open();
        nameTxt = (EditText) findViewById(R.id.nameTxt);
        smsKeyWordTxt = (EditText) findViewById(R.id.smsKeyWordTxt);
        priceTxt = (EditText) findViewById(R.id.priceTxt);
        addressTxt = (EditText) findViewById(R.id.addressTxt);
        tenantListView = (ListView) findViewById(R.id.tenantListView);
        tenantListAdapter =  new TenantListAdapter(getApplicationContext(),R.layout.adapter_tenant_list);
        tenantListView.setAdapter(tenantListAdapter);
        addBtn = (Button) findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.insertColumn(nameTxt.getText().toString(),smsKeyWordTxt.getText().toString(),priceTxt.getText().toString(),addressTxt.getText().toString());
                Toast.makeText(getApplicationContext(),"regist complete",Toast.LENGTH_SHORT).show();
            }
        });


        TabHost tabHost = (TabHost)findViewById(R.id.tabHost);
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                if(tabId.equals("tenantList")){
                    List<Tenant> tenantList = dbHelper.getAllColumns();
                    tenantListAdapter.setData(tenantList);
                    Log.i(Const.TAG,"tenantList changed");
                    for (Tenant tenant:tenantList) {
                        Log.i(Const.TAG,"tenant.getName()"+ tenant.getName());
                    }
                }else if(tabId.equals("tenantAdd")){
                    Toast.makeText(getApplicationContext(),"rtenantAdd",Toast.LENGTH_SHORT).show();
                }
            }
        });
        tabHost.setup();

        TabHost.TabSpec spec = tabHost.newTabSpec("tenantList");
        spec.setContent(R.id.tenantList);
        spec.setIndicator("세입자리스트");
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("tenantAdd");
        spec.setContent(R.id.tenantAdd);
        spec.setIndicator("세입자등록");
        tabHost.addTab(spec);
        tabHost.setCurrentTab(0);
    }

    @Override
    protected void onResume() {
        super.onResume();
        boolean isOptionalMsgShown = defaultSharedPref.getBoolean("GreetingMsg", false);
        Toast.makeText(getApplicationContext(),"isOptionalMsgShown="+isOptionalMsgShown,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        Log.d(Const.TAG,"onDestroy");
        unregisterReceiver(smsReceiver);
        dbHelper.close();
        super.onDestroy();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Toast.makeText(getApplicationContext(),"rtenantAdd",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, SettingActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
