package androidx.emoji2.text;

import androidx.annotation.RequiresApi;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
@RequiresApi(19)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class EmojiProcessor$CodepointIndexFinder {
    private static final int INVALID_INDEX = -1;

    private EmojiProcessor$CodepointIndexFinder() {
    }

    static int findIndexBackward(CharSequence charSequence, int i, int i2) {
        int length = charSequence.length();
        if (i < 0 || length < i || i2 < 0) {
            return -1;
        }
        while (true) {
            boolean z = false;
            while (i2 != 0) {
                i--;
                if (i < 0) {
                    return z ? -1 : 0;
                }
                char charAt = charSequence.charAt(i);
                if (z) {
                    if (!Character.isHighSurrogate(charAt)) {
                        return -1;
                    }
                    i2--;
                } else if (!Character.isSurrogate(charAt)) {
                    i2--;
                } else {
                    if (Character.isHighSurrogate(charAt)) {
                        return -1;
                    }
                    z = true;
                }
            }
            return i;
        }
    }

    static int findIndexForward(CharSequence charSequence, int i, int i2) {
        int length = charSequence.length();
        if (i < 0 || length < i || i2 < 0) {
            return -1;
        }
        while (true) {
            boolean z = false;
            while (i2 != 0) {
                if (i >= length) {
                    if (z) {
                        return -1;
                    }
                    return length;
                }
                char charAt = charSequence.charAt(i);
                if (z) {
                    if (!Character.isLowSurrogate(charAt)) {
                        return -1;
                    }
                    i2--;
                    i++;
                } else if (!Character.isSurrogate(charAt)) {
                    i2--;
                    i++;
                } else {
                    if (Character.isLowSurrogate(charAt)) {
                        return -1;
                    }
                    i++;
                    z = true;
                }
            }
            return i;
        }
    }
}
