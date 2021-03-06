package com.android.maziotest.ui.splash

import android.os.Bundle
import com.android.maziotest.R
import com.android.maziotest.ui.base.BaseMvpActivity
import com.android.maziotest.ui.base.BasePresenter
import com.android.maziotest.ui.menu.MenuActivity
import org.jetbrains.anko.clearTask
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.newTask
import javax.inject.Inject

class SplashActivity : BaseMvpActivity(), SplashContracts.View {

    @Inject
    lateinit var mPresenter: SplashContracts.Presenter<SplashContracts.View>

    public override fun onCreate(savedInstanceState: Bundle?) {
        activityComponent?.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setupLayout()
        mPresenter.onAttachView(this)
    }

    override fun sendExtrasToPresenter(extras: Bundle) {

    }

    protected fun setupLayout() {

    }

    public override fun getPresenter(): BasePresenter<*> {
        return mPresenter
    }

    override fun showMenuScreen() {
        startActivity(intentFor<MenuActivity>().clearTask().newTask())
    }
}
