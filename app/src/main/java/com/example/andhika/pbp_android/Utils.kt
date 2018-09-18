package com.example.andhika.pbp_android

import android.content.Context
import android.support.annotation.ColorRes
import android.support.v4.content.ContextCompat
import android.widget.Button
import android.widget.Toast
import io.reactivex.BackpressureStrategy
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers


fun Context.getColorCompat(@ColorRes colorId: Int) = ContextCompat.getColor(this, colorId)


fun <T> Observable<T>.transform(): Observable<T> {
    return this.observeOn(AndroidSchedulers.mainThread())
            .onErrorResumeNext(Function { Observable.error(it) })
            .subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}

fun <T> Observable<T>.uisubscribe(onNext: (T) -> Unit, onError: (Throwable) -> Unit,
                                  onCompleted: () -> Unit = {}): Disposable {
    return this.transform().toFlowable(BackpressureStrategy.BUFFER)
            .subscribe({
                onNext(it)
            }, {
                onError(it)
            }, {
                onCompleted.invoke()
            })
}

fun Button.setAvailable(enable: Boolean, context: Context) {
    with(this) {
        isEnabled = enable
        setBackgroundResource(if (enable) R.drawable.rounded_button_enable else R.drawable.rounded_button_disable)
        setTextColor(if (enable) context.getColorCompat(R.color.white) else context.getColorCompat(R.color.colorPrimary))
    }
}

fun Context.showShortToast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}