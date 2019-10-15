import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.practice.mygiphyapp.databinding.GiphySearchFragmentBinding
import com.practice.mygiphyapp.network.response.DataItem
import com.practice.mygiphyapp.recyclerview.GifViewAdapter
import com.practice.mygiphyapp.recyclerview.GridItemDecoration
import com.practice.mygiphyapp.viewmodel.GifSearchViewModel


class GiphySearchFragment : Fragment(){

    private var binding:GiphySearchFragmentBinding ?= null
    private var gifRecyclerView: RecyclerView? = null
    private lateinit var adapter: GifViewAdapter
    private val gifList:ArrayList<DataItem> = ArrayList()

    companion object{
        fun newInstance() : GiphySearchFragment{
            return GiphySearchFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            com.practice.mygiphyapp.R.layout.giphy_search_fragment,
            container,
            false
        )!!
        initRecyclerView()
        return binding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val mViewModel = ViewModelProviders.of(this).get(GifSearchViewModel::class.java)
        binding?.setLifecycleOwner(this)
        binding?.setVariable(0,mViewModel)

        binding?.search?.queryHint = "Search your Gifs"
        /*TextChangeListener for Search*/
        binding?.search?.setOnQueryTextListener( object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(text: String): Boolean {
                mViewModel.searchByQuery(text)
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return true
            }

        })
        observe(mViewModel)

//        Pagination
//        binding?.searchContent?.addOnScrollListener(object : RecyclerView.OnScrollListener() {
//            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                super.onScrolled(recyclerView, dx, dy)
//                val layoutManager = recyclerView.layoutManager as GridLayoutManager
//                val pos = layoutManager.findLastCompletelyVisibleItemPosition();
//                if (pos > adapter.itemCount - 2) {
//
//                }
//            }
//        })


    }

    /* initializing the recyclerview and adapter*/
    private fun initRecyclerView(){
        gifRecyclerView = binding?.searchContent
        adapter = GifViewAdapter()
        gifRecyclerView?.adapter = adapter
        gifRecyclerView?.layoutManager = GridLayoutManager(activity,2)
        gifRecyclerView?.addItemDecoration(GridItemDecoration(10,2))
    }

    private fun observe(mViewModel: GifSearchViewModel){
        mViewModel.gifListObservable.observe(this, Observer {
            if(gifList.isNotEmpty()) {
                gifList.clear()
            }
            if (it.isEmpty()) {
                showErrorToast()
            } else {
                gifList.addAll(it!!)
                adapter.setGifList(gifList)
                adapter.notifyDataSetChanged()
            }
        })
    }

    /*Show Toast is there are no results to display*/
    private fun showErrorToast() {
        val toast =
            Toast.makeText(activity, "Enter Valid Text or Try again later", Toast.LENGTH_LONG)
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.show()
    }

}