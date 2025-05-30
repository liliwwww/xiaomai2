package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.collection.ArrayMap;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class AnimatedVectorDrawableCompat$AnimatedVectorDrawableCompatState extends Drawable.ConstantState {
    AnimatorSet mAnimatorSet;
    ArrayList<Animator> mAnimators;
    int mChangingConfigurations;
    ArrayMap<Animator, String> mTargetNameMap;
    VectorDrawableCompat mVectorDrawable;

    public AnimatedVectorDrawableCompat$AnimatedVectorDrawableCompatState(Context context, AnimatedVectorDrawableCompat$AnimatedVectorDrawableCompatState animatedVectorDrawableCompat$AnimatedVectorDrawableCompatState, Drawable.Callback callback, Resources resources) {
        if (animatedVectorDrawableCompat$AnimatedVectorDrawableCompatState != null) {
            this.mChangingConfigurations = animatedVectorDrawableCompat$AnimatedVectorDrawableCompatState.mChangingConfigurations;
            VectorDrawableCompat vectorDrawableCompat = animatedVectorDrawableCompat$AnimatedVectorDrawableCompatState.mVectorDrawable;
            if (vectorDrawableCompat != null) {
                Drawable.ConstantState constantState = vectorDrawableCompat.getConstantState();
                if (resources != null) {
                    this.mVectorDrawable = constantState.newDrawable(resources);
                } else {
                    this.mVectorDrawable = constantState.newDrawable();
                }
                VectorDrawableCompat mutate = this.mVectorDrawable.mutate();
                this.mVectorDrawable = mutate;
                mutate.setCallback(callback);
                this.mVectorDrawable.setBounds(animatedVectorDrawableCompat$AnimatedVectorDrawableCompatState.mVectorDrawable.getBounds());
                this.mVectorDrawable.setAllowCaching(false);
            }
            ArrayList<Animator> arrayList = animatedVectorDrawableCompat$AnimatedVectorDrawableCompatState.mAnimators;
            if (arrayList != null) {
                int size = arrayList.size();
                this.mAnimators = new ArrayList<>(size);
                this.mTargetNameMap = new ArrayMap<>(size);
                for (int i = 0; i < size; i++) {
                    Animator animator = animatedVectorDrawableCompat$AnimatedVectorDrawableCompatState.mAnimators.get(i);
                    Animator clone = animator.clone();
                    String str = (String) animatedVectorDrawableCompat$AnimatedVectorDrawableCompatState.mTargetNameMap.get(animator);
                    clone.setTarget(this.mVectorDrawable.getTargetByName(str));
                    this.mAnimators.add(clone);
                    this.mTargetNameMap.put(clone, str);
                }
                setupAnimatorSet();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        return this.mChangingConfigurations;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        throw new IllegalStateException("No constant state support for SDK < 24.");
    }

    public void setupAnimatorSet() {
        if (this.mAnimatorSet == null) {
            this.mAnimatorSet = new AnimatorSet();
        }
        this.mAnimatorSet.playTogether(this.mAnimators);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources) {
        throw new IllegalStateException("No constant state support for SDK < 24.");
    }
}
