package androidx.emoji2.viewsintegration;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
@RequiresApi(19)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class EmojiTextViewHelper$HelperInternal19 extends EmojiTextViewHelper$HelperInternal {
    private final EmojiInputFilter mEmojiInputFilter;
    private boolean mEnabled = true;
    private final TextView mTextView;

    EmojiTextViewHelper$HelperInternal19(TextView textView) {
        this.mTextView = textView;
        this.mEmojiInputFilter = new EmojiInputFilter(textView);
    }

    @NonNull
    private InputFilter[] addEmojiInputFilterIfMissing(@NonNull InputFilter[] inputFilterArr) {
        int length = inputFilterArr.length;
        for (InputFilter inputFilter : inputFilterArr) {
            if (inputFilter == this.mEmojiInputFilter) {
                return inputFilterArr;
            }
        }
        InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length + 1];
        System.arraycopy(inputFilterArr, 0, inputFilterArr2, 0, length);
        inputFilterArr2[length] = this.mEmojiInputFilter;
        return inputFilterArr2;
    }

    private SparseArray<InputFilter> getEmojiInputFilterPositionArray(@NonNull InputFilter[] inputFilterArr) {
        SparseArray<InputFilter> sparseArray = new SparseArray<>(1);
        for (int i = 0; i < inputFilterArr.length; i++) {
            if (inputFilterArr[i] instanceof EmojiInputFilter) {
                sparseArray.put(i, inputFilterArr[i]);
            }
        }
        return sparseArray;
    }

    @NonNull
    private InputFilter[] removeEmojiInputFilterIfPresent(@NonNull InputFilter[] inputFilterArr) {
        SparseArray<InputFilter> emojiInputFilterPositionArray = getEmojiInputFilterPositionArray(inputFilterArr);
        if (emojiInputFilterPositionArray.size() == 0) {
            return inputFilterArr;
        }
        int length = inputFilterArr.length;
        InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - emojiInputFilterPositionArray.size()];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (emojiInputFilterPositionArray.indexOfKey(i2) < 0) {
                inputFilterArr2[i] = inputFilterArr[i2];
                i++;
            }
        }
        return inputFilterArr2;
    }

    @Nullable
    private TransformationMethod unwrapForDisabled(@Nullable TransformationMethod transformationMethod) {
        return transformationMethod instanceof EmojiTransformationMethod ? ((EmojiTransformationMethod) transformationMethod).getOriginalTransformationMethod() : transformationMethod;
    }

    private void updateFilters() {
        this.mTextView.setFilters(getFilters(this.mTextView.getFilters()));
    }

    @NonNull
    private TransformationMethod wrapForEnabled(@Nullable TransformationMethod transformationMethod) {
        return ((transformationMethod instanceof EmojiTransformationMethod) || (transformationMethod instanceof PasswordTransformationMethod)) ? transformationMethod : new EmojiTransformationMethod(transformationMethod);
    }

    @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper$HelperInternal
    @NonNull
    InputFilter[] getFilters(@NonNull InputFilter[] inputFilterArr) {
        return !this.mEnabled ? removeEmojiInputFilterIfPresent(inputFilterArr) : addEmojiInputFilterIfMissing(inputFilterArr);
    }

    @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper$HelperInternal
    public boolean isEnabled() {
        return this.mEnabled;
    }

    @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper$HelperInternal
    void setAllCaps(boolean z) {
        if (z) {
            updateTransformationMethod();
        }
    }

    @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper$HelperInternal
    void setEnabled(boolean z) {
        this.mEnabled = z;
        updateTransformationMethod();
        updateFilters();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    void setEnabledUnsafe(boolean z) {
        this.mEnabled = z;
    }

    @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper$HelperInternal
    void updateTransformationMethod() {
        this.mTextView.setTransformationMethod(wrapTransformationMethod(this.mTextView.getTransformationMethod()));
    }

    @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper$HelperInternal
    @Nullable
    TransformationMethod wrapTransformationMethod(@Nullable TransformationMethod transformationMethod) {
        return this.mEnabled ? wrapForEnabled(transformationMethod) : unwrapForDisabled(transformationMethod);
    }
}
