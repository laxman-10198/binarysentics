package com.laxman.binarysemantics

import android.content.Intent
import android.os.Handler
import com.laxman.binarysemantics.base.BaseActivity
import com.laxman.binarysemantics.databinding.ActivityMainBinding
import com.laxman.binarysemantics.ui.UserListActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getViewBinding(): ActivityMainBinding {
       return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initView() {
        Handler(mainLooper).postDelayed({
            startActivity(Intent(this@MainActivity,UserListActivity::class.java))
        },2000)

    }

    override fun initCtrl() {

    }

    override fun observer() {

    }

}