package com.nils.databases.BWT;

import javafx.util.Pair;

public class BurrowsString {


    private BurrowsWheelerTransformHelper BWT;
    private String _burrowsString;
    private boolean _isBurrows = false;
    private int endPosition = -1;

    public BurrowsString(String inputString){
        BWT = new BurrowsWheelerTransformHelper();
        SetString(inputString);
        _isBurrows = false;
    }
    public BurrowsString(String inputString, boolean isBurrows){
        BWT = new BurrowsWheelerTransformHelper();
        SetString(inputString);
        _isBurrows = isBurrows;
    }

    public String GetString(){
        return _burrowsString;
    }

    private void SetString(String string){
        _burrowsString = string;
    }

    public String GetBurrowsString() throws Exception{
        if (!_isBurrows) transform();
        return GetString();
    }

    public void transform() throws Exception{
        if (_isBurrows){

        }else {
            Pair<String, Integer> bwtPair = BWT.encode(GetString());
            SetString(bwtPair.getKey());
            endPosition = bwtPair.getValue();
            _isBurrows = true;
        }
    }

}
