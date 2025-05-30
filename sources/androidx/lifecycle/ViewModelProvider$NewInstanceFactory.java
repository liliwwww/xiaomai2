package androidx.lifecycle;

import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.CreationExtras$Key;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.j56;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class ViewModelProvider$NewInstanceFactory implements ViewModelProvider.Factory {

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @JvmField
    @NotNull
    public static final CreationExtras$Key<String> VIEW_MODEL_KEY = new CreationExtras$Key<String>() { // from class: androidx.lifecycle.ViewModelProvider$NewInstanceFactory$Companion$ViewModelKeyImpl
    };

    @Nullable
    private static ViewModelProvider$NewInstanceFactory sInstance;

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP})
    @NotNull
    public static final ViewModelProvider$NewInstanceFactory getInstance() {
        return Companion.getInstance();
    }

    @NotNull
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        try {
            T newInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            Intrinsics.checkNotNullExpressionValue(newInstance, "{\n                modelC…wInstance()\n            }");
            return newInstance;
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Cannot create an instance of " + cls, e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("Cannot create an instance of " + cls, e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("Cannot create an instance of " + cls, e3);
        }
    }

    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return j56.b(this, cls, creationExtras);
    }
}
