package kr.codesolutions.landlord.db;

public final class DataBases {

    public static final class Tenant {
        public static final String _ID = "_id";
        public static final String NAME = "name";
        public static final String SMS_KEY_WORD = "smsKeyWord";
        public static final String PRICE = "price";
        public static final String ADDRESS = "address";
        public static final String _TABLENAME = "tenant";
        public static final String _CREATE =
                "create table "+_TABLENAME+"("
                        +_ID+" integer primary key autoincrement, "
                        +NAME+" text not null , "
                        +SMS_KEY_WORD+" text not null , "
                        +PRICE+" text not null , "
                        +ADDRESS+" text null );";
    }
}
