package com.sphtech.mobileusage.base


import com.sphtech.mobileusage.main.MainPresenter
import com.sphtech.mobileusage.main.MainView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by Ramakrishna on 01/02/19.
 */

abstract class BasePresenter<T : MainView>(protected val scheduler: BaseScheduler) : MainPresenter<T> {


    private val mCompositeDisposable: CompositeDisposable = CompositeDisposable()

    protected fun addDisposable(disposable: Disposable) {
        this.mCompositeDisposable.add(disposable)
    }

    var mView: T? = null

    override val view: T?
        get() = this.mView

    override fun detachView() {
        this.clearDisposables()
        this.mView = null
    }

    override fun attach(view: T) {
        this.mView = view
    }

    protected fun clearDisposables() {
        this.mCompositeDisposable.clear()
    }
}