package androidx.fragment.app;

import androidx.lifecycle.Lifecycle;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
/* synthetic */ class FragmentStateManager$2 {
    static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$State;

    static {
        int[] iArr = new int[Lifecycle.State.values().length];
        $SwitchMap$androidx$lifecycle$Lifecycle$State = iArr;
        try {
            iArr[Lifecycle.State.RESUMED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            $SwitchMap$androidx$lifecycle$Lifecycle$State[Lifecycle.State.STARTED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            $SwitchMap$androidx$lifecycle$Lifecycle$State[Lifecycle.State.CREATED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            $SwitchMap$androidx$lifecycle$Lifecycle$State[Lifecycle.State.INITIALIZED.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
