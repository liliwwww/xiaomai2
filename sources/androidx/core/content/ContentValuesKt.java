package androidx.core.content;

import android.content.ContentValues;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class ContentValuesKt {
    @NotNull
    public static final ContentValues contentValuesOf(@NotNull Pair<String, ? extends Object>... pairArr) {
        Intrinsics.checkNotNullParameter(pairArr, "pairs");
        ContentValues contentValues = new ContentValues(pairArr.length);
        for (Pair<String, ? extends Object> pair : pairArr) {
            String str = (String) pair.component1();
            Object component2 = pair.component2();
            if (component2 == null) {
                contentValues.putNull(str);
            } else if (component2 instanceof String) {
                contentValues.put(str, (String) component2);
            } else if (component2 instanceof Integer) {
                contentValues.put(str, (Integer) component2);
            } else if (component2 instanceof Long) {
                contentValues.put(str, (Long) component2);
            } else if (component2 instanceof Boolean) {
                contentValues.put(str, (Boolean) component2);
            } else if (component2 instanceof Float) {
                contentValues.put(str, (Float) component2);
            } else if (component2 instanceof Double) {
                contentValues.put(str, (Double) component2);
            } else if (component2 instanceof byte[]) {
                contentValues.put(str, (byte[]) component2);
            } else if (component2 instanceof Byte) {
                contentValues.put(str, (Byte) component2);
            } else {
                if (!(component2 instanceof Short)) {
                    throw new IllegalArgumentException("Illegal value type " + component2.getClass().getCanonicalName() + " for key \"" + str + '\"');
                }
                contentValues.put(str, (Short) component2);
            }
        }
        return contentValues;
    }
}
