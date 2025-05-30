package androidx.emoji2.text;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.provider.FontRequest;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.DefaultEmojiCompatConfig;
import androidx.emoji2.text.EmojiCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class DefaultEmojiCompatConfig$DefaultEmojiCompatConfigFactory {

    @NonNull
    private static final String DEFAULT_EMOJI_QUERY = "emojicompat-emoji-font";

    @NonNull
    private static final String INTENT_LOAD_EMOJI_FONT = "androidx.content.action.LOAD_EMOJI_FONT";

    @NonNull
    private static final String TAG = "emoji2.text.DefaultEmojiConfig";
    private final DefaultEmojiCompatConfig.DefaultEmojiCompatConfigHelper mHelper;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public DefaultEmojiCompatConfig$DefaultEmojiCompatConfigFactory(@Nullable DefaultEmojiCompatConfig.DefaultEmojiCompatConfigHelper defaultEmojiCompatConfigHelper) {
        this.mHelper = defaultEmojiCompatConfigHelper == null ? getHelperForApi() : defaultEmojiCompatConfigHelper;
    }

    @Nullable
    private EmojiCompat.Config configOrNull(@NonNull Context context, @Nullable FontRequest fontRequest) {
        if (fontRequest == null) {
            return null;
        }
        return new FontRequestEmojiCompatConfig(context, fontRequest);
    }

    @NonNull
    private List<List<byte[]>> convertToByteArray(@NonNull Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return Collections.singletonList(arrayList);
    }

    @NonNull
    private FontRequest generateFontRequestFrom(@NonNull ProviderInfo providerInfo, @NonNull PackageManager packageManager) throws PackageManager.NameNotFoundException {
        String str = providerInfo.authority;
        String str2 = providerInfo.packageName;
        return new FontRequest(str, str2, DEFAULT_EMOJI_QUERY, convertToByteArray(this.mHelper.getSigningSignatures(packageManager, str2)));
    }

    @NonNull
    private static DefaultEmojiCompatConfig.DefaultEmojiCompatConfigHelper getHelperForApi() {
        int i = Build.VERSION.SDK_INT;
        return i >= 28 ? new DefaultEmojiCompatConfig.DefaultEmojiCompatConfigHelper_API28() : i >= 19 ? new DefaultEmojiCompatConfig.DefaultEmojiCompatConfigHelper_API19() : new DefaultEmojiCompatConfig.DefaultEmojiCompatConfigHelper();
    }

    private boolean hasFlagSystem(@Nullable ProviderInfo providerInfo) {
        ApplicationInfo applicationInfo;
        return (providerInfo == null || (applicationInfo = providerInfo.applicationInfo) == null || (applicationInfo.flags & 1) != 1) ? false : true;
    }

    @Nullable
    private ProviderInfo queryDefaultInstalledContentProvider(@NonNull PackageManager packageManager) {
        Iterator it = this.mHelper.queryIntentContentProviders(packageManager, new Intent(INTENT_LOAD_EMOJI_FONT), 0).iterator();
        while (it.hasNext()) {
            ProviderInfo providerInfo = this.mHelper.getProviderInfo((ResolveInfo) it.next());
            if (hasFlagSystem(providerInfo)) {
                return providerInfo;
            }
        }
        return null;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public EmojiCompat.Config create(@NonNull Context context) {
        return configOrNull(context, queryForDefaultFontRequest(context));
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting
    FontRequest queryForDefaultFontRequest(@NonNull Context context) {
        PackageManager packageManager = context.getPackageManager();
        Preconditions.checkNotNull(packageManager, "Package manager required to locate emoji font provider");
        ProviderInfo queryDefaultInstalledContentProvider = queryDefaultInstalledContentProvider(packageManager);
        if (queryDefaultInstalledContentProvider == null) {
            return null;
        }
        try {
            return generateFontRequestFrom(queryDefaultInstalledContentProvider, packageManager);
        } catch (PackageManager.NameNotFoundException e) {
            Log.wtf(TAG, e);
            return null;
        }
    }
}
