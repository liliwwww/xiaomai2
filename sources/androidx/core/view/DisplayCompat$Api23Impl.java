package androidx.core.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.view.DisplayCompat;

/* compiled from: Taobao */
@RequiresApi(23)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class DisplayCompat$Api23Impl {
    private DisplayCompat$Api23Impl() {
    }

    @NonNull
    static DisplayCompat.ModeCompat getMode(@NonNull Context context, @NonNull Display display) {
        Display.Mode mode = display.getMode();
        Point currentDisplaySizeFromWorkarounds = DisplayCompat.getCurrentDisplaySizeFromWorkarounds(context, display);
        return (currentDisplaySizeFromWorkarounds == null || physicalSizeEquals(mode, currentDisplaySizeFromWorkarounds)) ? new DisplayCompat.ModeCompat(mode, true) : new DisplayCompat.ModeCompat(mode, currentDisplaySizeFromWorkarounds);
    }

    @NonNull
    @SuppressLint({"ArrayReturn"})
    public static DisplayCompat.ModeCompat[] getSupportedModes(@NonNull Context context, @NonNull Display display) {
        Display.Mode[] supportedModes = display.getSupportedModes();
        DisplayCompat.ModeCompat[] modeCompatArr = new DisplayCompat.ModeCompat[supportedModes.length];
        Display.Mode mode = display.getMode();
        Point currentDisplaySizeFromWorkarounds = DisplayCompat.getCurrentDisplaySizeFromWorkarounds(context, display);
        if (currentDisplaySizeFromWorkarounds == null || physicalSizeEquals(mode, currentDisplaySizeFromWorkarounds)) {
            for (int i = 0; i < supportedModes.length; i++) {
                modeCompatArr[i] = new DisplayCompat.ModeCompat(supportedModes[i], physicalSizeEquals(supportedModes[i], mode));
            }
        } else {
            for (int i2 = 0; i2 < supportedModes.length; i2++) {
                modeCompatArr[i2] = physicalSizeEquals(supportedModes[i2], mode) ? new DisplayCompat.ModeCompat(supportedModes[i2], currentDisplaySizeFromWorkarounds) : new DisplayCompat.ModeCompat(supportedModes[i2], false);
            }
        }
        return modeCompatArr;
    }

    static boolean isCurrentModeTheLargestMode(@NonNull Display display) {
        Display.Mode mode = display.getMode();
        for (Display.Mode mode2 : display.getSupportedModes()) {
            if (mode.getPhysicalHeight() < mode2.getPhysicalHeight() || mode.getPhysicalWidth() < mode2.getPhysicalWidth()) {
                return false;
            }
        }
        return true;
    }

    static boolean physicalSizeEquals(Display.Mode mode, Point point) {
        return (mode.getPhysicalWidth() == com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point) && mode.getPhysicalHeight() == com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point)) || (mode.getPhysicalWidth() == com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point) && mode.getPhysicalHeight() == com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point));
    }

    static boolean physicalSizeEquals(Display.Mode mode, Display.Mode mode2) {
        return mode.getPhysicalWidth() == mode2.getPhysicalWidth() && mode.getPhysicalHeight() == mode2.getPhysicalHeight();
    }
}
