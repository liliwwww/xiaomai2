package androidx.activity.result.contract;

import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@RequiresApi(18)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ActivityResultContracts$GetMultipleContents$Companion {
    private ActivityResultContracts$GetMultipleContents$Companion() {
    }

    public /* synthetic */ ActivityResultContracts$GetMultipleContents$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public final List<Uri> getClipDataUris$activity_release(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Uri data = intent.getData();
        if (data != null) {
            linkedHashSet.add(data);
        }
        ClipData clipData = intent.getClipData();
        if (clipData == null && linkedHashSet.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        if (clipData != null) {
            int itemCount = clipData.getItemCount();
            for (int i = 0; i < itemCount; i++) {
                Uri uri = clipData.getItemAt(i).getUri();
                if (uri != null) {
                    linkedHashSet.add(uri);
                }
            }
        }
        return new ArrayList(linkedHashSet);
    }
}
