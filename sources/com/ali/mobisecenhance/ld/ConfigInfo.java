package com.ali.mobisecenhance.ld;

import com.j2c.enhance.SoLoad992979061;

/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class ConfigInfo {
    public String applicationName;
    public String runMode;
    public String timeStamp;
    public boolean isTestMode = false;
    public boolean isReleaseMode = false;

    static {
        SoLoad992979061.loadJ2CSo("cn.damai_shell_alijtca_plus", ConfigInfo.class);
    }

    public static native ConfigInfo getConfigInfo(String str, String str2);

    public native String toString();
}
