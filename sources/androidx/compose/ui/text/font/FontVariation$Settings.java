package androidx.compose.ui.text.font;

import androidx.compose.runtime.Immutable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class FontVariation$Settings {
    private final boolean needsDensity;

    @NotNull
    private final List<FontVariation$Setting> settings;

    public FontVariation$Settings(@NotNull FontVariation$Setting... fontVariation$SettingArr) {
        Intrinsics.checkNotNullParameter(fontVariation$SettingArr, "settings");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        boolean z = false;
        for (FontVariation$Setting fontVariation$Setting : fontVariation$SettingArr) {
            String axisName = fontVariation$Setting.getAxisName();
            Object obj = linkedHashMap.get(axisName);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(axisName, obj);
            }
            ((List) obj).add(fontVariation$Setting);
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = linkedHashMap.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                ArrayList arrayList2 = new ArrayList(arrayList);
                this.settings = arrayList2;
                int size = arrayList2.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        break;
                    }
                    if (((FontVariation$Setting) arrayList2.get(i)).getNeedsDensity()) {
                        z = true;
                        break;
                    }
                    i++;
                }
                this.needsDensity = z;
                return;
            }
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            if (!(list.size() == 1)) {
                throw new IllegalArgumentException(('\'' + str + "' must be unique. Actual [ [" + CollectionsKt.joinToString$default(list, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null) + ']').toString());
            }
            CollectionsKt.addAll(arrayList, list);
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FontVariation$Settings) && Intrinsics.areEqual(this.settings, ((FontVariation$Settings) obj).settings);
    }

    public final boolean getNeedsDensity$ui_text_release() {
        return this.needsDensity;
    }

    @NotNull
    public final List<FontVariation$Setting> getSettings() {
        return this.settings;
    }

    public int hashCode() {
        return this.settings.hashCode();
    }
}
