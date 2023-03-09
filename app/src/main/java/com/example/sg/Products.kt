package com.example.sg

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sg.Adapter.ProductListAdapter
import com.example.sg.ViewModel.ProductViewModel
import com.example.sg.databinding.FragmentProductsBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"



/**
 * A simple [Fragment] subclass.
 * Use the [Products.newInstance] factory method to
 * create an instance of this fragment.
 */
class Products : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    var productviewmodel: ProductViewModel? = null
    var adapter: ProductListAdapter? = null
    var layoutManager: LinearLayoutManager? = null
    var dialog: AlertDialog? = null

    private var _binding : FragmentProductsBinding? = null
    private val binding : FragmentProductsBinding
        get() = _binding!!



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)

        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProductsBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productviewmodel = ViewModelProvider(this)[ProductViewModel::class.java]

        dialog = context?.let { AlertDialog.Builder(it).setCancelable(false).create() }
        dialog!!.show()

        binding.recyclerView.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(context)
        binding.recyclerView.layoutManager = layoutManager

        productviewmodel!!.getItemList.observe(viewLifecycleOwner) { itemmodel ->
//            Log.e("MainActivity","ItemList: "+itemmodel.get(0).title)

            if (itemmodel != null) {
                adapter = context?.let { ProductListAdapter(it, itemmodel.products) }
                adapter!!.notifyDataSetChanged()
                binding.recyclerView.adapter = adapter
                dialog!!.dismiss()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}











