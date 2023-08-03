package com.emirhansimsek.internproject.View

import android.os.Bundle
import android.telephony.PhoneNumberUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.emirhansimsek.internproject.Model.Celebrity
import com.emirhansimsek.internproject.R
import com.emirhansimsek.internproject.databinding.FragmentProfileDialogBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileDialog.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileDialog(var celebrity: Celebrity.User.Celebrities) : DialogFragment() {

    private var profileDialogBinding: FragmentProfileDialogBinding? = null
    private val binding get() = profileDialogBinding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile_dialog, container, false)
        var name = " "
        var surname = ""
        profileDialogBinding = FragmentProfileDialogBinding.inflate(inflater,container,false)
        profileDialogBinding!!.name.text = celebrity.name_surname
        profileDialogBinding!!.fullName.text = celebrity.name_surname
        profileDialogBinding!!.phoneNumber.text = PhoneNumberUtils.formatNumber(celebrity.phone_number)
        profileDialogBinding!!.email.text = celebrity.email
        profileDialogBinding!!.birthdate.text = celebrity.birthdate
        profileDialogBinding!!.age.text = "${celebrity.age} years old"
        val parts= celebrity.name_surname?.split(" ")
        if (parts != null) {
            name= parts[0]
            surname=parts[1]
        }
        var firstLetter = name.get(0)
        profileDialogBinding!!.numTxt.text = firstLetter.toString()
        isCancelable = false
        profileDialogBinding!!.btnClose.setOnClickListener {

            dismiss()
        }
        return binding.root
    }


}