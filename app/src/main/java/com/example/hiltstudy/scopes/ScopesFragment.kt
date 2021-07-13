package com.example.hiltstudy.scopes

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.example.assistedinjection.R
import com.example.assistedinjection.databinding.ScopesFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class ScopesFragment : Fragment() {

    private lateinit var binding: ScopesFragmentBinding

    @Inject
    @Named("id.singleton")
    @JvmField
    var singletonComponentId: Int = 0

    @Inject
    @Named("id.activity_retained")
    @JvmField
    var activityRetainedComponentId: Int = 0

    @Inject
    @Named("id.activity")
    @JvmField
    var activityComponentId: Int = 0

    @Inject
    @Named("id.fragment")
    @JvmField
    var fragmentComponentId: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ScopesFragmentBinding.inflate(inflater, container, false)
        addViewComponentIdView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.restartActivity.setOnClickListener {
            requireActivity().finish()
            requireActivity().startActivity(requireActivity().intent)
        }

        binding.restartFragment.setOnClickListener {
            (requireActivity() as? ScopesActivity)?.recreateFragment()
        }

        binding.recreateView.setOnClickListener {
            binding.root.removeView(binding.root.findViewById(R.id.view_component_id))
            addViewComponentIdView()
        }

        @SuppressLint("SetTextI18n")
        binding.debugView.text = """
            Singleton component id:     $singletonComponentId
            Activity retained c. id:    $activityRetainedComponentId
            Activity component id:      $activityComponentId
            Fragment component id:      $fragmentComponentId
        """.trimIndent()
    }

    private fun addViewComponentIdView() {
        val view = ViewComponentIdView(requireContext()).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            id = R.id.view_component_id
        }
        binding.root.addView(view)
    }
}