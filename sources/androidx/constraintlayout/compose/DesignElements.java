package androidx.constraintlayout.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J@\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022)\u0010\b\u001a%\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\u0004\b\t\u0010\nRQ\u0010\u000b\u001a1\u0012\u0004\u0012\u00020\u0002\u0012'\u0012%\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u00070\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Landroidx/constraintlayout/compose/DesignElements;", "", "", "name", "Lkotlin/Function2;", "Ljava/util/HashMap;", "", "Landroidx/compose/runtime/Composable;", "function", "define", "(Ljava/lang/String;Lkotlin/jvm/functions/Function4;)V", "map", "Ljava/util/HashMap;", "getMap", "()Ljava/util/HashMap;", "setMap", "(Ljava/util/HashMap;)V", "<init>", "()V", "compose_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class DesignElements {

    @NotNull
    public static final DesignElements INSTANCE = new DesignElements();

    @NotNull
    private static HashMap<String, Function4<String, HashMap<String, String>, Composer, Integer, Unit>> map = new HashMap<>();
    public static final int $stable = 8;

    private DesignElements() {
    }

    public final void define(@NotNull String name, @NotNull Function4<? super String, ? super HashMap<String, String>, ? super Composer, ? super Integer, Unit> function) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(function, "function");
        map.put(name, function);
    }

    @NotNull
    public final HashMap<String, Function4<String, HashMap<String, String>, Composer, Integer, Unit>> getMap() {
        return map;
    }

    public final void setMap(@NotNull HashMap<String, Function4<String, HashMap<String, String>, Composer, Integer, Unit>> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
        map = hashMap;
    }
}
