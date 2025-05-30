package androidx.core.content.pm;

import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import java.util.List;

/* compiled from: Taobao */
@RestrictTo({RestrictTo$Scope.LIBRARY})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class ShortcutInfoCompatSaver$NoopImpl extends ShortcutInfoCompatSaver<Void> {
    public /* bridge */ /* synthetic */ Object addShortcuts(List list) {
        return m2320addShortcuts((List<ShortcutInfoCompat>) list);
    }

    /* renamed from: addShortcuts, reason: collision with other method in class */
    public Void m2320addShortcuts(List<ShortcutInfoCompat> list) {
        return null;
    }

    public Void removeAllShortcuts() {
        return null;
    }

    public /* bridge */ /* synthetic */ Object removeShortcuts(List list) {
        return m2322removeShortcuts((List<String>) list);
    }

    /* renamed from: removeShortcuts, reason: collision with other method in class */
    public Void m2322removeShortcuts(List<String> list) {
        return null;
    }
}
