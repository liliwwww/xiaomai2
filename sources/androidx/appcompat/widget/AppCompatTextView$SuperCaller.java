package androidx.appcompat.widget;

import android.view.textclassifier.TextClassifier;
import androidx.annotation.Nullable;
import androidx.annotation.Px;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface AppCompatTextView$SuperCaller {
    int getAutoSizeMaxTextSize();

    int getAutoSizeMinTextSize();

    int getAutoSizeStepGranularity();

    int[] getAutoSizeTextAvailableSizes();

    int getAutoSizeTextType();

    TextClassifier getTextClassifier();

    void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4);

    void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i);

    void setAutoSizeTextTypeWithDefaults(int i);

    void setFirstBaselineToTopHeight(@Px int i);

    void setLastBaselineToBottomHeight(@Px int i);

    void setTextClassifier(@Nullable TextClassifier textClassifier);
}
