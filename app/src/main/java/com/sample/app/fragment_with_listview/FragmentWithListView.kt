package com.sample.app.fragment_with_listview

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import com.sample.app.R
import com.sample.app.entity.Customer
import com.sample.app.fragment_with_listview.adapters.ListAdapter
import com.sample.app.repository.CustomerRepository

class FragmentWithListView : Fragment() {
    private var customerList: List<Customer>? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val rootView = inflater!!.inflate(R.layout.fragment_with_listview, container, false)
        customerList = CustomerRepository.all
        val adapter = ListAdapter(activity, R.layout.item_customer,
                customerList!!)
        val listView = rootView.findViewById(R.id.listView) as ListView
        listView.adapter = adapter
        registerForContextMenu(listView)

        return rootView
    }

    override fun onCreateContextMenu(menu: ContextMenu, v: View,
                                     menuInfo: ContextMenu.ContextMenuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = activity.menuInflater
        inflater.inflate(R.menu.context_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        val info = item!!.menuInfo as AdapterView.AdapterContextMenuInfo
        when (item.itemId) {
            R.id.open -> {
                showMessage(info.id)
                return true
            }
            else -> return super.onContextItemSelected(item)
        }
    }

    private fun showMessage(l: Long) {
        val context = activity
        val text = customerList!![l.toInt()].name
        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(context, text, duration)
        toast.show()
    }
}

