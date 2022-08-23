package com.lnm011223.lovetolearn

import androidx.lifecycle.ViewModel

/**

 * @Author liangnuoming
 * @Date 2022/8/6-11:10 上午

 */
class MainViewModel: ViewModel() {
    var account = ""
    var subject = ""
    var book = ""
    var week = ""
    var isChallenge = 1
    var isOnlyExercise = 1
    lateinit var challenge : Challenge
}