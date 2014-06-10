package kr.codesolutions.recalldetail.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.preference.MultiSelectListPreference;

import kr.codesolutions.recalldetail.vo.ModelQueryField;
import kr.codesolutions.recalldetail.vo.MultiSelectVo;

public class AppLauncherApplication extends Application {
	

	public static String[] searchQueryShowFieldNameList = null;
    public static boolean[] searchQueryShowFieldCheckedList = null;
    public static List<String> searchQueryShowFieldCheckedNameList = new ArrayList<String>();
    public static ArrayList<MultiSelectVo> searchQueryShowFieldList = new ArrayList<MultiSelectVo>();

    static {
        addSearchQueryShowFieldList("harmLevel","위해수준",false);
        addSearchQueryShowFieldList("harmCause","위해원인",false);
        addSearchQueryShowFieldList("harmFlawInfo","위해 결함정보",false);
        addSearchQueryShowFieldList("recallAction","리콜조치원인",false);
        addSearchQueryShowFieldList("recallMeans","리콜방법",false);
        addSearchQueryShowFieldList("publicDate","공표일자",false);
        addSearchQueryShowFieldList("makeTerm1","제조기간1",false);
        addSearchQueryShowFieldList("makeTerm2","제조기간2",false);
        addSearchQueryShowFieldList("sellTerm1","판매기간1",false);
        addSearchQueryShowFieldList("sellTerm2","판매기간2",false);
        addSearchQueryShowFieldList("actionTerm1","조치기간1",false);
        addSearchQueryShowFieldList("actionTerm2","조치기간2",false);
        addSearchQueryShowFieldList("makeAmount","제조수량",false);
        addSearchQueryShowFieldList("sellAmount","판매수량",false);
        addSearchQueryShowFieldList("recallActionVol","리콜수량",false);
        addSearchQueryShowFieldList("saleCompany","판매업체",false);
        addSearchQueryShowFieldList("importCompany","수입업체",false);
        addSearchQueryShowFieldList("linkURL","이미지 링크",false);
        addSearchQueryShowFieldList("linkID","이미지 고유번호",false);
        addSearchQueryShowFieldList("closeCheck","종결여부",false);
        addSearchQueryShowFieldList("productName","제품명",false);
        addSearchQueryShowFieldList("trademark","상표",false);
        addSearchQueryShowFieldList("model","모델명",false);
        addSearchQueryShowFieldList("serialNumber","일련번호",false);
        addSearchQueryShowFieldList("makingNation","제조국",false);
        addSearchQueryShowFieldList("recallState","리콜 상태",false);
        addSearchQueryShowFieldList("actions","조치사항",false);
        addSearchQueryShowFieldList("productContents","제품상세내용",false);
        addSearchQueryShowFieldList("recallAmount","판매수량",false);
        addSearchQueryShowFieldList("harmContents","위해내용",false);
        addSearchQueryShowFieldList("accidentExam","사고사례",false);
        addSearchQueryShowFieldList("rc_req_No","리콜 제품 id",false);
        addSearchQueryShowFieldList("recallNationType","리콜형태",false);
        addSearchQueryShowFieldList("confirmUID","인증번호UID",false);
        addSearchQueryShowFieldList("recallType","리콜종류",false);
        addSearchQueryShowFieldList("companyName","제보사업자명",false);
    }

    private static void addSearchQueryShowFieldList(String value,String label,boolean selected) {
        MultiSelectVo vo = new MultiSelectVo();
        vo.setValue(value);
        vo.setLabel(label);
        vo.setSelected(selected);
        searchQueryShowFieldList.add(vo);
    }

    @Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
	}

	@Override
	public void onCreate() {
		super.onCreate();
	}

	@Override
	public void onLowMemory() {
		super.onLowMemory();
	}

	@Override
	public void onTerminate() {
		super.onTerminate();
	}
	
	
}
