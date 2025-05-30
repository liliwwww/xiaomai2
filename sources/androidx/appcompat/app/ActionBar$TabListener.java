package androidx.appcompat.app;

import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.FragmentTransaction;

/* compiled from: Taobao */
@Deprecated
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface ActionBar$TabListener {
    void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction);

    void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction);

    void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction);
}
