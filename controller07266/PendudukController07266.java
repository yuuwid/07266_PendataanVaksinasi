package controller07266;

import core07266.Controller;
import entity07266.PendudukEntity07266;
import model07266.PendudukModel07266;

import java.util.ArrayList;

public class PendudukController07266 extends Controller {

    public int insertData(PendudukEntity07266 pendudukEntity){
        return model(PendudukModel07266.class).insertData(pendudukEntity);
    }

    public int updateData(PendudukEntity07266 pendudukEntity){
        return model(PendudukModel07266.class).updateData(pendudukEntity);
    }

    public int deleteData(PendudukEntity07266 pendudukEntity){
        return model(PendudukModel07266.class).deleteData(pendudukEntity);
    }

    public ArrayList<PendudukEntity07266> getData(){
        return model(PendudukModel07266.class).getData();
    }

    public ArrayList<PendudukEntity07266> getData(String key, Object value, String option){
        return model(PendudukModel07266.class).getData(key, value, option);
    }

    public ArrayList<PendudukEntity07266> getData(String key, Object value){
        return getData(key, value, "=");
    }

}
