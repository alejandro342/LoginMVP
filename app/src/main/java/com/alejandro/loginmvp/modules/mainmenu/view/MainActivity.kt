package com.alejandro.loginmvp.modules.mainmenu.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.alejandro.loginmvp.R
import com.alejandro.loginmvp.databinding.ActivityMainBinding
import com.alejandro.loginmvp.modules.mainmenu.presenter.MainMenuPresenter

class MainActivity : AppCompatActivity(), View.OnClickListener{
    private var mBinding:ActivityMainBinding?=null
    var mMainMenuPresenter: MainMenuPresenter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding= ActivityMainBinding.inflate(layoutInflater)
        val mView:View=mBinding!!.root
        setContentView(mView)
        mMainMenuPresenter=MainMenuPresenter(this)
        mBinding!!.btnCloseSession.setOnClickListener(this)
        mMainMenuPresenter?.getUserFromSession()
    }

    override fun onClick(myItem: View?) {
       when(myItem){
           mBinding!!.btnCloseSession ->{mMainMenuPresenter!!.closeSession()}
       }
    }
}