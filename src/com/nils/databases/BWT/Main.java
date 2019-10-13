package com.nils.databases.BWT;

public class Main {

    public static void main(String[] args)  throws Exception {
        BurrowsWheelerTransformHelper bwt = new BurrowsWheelerTransformHelper();
        String a = bwt.retransform("ard$rcaaaabb");
        String b =bwt.retransform(bwt.transform("Rindfleischetikettierungsueberwachungsaufgabenuebertragungsgesetz$"));
        String c =bwt.retransform(bwt.transform("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaiohdsp<gispiodu v9iefhzu9hzweu9fh seuihdfuish<puasd       fhx9$"));
    }
}
