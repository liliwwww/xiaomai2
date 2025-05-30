package androidx.appcompat.widget;

import android.view.textclassifier.TextClassifier;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(api = 28)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class AppCompatTextView$SuperCallerApi28 extends AppCompatTextView$SuperCallerApi26 {
    final /* synthetic */ AppCompatTextView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AppCompatTextView$SuperCallerApi28(final AppCompatTextView appCompatTextView) {
        new AppCompatTextView$SuperCaller() { // from class: androidx.appcompat.widget.AppCompatTextView$SuperCallerApi26
            @Override // androidx.appcompat.widget.AppCompatTextView$SuperCaller
            public int getAutoSizeMaxTextSize() {
                return AppCompatTextView.access$001(appCompatTextView);
            }

            @Override // androidx.appcompat.widget.AppCompatTextView$SuperCaller
            public int getAutoSizeMinTextSize() {
                return AppCompatTextView.access$101(appCompatTextView);
            }

            @Override // androidx.appcompat.widget.AppCompatTextView$SuperCaller
            public int getAutoSizeStepGranularity() {
                return AppCompatTextView.access$201(appCompatTextView);
            }

            @Override // androidx.appcompat.widget.AppCompatTextView$SuperCaller
            public int[] getAutoSizeTextAvailableSizes() {
                return AppCompatTextView.access$301(appCompatTextView);
            }

            @Override // androidx.appcompat.widget.AppCompatTextView$SuperCaller
            public int getAutoSizeTextType() {
                return AppCompatTextView.access$401(appCompatTextView);
            }

            @Override // androidx.appcompat.widget.AppCompatTextView$SuperCaller
            public TextClassifier getTextClassifier() {
                return AppCompatTextView.access$501(appCompatTextView);
            }

            @Override // androidx.appcompat.widget.AppCompatTextView$SuperCaller
            public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
                AppCompatTextView.access$601(appCompatTextView, i, i2, i3, i4);
            }

            @Override // androidx.appcompat.widget.AppCompatTextView$SuperCaller
            public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
                AppCompatTextView.access$701(appCompatTextView, iArr, i);
            }

            @Override // androidx.appcompat.widget.AppCompatTextView$SuperCaller
            public void setAutoSizeTextTypeWithDefaults(int i) {
                AppCompatTextView.access$801(appCompatTextView, i);
            }

            @Override // androidx.appcompat.widget.AppCompatTextView$SuperCaller
            public void setFirstBaselineToTopHeight(int i) {
            }

            @Override // androidx.appcompat.widget.AppCompatTextView$SuperCaller
            public void setLastBaselineToBottomHeight(int i) {
            }

            @Override // androidx.appcompat.widget.AppCompatTextView$SuperCaller
            public void setTextClassifier(@Nullable TextClassifier textClassifier) {
                AppCompatTextView.access$901(appCompatTextView, textClassifier);
            }
        };
        this.this$0 = appCompatTextView;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView$SuperCallerApi26, androidx.appcompat.widget.AppCompatTextView$SuperCaller
    public void setFirstBaselineToTopHeight(@Px int i) {
        AppCompatTextView.access$1001(this.this$0, i);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView$SuperCallerApi26, androidx.appcompat.widget.AppCompatTextView$SuperCaller
    public void setLastBaselineToBottomHeight(@Px int i) {
        AppCompatTextView.access$1101(this.this$0, i);
    }
}
