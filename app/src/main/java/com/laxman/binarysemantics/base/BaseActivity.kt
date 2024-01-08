package com.laxman.binarysemantics.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB:ViewBinding>:AppCompatActivity() {
    lateinit var binding: VB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding()
        setContentView(binding.root)
        if (this::binding.isInitialized){
            initView()
            initCtrl()
            observer()
        }

    }
    protected abstract fun getViewBinding():VB
    protected  abstract fun initView()
    protected abstract fun initCtrl()
    protected abstract fun observer()
}