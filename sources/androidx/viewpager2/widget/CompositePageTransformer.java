package androidx.viewpager2.widget;

import android.view.View;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class CompositePageTransformer implements ViewPager2$PageTransformer {
    private final List<ViewPager2$PageTransformer> mTransformers = new ArrayList();

    public void addTransformer(@NonNull ViewPager2$PageTransformer viewPager2$PageTransformer) {
        this.mTransformers.add(viewPager2$PageTransformer);
    }

    public void removeTransformer(@NonNull ViewPager2$PageTransformer viewPager2$PageTransformer) {
        this.mTransformers.remove(viewPager2$PageTransformer);
    }

    @Override // androidx.viewpager2.widget.ViewPager2$PageTransformer
    public void transformPage(@NonNull View view, float f) {
        Iterator<ViewPager2$PageTransformer> it = this.mTransformers.iterator();
        while (it.hasNext()) {
            it.next().transformPage(view, f);
        }
    }
}
