package com.githab.laravish.lessonmvp.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.githab.laravish.lessonmvp.App
import com.githab.laravish.lessonmvp.cor.OnBackPressed
import com.githab.laravish.lessonmvp.databinding.FragmentUsersBinding
import com.githab.laravish.lessonmvp.main.adapter.UserAdapter
import com.githab.laravish.lessonmvp.model.GithubUser
import com.githab.laravish.lessonmvp.repository.impl.GithubRepositoryImpl
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class UsersFragment : MvpAppCompatFragment(), UserView, OnBackPressed {

    private var _binding: FragmentUsersBinding? = null
    private val binding: FragmentUsersBinding
        get() = _binding!!

    private val adapter = UserAdapter()
    private val presenter by moxyPresenter {
        UserPresenter(GithubRepositoryImpl(), App.instance.router)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentUsersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvUsers.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            UsersFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun initList(list: List<GithubUser>) {
        adapter.users = list
    }

    override fun onBackPressed(): Boolean {
        presenter.onBackPressed()
        return true
    }
}
