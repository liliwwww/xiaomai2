package androidx.emoji2.text;

import androidx.emoji2.text.MetadataRepo;
import java.util.Arrays;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class EmojiProcessor$ProcessorSm {
    private static final int STATE_DEFAULT = 1;
    private static final int STATE_WALKING = 2;
    private int mCurrentDepth;
    private MetadataRepo.Node mCurrentNode;
    private final int[] mEmojiAsDefaultStyleExceptions;
    private MetadataRepo.Node mFlushNode;
    private int mLastCodepoint;
    private final MetadataRepo.Node mRootNode;
    private int mState = 1;
    private final boolean mUseEmojiAsDefaultStyle;

    EmojiProcessor$ProcessorSm(MetadataRepo.Node node, boolean z, int[] iArr) {
        this.mRootNode = node;
        this.mCurrentNode = node;
        this.mUseEmojiAsDefaultStyle = z;
        this.mEmojiAsDefaultStyleExceptions = iArr;
    }

    private static boolean isEmojiStyle(int i) {
        return i == 65039;
    }

    private static boolean isTextStyle(int i) {
        return i == 65038;
    }

    private int reset() {
        this.mState = 1;
        this.mCurrentNode = this.mRootNode;
        this.mCurrentDepth = 0;
        return 1;
    }

    private boolean shouldUseEmojiPresentationStyleForSingleCodepoint() {
        if (this.mCurrentNode.getData().isDefaultEmoji() || isEmojiStyle(this.mLastCodepoint)) {
            return true;
        }
        if (this.mUseEmojiAsDefaultStyle) {
            if (this.mEmojiAsDefaultStyleExceptions == null) {
                return true;
            }
            if (Arrays.binarySearch(this.mEmojiAsDefaultStyleExceptions, this.mCurrentNode.getData().getCodepointAt(0)) < 0) {
                return true;
            }
        }
        return false;
    }

    int check(int i) {
        MetadataRepo.Node node = this.mCurrentNode.get(i);
        int i2 = 3;
        if (this.mState == 2) {
            if (node != null) {
                this.mCurrentNode = node;
                this.mCurrentDepth++;
            } else if (isTextStyle(i)) {
                i2 = reset();
            } else if (!isEmojiStyle(i)) {
                if (this.mCurrentNode.getData() == null) {
                    i2 = reset();
                } else if (this.mCurrentDepth != 1) {
                    this.mFlushNode = this.mCurrentNode;
                    reset();
                } else if (shouldUseEmojiPresentationStyleForSingleCodepoint()) {
                    this.mFlushNode = this.mCurrentNode;
                    reset();
                } else {
                    i2 = reset();
                }
            }
            i2 = 2;
        } else if (node == null) {
            i2 = reset();
        } else {
            this.mState = 2;
            this.mCurrentNode = node;
            this.mCurrentDepth = 1;
            i2 = 2;
        }
        this.mLastCodepoint = i;
        return i2;
    }

    TypefaceEmojiRasterizer getCurrentMetadata() {
        return this.mCurrentNode.getData();
    }

    TypefaceEmojiRasterizer getFlushMetadata() {
        return this.mFlushNode.getData();
    }

    boolean isInFlushableState() {
        return this.mState == 2 && this.mCurrentNode.getData() != null && (this.mCurrentDepth > 1 || shouldUseEmojiPresentationStyleForSingleCodepoint());
    }
}
