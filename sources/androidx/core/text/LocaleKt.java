package androidx.core.text;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@SuppressLint({"ClassVerificationFailure"})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class LocaleKt {
    @RequiresApi(17)
    public static final int getLayoutDirection(@NotNull Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "<this>");
        return TextUtils.getLayoutDirectionFromLocale(locale);
    }
}
