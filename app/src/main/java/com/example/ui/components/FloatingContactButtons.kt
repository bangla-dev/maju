package com.example.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Whatsapp
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.example.ui.theme.CallBlue
import com.example.ui.theme.WhatsAppGreen

@Composable
fun FloatingContactButtons(
  onWhatsAppClick: () -> Unit,
  onCallClick: () -> Unit,
  modifier: Modifier = Modifier
) {
  Column(
    modifier = modifier.padding(16.dp),
    verticalArrangement = Arrangement.spacedBy(12.dp),
    horizontalAlignment = Alignment.End
  ) {
    // 1. Phone Call Icon Button (Blue circle with phone icon only)
    FloatingActionButton(
      onClick = onCallClick,
      shape = CircleShape,
      containerColor = CallBlue,
      contentColor = Color.White,
      elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 6.dp),
      modifier = Modifier
        .size(56.dp)
        .testTag("fab_call")
    ) {
      Icon(
        imageVector = Icons.Default.Call,
        contentDescription = "সরাসরি কল দিন",
        modifier = Modifier.size(28.dp)
      )
    }

    // 2. WhatsApp Icon Button (Green circle with whatsapp icon only)
    FloatingActionButton(
      onClick = onWhatsAppClick,
      shape = CircleShape,
      containerColor = WhatsAppGreen,
      contentColor = Color.White,
      elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 6.dp),
      modifier = Modifier
        .size(56.dp)
        .testTag("fab_whatsapp")
    ) {
      Icon(
        imageVector = Icons.Default.Whatsapp,
        contentDescription = "হোয়াটসঅ্যাপে মেসেজ পাঠান",
        modifier = Modifier.size(30.dp)
      )
    }
  }
}
