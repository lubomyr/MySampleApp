package com.sample.app.activity_tab_pager.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import java.util.*

class TabPagerAdapter : FragmentPagerAdapter {

    private var mFragmentList = ArrayList<Fragment>()
    private val mFragmentTitleList = ArrayList<String>()
    private var mManager: FragmentManager? = null

    constructor(manager: FragmentManager) : super(manager) {
        mManager = manager
    }

    constructor(manager: FragmentManager, fragmentList: MutableList<Fragment>) : super(manager) {
        mManager = manager
        mFragmentList = fragmentList as ArrayList<Fragment>
    }

    override fun getItem(position: Int): Fragment {
        return mFragmentList[position]
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return mFragmentTitleList[position]
    }

    fun clear() {
        removeAllFragments()
        mFragmentList.clear()
        mFragmentTitleList.clear()
    }

    fun addFragment(fragment: Fragment, title: String) {
        mFragmentList.add(fragment)
        mFragmentTitleList.add(title)
    }


    private fun removeAllFragments() {
        if (mFragmentList != null) {
            val ft = mManager!!.beginTransaction()
            for (f in mFragmentList) {
                ft.remove(f)
                ft.commitNow()
            }
        }
    }
}
