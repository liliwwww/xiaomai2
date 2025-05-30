package androidx.core.app;

import android.app.RemoteInput;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.RemoteInput;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: Taobao */
@RequiresApi(20)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class RemoteInput$Api20Impl {
    private RemoteInput$Api20Impl() {
    }

    @DoNotInline
    static void addResultsToIntent(Object obj, Intent intent, Bundle bundle) {
        RemoteInput.addResultsToIntent((RemoteInput[]) obj, intent, bundle);
    }

    public static RemoteInput fromCompat(RemoteInput remoteInput) {
        Set allowedDataTypes;
        RemoteInput.Builder addExtras = new RemoteInput.Builder(remoteInput.getResultKey()).setLabel(remoteInput.getLabel()).setChoices(remoteInput.getChoices()).setAllowFreeFormInput(remoteInput.getAllowFreeFormInput()).addExtras(remoteInput.getExtras());
        if (Build.VERSION.SDK_INT >= 26 && (allowedDataTypes = remoteInput.getAllowedDataTypes()) != null) {
            Iterator it = allowedDataTypes.iterator();
            while (it.hasNext()) {
                RemoteInput.Api26Impl.setAllowDataType(addExtras, (String) it.next(), true);
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            RemoteInput.Api29Impl.setEditChoicesBeforeSending(addExtras, remoteInput.getEditChoicesBeforeSending());
        }
        return addExtras.build();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.core.app.RemoteInput$Builder] */
    static RemoteInput fromPlatform(Object obj) {
        Set allowedDataTypes;
        android.app.RemoteInput remoteInput = (android.app.RemoteInput) obj;
        final String resultKey = remoteInput.getResultKey();
        RemoteInput$Builder addExtras = new Object(resultKey) { // from class: androidx.core.app.RemoteInput$Builder
            private CharSequence[] mChoices;
            private CharSequence mLabel;
            private final String mResultKey;
            private final Set<String> mAllowedDataTypes = new HashSet();
            private final Bundle mExtras = new Bundle();
            private boolean mAllowFreeFormTextInput = true;
            private int mEditChoicesBeforeSending = 0;

            {
                if (resultKey == null) {
                    throw new IllegalArgumentException("Result key can't be null");
                }
                this.mResultKey = resultKey;
            }

            @NonNull
            public RemoteInput$Builder addExtras(@NonNull Bundle bundle) {
                if (bundle != null) {
                    this.mExtras.putAll(bundle);
                }
                return this;
            }

            @NonNull
            public RemoteInput build() {
                return new RemoteInput(this.mResultKey, this.mLabel, this.mChoices, this.mAllowFreeFormTextInput, this.mEditChoicesBeforeSending, this.mExtras, this.mAllowedDataTypes);
            }

            @NonNull
            public Bundle getExtras() {
                return this.mExtras;
            }

            @NonNull
            public RemoteInput$Builder setAllowDataType(@NonNull String str, boolean z) {
                if (z) {
                    this.mAllowedDataTypes.add(str);
                } else {
                    this.mAllowedDataTypes.remove(str);
                }
                return this;
            }

            @NonNull
            public RemoteInput$Builder setAllowFreeFormInput(boolean z) {
                this.mAllowFreeFormTextInput = z;
                return this;
            }

            @NonNull
            public RemoteInput$Builder setChoices(@Nullable CharSequence[] charSequenceArr) {
                this.mChoices = charSequenceArr;
                return this;
            }

            @NonNull
            public RemoteInput$Builder setEditChoicesBeforeSending(int i) {
                this.mEditChoicesBeforeSending = i;
                return this;
            }

            @NonNull
            public RemoteInput$Builder setLabel(@Nullable CharSequence charSequence) {
                this.mLabel = charSequence;
                return this;
            }
        }.setLabel(remoteInput.getLabel()).setChoices(remoteInput.getChoices()).setAllowFreeFormInput(remoteInput.getAllowFreeFormInput()).addExtras(remoteInput.getExtras());
        if (Build.VERSION.SDK_INT >= 26 && (allowedDataTypes = RemoteInput.Api26Impl.getAllowedDataTypes(remoteInput)) != null) {
            Iterator it = allowedDataTypes.iterator();
            while (it.hasNext()) {
                addExtras.setAllowDataType((String) it.next(), true);
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            addExtras.setEditChoicesBeforeSending(RemoteInput.Api29Impl.getEditChoicesBeforeSending(remoteInput));
        }
        return addExtras.build();
    }

    @DoNotInline
    static Bundle getResultsFromIntent(Intent intent) {
        return android.app.RemoteInput.getResultsFromIntent(intent);
    }
}
