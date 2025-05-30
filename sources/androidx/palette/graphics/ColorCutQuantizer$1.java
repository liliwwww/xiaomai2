package androidx.palette.graphics;

import java.util.Comparator;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ColorCutQuantizer$1 implements Comparator<ColorCutQuantizer$Vbox> {
    ColorCutQuantizer$1() {
    }

    @Override // java.util.Comparator
    public int compare(ColorCutQuantizer$Vbox colorCutQuantizer$Vbox, ColorCutQuantizer$Vbox colorCutQuantizer$Vbox2) {
        return colorCutQuantizer$Vbox2.getVolume() - colorCutQuantizer$Vbox.getVolume();
    }
}
