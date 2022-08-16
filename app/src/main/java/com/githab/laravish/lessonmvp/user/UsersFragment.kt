package com.githab.laravish.lessonmvp.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.githab.laravish.lessonmvp.App
import com.githab.laravish.lessonmvp.cor.ItemOnClickItemListener
import com.githab.laravish.lessonmvp.cor.OnBackPressedListener
import com.githab.laravish.lessonmvp.databinding.FragmentUsersBinding
import com.githab.laravish.lessonmvp.user.adapter.UserAdapter
import com.githab.laravish.lessonmvp.model.GithubUser
import com.githab.laravish.lessonmvp.repository.impl.GithubRepositoryImpl
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class UsersFragment : MvpAppCompatFragment(), UserView, OnBackPressedListener,
    ItemOnClickItemListener {

    private var _binding: FragmentUsersBinding? = null
    private val binding: FragmentUsersBinding
        get() = _binding!!

    private val presenter by moxyPresenter {
        UserPresenter(GithubRepositoryImpl(), App.instance.router)
    }

    private val adapter = UserAdapter(this)

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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun initList(list: List<GithubUser>) {
        adapter.users = list
    }

    override fun onBackPressed() =
        presenter.onBackPressed()

    override fun onClick(item: GithubUser) {
        presenter.onItemClicked(item.login)
    }
}
