package com.githab.laravish.lessonmvp.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.githab.laravish.lessonmvp.ARG_LOGIN
import com.githab.laravish.lessonmvp.App
import com.githab.laravish.lessonmvp.cor.OnBackPressedListener
import com.githab.laravish.lessonmvp.databinding.FragmentDetailsUserBinding
import com.githab.laravish.lessonmvp.repository.impl.GithubRepositoryImpl
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class DetailsUserFragment : MvpAppCompatFragment(), DetailsUserView, OnBackPressedListener {

    private var _binding: FragmentDetailsUserBinding? = null
    private val binding: FragmentDetailsUserBinding
        get() = _binding!!

    private val presenter by moxyPresenter {
        DetailsUserPresenter(GithubRepositoryImpl(), App.instance.router)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentDetailsUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getString(ARG_LOGIN)?.let {
            presenter.loadUser(it)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(login: String) =
            DetailsUserFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_LOGIN, login)
                }
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onBackPressed(): Boolean {
        presenter.onBackPressed()
        return true
    }

    override fun showLogin(login: String) = with(binding) {
        tvUserLogin.text = login
    }
}
