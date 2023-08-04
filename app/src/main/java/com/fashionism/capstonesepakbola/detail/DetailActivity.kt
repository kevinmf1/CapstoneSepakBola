
package com.fashionism.capstonesepakbola.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.fashionism.capstonesepakbola.R
import com.fashionism.capstonesepakbola.databinding.ActivityDetailBinding
import com.fashionism.core.domain.model.Player
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@Suppress("unused", "unused", "DEPRECATION")
class DetailActivity : AppCompatActivity() {

    private val detailViewModel: DetailViewModel by viewModels()
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val backButton = binding.backFromDetail
        backButton.setOnClickListener {
            onBackPressed()
        }

        val detailPlayer = intent.getParcelableExtra<Player>(EXTRA_DATA)
        showDetailPlayer(detailPlayer)

    }

    private fun showDetailPlayer(detailPlayer: Player?) {
        detailPlayer?.let {
            binding.detailPlayerName.text = detailPlayer.name
            Glide.with(this@DetailActivity)
                .load(detailPlayer.photo)
                .into(binding.detailPlayerImage)

            binding.detailStarPlayer.text = detailPlayer.rate

            var statusFavorite = detailPlayer.isFavorite
            setStatusFavorite(statusFavorite)
            binding.favoriteDetail.setOnClickListener {
                statusFavorite = !statusFavorite
                detailViewModel.setFavoritePlayer(detailPlayer, statusFavorite)
                setStatusFavorite(statusFavorite)
            }

            binding.tvClubValue.text = detailPlayer.club
            binding.tvPositionValue.text = detailPlayer.position
            binding.tvTotalGoalsValue.text = detailPlayer.allGoalsUntilNow.toString()
            binding.tvTotalAssistValue.text = detailPlayer.allAssistsUntilNow.toString()
            binding.tvActivePlayerValue.text = detailPlayer.activePlayer
            binding.tvDescriptionValue.text = detailPlayer.description
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.favoriteDetail.setImageResource(R.drawable.baseline_favorite_24)
        } else {
            binding.favoriteDetail.setImageResource(R.drawable.baseline_favorite_border_24)
        }
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

}