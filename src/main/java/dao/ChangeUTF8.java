package dao;

import java.io.UnsupportedEncodingException;

/**
 * Created by ASUS on 2018/7/18.
 */
public class ChangeUTF8 {
    public static String changeUTF8(String str){
        if (str==null) return null;
        String tmp = null;
        try {
            tmp = new String(str.getBytes("iso-8859-1"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return tmp;
    }
}
