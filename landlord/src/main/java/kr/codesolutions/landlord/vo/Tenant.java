package kr.codesolutions.landlord.vo;

public class Tenant {

    private String name;
    private String smsKeyWord;
    private String price;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSmsKeyWord() {
        return smsKeyWord;
    }

    public void setSmsKeyWord(String smsKeyWord) {
        this.smsKeyWord = smsKeyWord;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
