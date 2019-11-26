// Generated code from Butter Knife. Do not modify!
package com.example.shirley.mobileshopbyw.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.shirley.mobileshopbyw.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MyAddressActivity_ViewBinding<T extends MyAddressActivity> implements Unbinder {
  protected T target;

  @UiThread
  public MyAddressActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tvTitle = null;

    this.target = null;
  }
}
