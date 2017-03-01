package com.sample.app.fragment_with_listview;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.sample.app.R;
import com.sample.app.db.repository.CustomerRepository;
import com.sample.app.entity.Customer;
import com.sample.app.fragment_with_listview.adapters.ListAdapter;

import java.util.List;

public class FragmentWithListView extends Fragment {
    private List<Customer> customerList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView      = inflater.inflate(R.layout.fragment_with_listview, container, false);
        customerList = CustomerRepository.getAll(getContext());
        ListAdapter adapter = new ListAdapter(getActivity(), R.layout.cust_customer_list,
                customerList);
        ListView listView = (ListView) rootView.findViewById(R.id.listView);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);

        return rootView;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getActivity().getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.open:
                showMessage(info.id);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    private void showMessage(long l) {
        Context context = getActivity();
        CharSequence text = customerList.get((int) l).getName();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}

