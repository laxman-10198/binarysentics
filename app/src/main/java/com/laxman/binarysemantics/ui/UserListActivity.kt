package com.laxman.binarysemantics.ui

import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.laxman.binarysemantics.base.BaseActivity
import com.laxman.binarysemantics.base.Resource
import com.laxman.binarysemantics.databinding.ActivityUserListBinding
import com.laxman.binarysemantics.utils.ErrorUtil
import com.laxman.binarysemantics.viewmodel.AppViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UserListActivity :BaseActivity<ActivityUserListBinding>() {
   private val appViewModel : AppViewModel by viewModels()

    override fun getViewBinding(): ActivityUserListBinding {
      return  ActivityUserListBinding.inflate(layoutInflater)
    }

    override fun initView() {
        CoroutineScope(Dispatchers.Main).launch {  appViewModel.getUsers()}

    }

    override fun initCtrl() {

    }

    override fun observer() {
        appViewModel.userData.observe(this){
            when(it){
               is Resource.Loading->{
                   binding.progressCircular.isVisible =true

                }
              is  Resource.Success ->{
                    binding.progressCircular.isVisible =false
                  it.value?.data?.let { it1 ->
                      binding.rvUser.adapter = UserListAdapter(this@UserListActivity, it1) }

                }
              is  Resource.Failure->{
                  Log.e("TAG", "observer:3 ${it.throwable}", )
                    binding.progressCircular.isVisible =false
                  ErrorUtil.handlerGeneralError(this@UserListActivity, throwable = it.throwable)

                }
                else ->{
                    binding.progressCircular.isVisible =false
                    Log.e("TAG", "observer:2", )
                }
            }
        }

    }

}