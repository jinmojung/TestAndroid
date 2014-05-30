package kr.codesolutions.landlord;

import android.content.IntentFilter;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.List;

import kr.codesolutions.landlord.adapter.TenantListAdapter;
import kr.codesolutions.landlord.common.Const;
import kr.codesolutions.landlord.db.DbOpenHelper;
import kr.codesolutions.landlord.receiver.SmsReceiver;
import kr.codesolutions.landlord.vo.Tenant;


public class SettingActivity extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(Const.TAG,"SettingActivity");
        addPreferencesFromResource(R.xml.setting);
    }
}
