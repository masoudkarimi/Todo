package mkn.todo.tasks.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import mkn.todo.tasks.ui.di.TaskUiComponentFactoryProvider
import mkn.todo.tasks.ui.di.ViewModelFactory
import javax.inject.Inject

class TodoSecondFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: TodoListViewModel by viewModels { viewModelFactory }

    override fun onAttach(context: Context) {
        (context.applicationContext as TaskUiComponentFactoryProvider)
            .providerTaskUiComponentFactory()
            .create()
            .inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return LinearLayout(inflater.context).apply {
            gravity = Gravity.CENTER_VERTICAL
            orientation = LinearLayout.VERTICAL
            layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            val screenName = TextView(context).apply {
                text = "Second Screen"
            }

            addView(screenName, LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT).apply {
                gravity = Gravity.CENTER_HORIZONTAL
            })
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.uiState.flowWithLifecycle(lifecycle).collect {
                Log.d("DEBUG_DAGGER", "TodoSecondFragment: $it")
            }
        }
    }
}