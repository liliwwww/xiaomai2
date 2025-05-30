package androidx.compose.ui.tooling;

import android.util.Log;
import androidx.compose.ui.tooling.preview.PreviewParameterProvider;
import java.lang.reflect.Constructor;
import java.util.Iterator;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class PreviewUtilsKt {
    @Nullable
    public static final Class<? extends PreviewParameterProvider<?>> asPreviewProviderClass(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            Log.e("PreviewProvider", "Unable to find provider '" + str + '\'', e);
            return null;
        }
    }

    @NotNull
    public static final Object[] getPreviewProviderParameters(@Nullable Class<? extends PreviewParameterProvider<?>> cls, int i) {
        if (cls == null) {
            return new Object[0];
        }
        try {
            Constructor<?>[] constructors = cls.getConstructors();
            Intrinsics.checkNotNullExpressionValue(constructors, "parameterProviderClass.constructors");
            int length = constructors.length;
            Constructor<?> constructor = null;
            Constructor<?> constructor2 = null;
            int i2 = 0;
            boolean z = false;
            while (true) {
                if (i2 < length) {
                    Constructor<?> constructor3 = constructors[i2];
                    Class<?>[] parameterTypes = constructor3.getParameterTypes();
                    Intrinsics.checkNotNullExpressionValue(parameterTypes, "it.parameterTypes");
                    if (parameterTypes.length == 0) {
                        if (z) {
                            break;
                        }
                        constructor2 = constructor3;
                        z = true;
                    }
                    i2++;
                } else if (z) {
                    constructor = constructor2;
                }
            }
            Constructor<?> constructor4 = constructor;
            if (constructor4 == null) {
                throw new IllegalArgumentException("PreviewParameterProvider constructor can not have parameters");
            }
            constructor4.setAccessible(true);
            Object newInstance = constructor4.newInstance(new Object[0]);
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type androidx.compose.ui.tooling.preview.PreviewParameterProvider<*>");
            PreviewParameterProvider previewParameterProvider = (PreviewParameterProvider) newInstance;
            return i < 0 ? toArray(previewParameterProvider.getValues(), previewParameterProvider.getCount()) : new Object[]{SequencesKt.elementAt(previewParameterProvider.getValues(), i)};
        } catch (KotlinReflectionNotSupportedError unused) {
            throw new IllegalStateException("Deploying Compose Previews with PreviewParameterProvider arguments requires adding a dependency to the kotlin-reflect library.\nConsider adding 'debugImplementation \"org.jetbrains.kotlin:kotlin-reflect:$kotlin_version\"' to the module's build.gradle.");
        }
    }

    private static final Object[] toArray(Sequence<? extends Object> sequence, int i) {
        Iterator it = sequence.iterator();
        Object[] objArr = new Object[i];
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = it.next();
        }
        return objArr;
    }
}
