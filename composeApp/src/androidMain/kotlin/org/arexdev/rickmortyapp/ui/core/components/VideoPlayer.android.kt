package org.arexdev.rickmortyapp.ui.core.components

import android.widget.MediaController
import android.widget.VideoView
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@Composable
actual fun VideoPlayer(modifier: Modifier, url: String) {
    AndroidView(modifier = modifier, factory = { context ->
        val videoView = VideoView(context)
        videoView.apply {
            setVideoPath(url)
            setMediaController(MediaController(context).apply {
                setAnchorView(videoView)
            })
            start()
        }
    })
}