package top.vchao.lib.utils;

import android.Manifest;
import android.text.TextUtils;
import android.widget.EditText;

import top.vchao.lib.permission.annotation.NeedPermission;

/**
 * @ description：EditText 工具类
 * @ author: vchao
 * @ blog: http://vchao.blog.csdn.net
 */
public class EditTextUtils {
    /**
     * 检查 EditText 是否为空
     *
     * @return 空 true   非空 false
     */
    public static boolean isEmpty(EditText et) {
        if (et != null) {
            String s = et.getText().toString();
            return TextUtils.isEmpty(s);
        }
        return true;
    }

    /**
     * 获取文本框内容
     *
     * @return 文本内容
     */
    public static String getText(EditText et) {
        if (!isEmpty(et)) {
            return et.getText().toString().trim();
        }
        return "";
    }

    /**
     * 判断是否所有 EditText 内容都不为空
     *
     * @param editTexts 待验证的 EditText 列表
     * @return 是否全部非空
     */
    public static boolean isAllNotNull(EditText... editTexts) {
        for (EditText editText : editTexts) {
            if (isEmpty(editText)) {
                return false;
            }
        }
        return true;
    }

}
