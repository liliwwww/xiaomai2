package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.MotionWidget;
import tb.aq5;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class KeyCycleOscillator$CoreSpline extends KeyCycleOscillator {
    String type;
    int typeId;

    public KeyCycleOscillator$CoreSpline(String str) {
        this.type = str;
        this.typeId = aq5.a(str);
    }

    public void setProperty(MotionWidget motionWidget, float f) {
        motionWidget.setValue(this.typeId, get(f));
    }
}
