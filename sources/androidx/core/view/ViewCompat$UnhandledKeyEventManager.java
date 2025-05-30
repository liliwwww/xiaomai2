package androidx.core.view;

import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class ViewCompat$UnhandledKeyEventManager {
    private static final ArrayList<WeakReference<View>> sViewsWithListeners = new ArrayList<>();

    @Nullable
    private WeakHashMap<View, Boolean> mViewsContainingListeners = null;
    private SparseArray<WeakReference<View>> mCapturedKeys = null;
    private WeakReference<KeyEvent> mLastDispatchedPreViewKeyEvent = null;

    ViewCompat$UnhandledKeyEventManager() {
    }

    static ViewCompat$UnhandledKeyEventManager at(View view) {
        int i = R.id.tag_unhandled_key_event_manager;
        ViewCompat$UnhandledKeyEventManager viewCompat$UnhandledKeyEventManager = (ViewCompat$UnhandledKeyEventManager) view.getTag(i);
        if (viewCompat$UnhandledKeyEventManager != null) {
            return viewCompat$UnhandledKeyEventManager;
        }
        ViewCompat$UnhandledKeyEventManager viewCompat$UnhandledKeyEventManager2 = new ViewCompat$UnhandledKeyEventManager();
        view.setTag(i, viewCompat$UnhandledKeyEventManager2);
        return viewCompat$UnhandledKeyEventManager2;
    }

    @Nullable
    private View dispatchInOrder(View view, KeyEvent keyEvent) {
        WeakHashMap<View, Boolean> weakHashMap = this.mViewsContainingListeners;
        if (weakHashMap != null && weakHashMap.containsKey(view)) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                    View dispatchInOrder = dispatchInOrder(viewGroup.getChildAt(childCount), keyEvent);
                    if (dispatchInOrder != null) {
                        return dispatchInOrder;
                    }
                }
            }
            if (onUnhandledKeyEvent(view, keyEvent)) {
                return view;
            }
        }
        return null;
    }

    private SparseArray<WeakReference<View>> getCapturedKeys() {
        if (this.mCapturedKeys == null) {
            this.mCapturedKeys = new SparseArray<>();
        }
        return this.mCapturedKeys;
    }

    private boolean onUnhandledKeyEvent(@NonNull View view, @NonNull KeyEvent keyEvent) {
        ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_unhandled_key_listeners);
        if (arrayList == null) {
            return false;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((ViewCompat$OnUnhandledKeyEventListenerCompat) arrayList.get(size)).onUnhandledKeyEvent(view, keyEvent)) {
                return true;
            }
        }
        return false;
    }

    private void recalcViewsWithUnhandled() {
        WeakHashMap<View, Boolean> weakHashMap = this.mViewsContainingListeners;
        if (weakHashMap != null) {
            weakHashMap.clear();
        }
        ArrayList<WeakReference<View>> arrayList = sViewsWithListeners;
        if (arrayList.isEmpty()) {
            return;
        }
        synchronized (arrayList) {
            if (this.mViewsContainingListeners == null) {
                this.mViewsContainingListeners = new WeakHashMap<>();
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ArrayList<WeakReference<View>> arrayList2 = sViewsWithListeners;
                View view = arrayList2.get(size).get();
                if (view == null) {
                    arrayList2.remove(size);
                } else {
                    this.mViewsContainingListeners.put(view, Boolean.TRUE);
                    for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                        this.mViewsContainingListeners.put((View) parent, Boolean.TRUE);
                    }
                }
            }
        }
    }

    static void registerListeningView(View view) {
        ArrayList<WeakReference<View>> arrayList = sViewsWithListeners;
        synchronized (arrayList) {
            Iterator<WeakReference<View>> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().get() == view) {
                    return;
                }
            }
            sViewsWithListeners.add(new WeakReference<>(view));
        }
    }

    static void unregisterListeningView(View view) {
        synchronized (sViewsWithListeners) {
            int i = 0;
            while (true) {
                ArrayList<WeakReference<View>> arrayList = sViewsWithListeners;
                if (i >= arrayList.size()) {
                    return;
                }
                if (arrayList.get(i).get() == view) {
                    arrayList.remove(i);
                    return;
                }
                i++;
            }
        }
    }

    boolean dispatch(View view, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            recalcViewsWithUnhandled();
        }
        View dispatchInOrder = dispatchInOrder(view, keyEvent);
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (dispatchInOrder != null && !KeyEvent.isModifierKey(keyCode)) {
                getCapturedKeys().put(keyCode, new WeakReference<>(dispatchInOrder));
            }
        }
        return dispatchInOrder != null;
    }

    boolean preDispatch(KeyEvent keyEvent) {
        int indexOfKey;
        WeakReference<KeyEvent> weakReference = this.mLastDispatchedPreViewKeyEvent;
        if (weakReference != null && weakReference.get() == keyEvent) {
            return false;
        }
        this.mLastDispatchedPreViewKeyEvent = new WeakReference<>(keyEvent);
        WeakReference<View> weakReference2 = null;
        SparseArray<WeakReference<View>> capturedKeys = getCapturedKeys();
        if (keyEvent.getAction() == 1 && (indexOfKey = capturedKeys.indexOfKey(keyEvent.getKeyCode())) >= 0) {
            weakReference2 = capturedKeys.valueAt(indexOfKey);
            capturedKeys.removeAt(indexOfKey);
        }
        if (weakReference2 == null) {
            weakReference2 = capturedKeys.get(keyEvent.getKeyCode());
        }
        if (weakReference2 == null) {
            return false;
        }
        View view = weakReference2.get();
        if (view != null && ViewCompat.isAttachedToWindow(view)) {
            onUnhandledKeyEvent(view, keyEvent);
        }
        return true;
    }
}
