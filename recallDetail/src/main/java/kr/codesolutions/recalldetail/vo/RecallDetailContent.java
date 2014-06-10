package kr.codesolutions.recalldetail.vo;


import android.util.Log;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jinmo on 2014-05-28.
 */
public class RecallDetailContent extends BaseVo {
    private  String model;
    private  String recallNationType;
    private  String harmCause;
    private  String makeTerm1;
    private  String makeTerm2;
    private  String makeAmount;
    private  String serialNumber;
    private  String accidentExam;
    private  String actionTerm1;
    private  String confirmUID;
    private  String recallMeans;
    private  String recallState;
    private  String importCompany;
    private  String actionTerm2;
    private  String linkID;
    private  String harmLevel;
    private  String makingNation;
    private  String recallActionVol;
    private  String harmContents;
    private  String closeCheck;
    private  String recallType;
    private  String sellAmount;
    private  String sellTerm1;
    private  String sellTerm2;
    private  String companyName;
    private  String rc_req_No;
    private  String recallAction;
    private  String publicDate;
    private  String trademark;
    private  String productContents;
    private  String saleCompany;
    private  String linkURL;
    private  String recallAmount;
    private  String productName;
    private  String harmFlawInfo;
    private  String actions;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRecallNationType() {
        return recallNationType;
    }

    public void setRecallNationType(String recallNationType) {
        this.recallNationType = recallNationType;
    }

    public String getHarmCause() {
        return harmCause;
    }

    public void setHarmCause(String harmCause) {
        this.harmCause = harmCause;
    }

    public String getMakeTerm1() {
        return makeTerm1;
    }

    public void setMakeTerm1(String makeTerm1) {
        this.makeTerm1 = makeTerm1;
    }

    public String getMakeTerm2() {
        return makeTerm2;
    }

    public void setMakeTerm2(String makeTerm2) {
        this.makeTerm2 = makeTerm2;
    }

    public String getMakeAmount() {
        return makeAmount;
    }

    public void setMakeAmount(String makeAmount) {
        this.makeAmount = makeAmount;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getAccidentExam() {
        return accidentExam;
    }

    public void setAccidentExam(String accidentExam) {
        this.accidentExam = accidentExam;
    }

    public String getActionTerm1() {
        return actionTerm1;
    }

    public void setActionTerm1(String actionTerm1) {
        this.actionTerm1 = actionTerm1;
    }

    public String getConfirmUID() {
        return confirmUID;
    }

    public void setConfirmUID(String confirmUID) {
        this.confirmUID = confirmUID;
    }

    public String getRecallMeans() {
        return recallMeans;
    }

    public void setRecallMeans(String recallMeans) {
        this.recallMeans = recallMeans;
    }

    public String getRecallState() {
        return recallState;
    }

    public void setRecallState(String recallState) {
        this.recallState = recallState;
    }

    public String getImportCompany() {
        return importCompany;
    }

    public void setImportCompany(String importCompany) {
        this.importCompany = importCompany;
    }

    public String getActionTerm2() {
        return actionTerm2;
    }

    public void setActionTerm2(String actionTerm2) {
        this.actionTerm2 = actionTerm2;
    }

    public String getLinkID() {
        return linkID;
    }

    public void setLinkID(String linkID) {
        this.linkID = linkID;
    }

    public String getHarmLevel() {
        return harmLevel;
    }

    public void setHarmLevel(String harmLevel) {
        this.harmLevel = harmLevel;
    }

    public String getMakingNation() {
        return makingNation;
    }

    public void setMakingNation(String makingNation) {
        this.makingNation = makingNation;
    }

    public String getRecallActionVol() {
        return recallActionVol;
    }

    public void setRecallActionVol(String recallActionVol) {
        this.recallActionVol = recallActionVol;
    }

    public String getHarmContents() {
        return harmContents;
    }

    public void setHarmContents(String harmContents) {
        this.harmContents = harmContents;
    }

    public String getCloseCheck() {
        return closeCheck;
    }

    public void setCloseCheck(String closeCheck) {
        this.closeCheck = closeCheck;
    }

    public String getRecallType() {
        return recallType;
    }

    public void setRecallType(String recallType) {
        this.recallType = recallType;
    }

    public String getSellAmount() {
        return sellAmount;
    }

    public void setSellAmount(String sellAmount) {
        this.sellAmount = sellAmount;
    }

    public String getSellTerm1() {
        return sellTerm1;
    }

    public void setSellTerm1(String sellTerm1) {
        this.sellTerm1 = sellTerm1;
    }

    public String getSellTerm2() {
        return sellTerm2;
    }

    public void setSellTerm2(String sellTerm2) {
        this.sellTerm2 = sellTerm2;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRc_req_No() {
        return rc_req_No;
    }

    public void setRc_req_No(String rc_req_No) {
        this.rc_req_No = rc_req_No;
    }

    public String getRecallAction() {
        return recallAction;
    }

    public void setRecallAction(String recallAction) {
        this.recallAction = recallAction;
    }

    public String getPublicDate() {
        return publicDate;
    }

    public void setPublicDate(String publicDate) {
        this.publicDate = publicDate;
    }

    public String getTrademark() {
        return trademark;
    }

    public void setTrademark(String trademark) {
        this.trademark = trademark;
    }

    public String getProductContents() {
        return productContents;
    }

    public void setProductContents(String productContents) {
        this.productContents = productContents;
    }

    public String getSaleCompany() {
        return saleCompany;
    }

    public void setSaleCompany(String saleCompany) {
        this.saleCompany = saleCompany;
    }

    public String getLinkURL() {
        return linkURL;
    }

    public void setLinkURL(String linkURL) {
        this.linkURL = linkURL;
    }

    public String getRecallAmount() {
        return recallAmount;
    }

    public void setRecallAmount(String recallAmount) {
        this.recallAmount = recallAmount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getHarmFlawInfo() {
        return harmFlawInfo;
    }

    public void setHarmFlawInfo(String harmFlawInfo) {
        this.harmFlawInfo = harmFlawInfo;
    }

    public String getActions() {
        return actions;
    }

    public void setActions(String actions) {
        this.actions = actions;
    }

    public static List<String> getList(){
        List<String> result =  new ArrayList<String>();
        Class<RecallDetailContent> cls = RecallDetailContent.class;
        Field[] declaredFields = cls.getDeclaredFields();
        for(Field declaredField:declaredFields){
            result.add(new String(declaredField.getName()));
        }
        return result;
    }


}
