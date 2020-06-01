package jp.ne.kotlin_app_one

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.random_button).setOnClickListener {
            val showCountTextView = view.findViewById<TextView>(R.id.textview_first)
            val currentCount = showCountTextView.text.toString().toInt()
            // val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(currentCount)
            // -> Too many arguments ...
            // Provisional https://developer.android.com/guide/navigation/navigation-pass-data#Safe-args
            var bundle = bundleOf("count" to currentCount)
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, bundle)
        }
        view.findViewById<Button>(R.id.toast_button).setOnClickListener {
            val myToast = Toast.makeText(context, "Hello Toast!", Toast.LENGTH_SHORT)
            myToast.show()
        }
        view.findViewById<Button>(R.id.count_button).setOnClickListener {
            countMe(view)
        }
    }

    private fun countMe(view: View) {
        // Get the text view
        val showCountTextView = view.findViewById<TextView>(R.id.textview_first)
        // Get the value of the text view.
        val countString = showCountTextView.text.toString()
        // Convert value to a number and increment it
        var count = countString.toInt()
        count++
        // Display the new value in the text view
        showCountTextView.text = count.toString()
    }
}
