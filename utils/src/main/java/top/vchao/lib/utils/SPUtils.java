package top.vchao.lib.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import java.util.Map;


/**
 * @ description：SharedPreferences 保存工具类
 * @ author: vchao
 */
public class SPUtils {
    public static String SpName = "vchaosp";  // sp 文件名称
    public static String DEFAULT = "";// 默认 当sp中无该键值内容时返回

    //  保存值
    public static void save(Context context, String key, String value) {
        LogUtils.i(key + " ---  save  ---" + value);
        SharedPreferences mySharedPreferences = context.getSharedPreferences(SpName,
                Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = mySharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    //删除
    public static void delete(Context context, String key) {
        SharedPreferences mySharedPreferences = context.getSharedPreferences(SpName,
                Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = mySharedPreferences.edit();
        editor.putString(key, DEFAULT);
        editor.apply();
        LogUtils.i(" --- delete --- " + key);
    }

    //查看
    public static String look(Context context, String key) {
        return look(context, key, DEFAULT);
    }

    //查看
    public static String look(Context context, String key, String default_key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SpName,
                Activity.MODE_PRIVATE);
        String data = sharedPreferences.getString(key, default_key);
        LogUtils.i("  --- getValue ---  " + key + "  =  " + data);
        return data;
    }

    //删除全部
    public static void deleteAll(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(SpName, Activity.MODE_PRIVATE);
        preferences.edit().clear().apply();
        LogUtils.i("  --- deleteAll ---  sp ");
    }

    /**
     * 判断本地是否存储该值。
     * 有值 ====   true
     * 无值  ====  false
     *
     * @param value
     * @return
     */
    public static boolean isHave(Context context, String value) {
        if (!TextUtils.isEmpty(value)) {
            String look = SPUtils.look(context, value);
            if (!TextUtils.isEmpty(look) && (!DEFAULT.equals(look))) {
                return true;
            }
        }
        return false;
    }

    /**
     * 根据值获取存储的键名
     */
    public static String getKeyByValue(Context context, String value, String default_value) {
        SharedPreferences spf = context.getSharedPreferences(SpName, Activity.MODE_PRIVATE);
        Map<String, ?> key_Value = (Map<String, ?>) spf.getAll(); //获取所有保存在对应标识下的数据，并以Map形式返回

        /* 只需遍历即可得到存储的key和value值*/
        for (Map.Entry<String, ?> entry : key_Value.entrySet()) {
            try {
                if (TextUtils.equals(look(context, entry.getKey()), value)) {
                    LogUtils.i(" --- getKeyByValue ---   " + entry.getValue() + " 对应的键值为  " + entry.getKey());
                    return entry.getKey();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return default_value;
    }

}
