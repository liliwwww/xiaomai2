package androidx.core.graphics;

import android.graphics.Color;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import java.util.Objects;

/* compiled from: Taobao */
@RequiresApi(26)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ColorUtils$Api26Impl {
    private ColorUtils$Api26Impl() {
    }

    @DoNotInline
    static Color compositeColors(Color color, Color color2) {
        if (!Objects.equals(color.getModel(), color2.getModel())) {
            throw new IllegalArgumentException("Color models must match (" + color.getModel() + " vs. " + color2.getModel() + ")");
        }
        if (!Objects.equals(color2.getColorSpace(), color.getColorSpace())) {
            color = color.convert(color2.getColorSpace());
        }
        float[] components = color.getComponents();
        float[] components2 = color2.getComponents();
        float alpha = color.alpha();
        float alpha2 = color2.alpha() * (1.0f - alpha);
        int componentCount = color2.getComponentCount() - 1;
        components2[componentCount] = alpha + alpha2;
        if (components2[componentCount] > 0.0f) {
            alpha /= components2[componentCount];
            alpha2 /= components2[componentCount];
        }
        for (int i = 0; i < componentCount; i++) {
            components2[i] = (components[i] * alpha) + (components2[i] * alpha2);
        }
        return Color.valueOf(components2, color2.getColorSpace());
    }
}
