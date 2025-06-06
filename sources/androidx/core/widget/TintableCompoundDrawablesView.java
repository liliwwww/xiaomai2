package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import androidx.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface TintableCompoundDrawablesView {
    @Nullable
    ColorStateList getSupportCompoundDrawablesTintList();

    @Nullable
    PorterDuff.Mode getSupportCompoundDrawablesTintMode();

    void setSupportCompoundDrawablesTintList(@Nullable ColorStateList colorStateList);

    void setSupportCompoundDrawablesTintMode(@Nullable PorterDuff.Mode mode);
}
