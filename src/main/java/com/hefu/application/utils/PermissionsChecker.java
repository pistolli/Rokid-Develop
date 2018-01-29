package com.hefu.application.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;
import android.util.Log;

/**
 * 检查权限的工具类
 * <p/>
 * Created by wangchenlong on 16/1/26.
 */
public class PermissionsChecker {
    private final Context mContext;

    public PermissionsChecker(Context context) {
        mContext = context.getApplicationContext();
    }

    // 判断权限集合
    public boolean lacksPermissions(String... permissions) {
        for (String permission : permissions) {
            if (lacksPermission(permission)) {
                return true;
            }
        }
        return false;
    }

    // 判断是否缺少权限
    private boolean lacksPermission(String permission) {

        if(!(ContextCompat.checkSelfPermission(mContext, permission) ==
                PackageManager.PERMISSION_DENIED))
        Log.e("有权限",permission);
        else {
            Log.e("无权限",permission);
        }
    //PERMISSION_DENIED 无权限 PackageManager.PERMISSION_GRANTED 有权限
        return ContextCompat.checkSelfPermission(mContext, permission) ==
                PackageManager.PERMISSION_DENIED;
    }


}
