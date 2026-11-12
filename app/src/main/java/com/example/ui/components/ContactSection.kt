package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.OpenInNew
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Whatsapp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.PortfolioData
import com.example.ui.theme.CallBlue
import com.example.ui.theme.FacebookBlue
import com.example.ui.theme.NavyDark
import com.example.ui.theme.NavyPrimary
import com.example.ui.theme.SkyBlue
import com.example.ui.theme.SkyBlueContainer
import com.example.ui.theme.TextPrimary
import com.example.ui.theme.TextSecondary
import com.example.ui.theme.WhatsAppGreen

@Composable
fun ContactSection(
  onCallClick: () -> Unit,
  onWhatsAppClick: (customMessage: String?) -> Unit,
  onFacebookClick: () -> Unit,
  modifier: Modifier = Modifier
) {
  var clientName by remember { mutableStateOf("") }
  var clientLocation by remember { mutableStateOf("") }
  var serviceNeeded by remember { mutableStateOf("") }

  Column(
    modifier = modifier
      .fillMaxWidth()
      .padding(horizontal = 16.dp, vertical = 12.dp)
  ) {
    SectionHeader(
      title = "যোগাযোগ করুন",
      subtitle = "যেকোনো পরামর্শ, বুকিং বা কাজের জন্য সরাসরি যোগাযোগ করুন"
    )

    Spacer(modifier = Modifier.height(14.dp))

    // Direct Contact Channels Cards
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
      // 1. WhatsApp Card
      ContactChannelCard(
        icon = Icons.Default.Whatsapp,
        iconBg = Color(0xFFDCFCE7),
        iconTint = WhatsAppGreen,
        title = "হোয়াটসঅ্যাপ মেসেজ",
        actionText = "01758663620",
        subtext = "মেসেজ বা ভয়েস পাঠাতে ট্যাপ করুন",
        onClick = { onWhatsAppClick(null) }
      )

      // 2. Phone Call Card
      ContactChannelCard(
        icon = Icons.Default.Call,
        iconBg = SkyBlueContainer,
        iconTint = CallBlue,
        title = "সরাসরি মোবাইল কল",
        actionText = "01999234828",
        subtext = "জরুরি বা সাধারণ কাজের জন্য কল দিন",
        onClick = onCallClick
      )

      // 3. Facebook Profile Card
      ContactChannelCard(
        icon = Icons.Default.Public,
        iconBg = Color(0xFFE0E7FF),
        iconTint = FacebookBlue,
        title = "ফেসবুক প্রোফাইল",
        actionText = "Facebook / Maju Electrician",
        subtext = "সোশ্যাল মিডিয়ায় সংযুক্ত থাকুন",
        onClick = onFacebookClick
      )
    }

    Spacer(modifier = Modifier.height(18.dp))

    // Quick Inquiry Form Card
    Card(
      modifier = Modifier.fillMaxWidth(),
      shape = RoundedCornerShape(16.dp),
      colors = CardDefaults.cardColors(containerColor = Color.White),
      elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
      Column(modifier = Modifier.padding(18.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
          Icon(
            imageVector = Icons.Default.Chat,
            contentDescription = null,
            tint = SkyBlue,
            modifier = Modifier.size(20.dp)
          )
          Spacer(modifier = Modifier.width(8.dp))
          Text(
            text = "কাজের জন্য দ্রুত মেসেজ তৈরি করুন",
            style = MaterialTheme.typography.titleSmall,
            color = NavyDark
          )
        }

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
          value = clientName,
          onValueChange = { clientName = it },
          label = { Text("আপনার নাম") },
          modifier = Modifier.fillMaxWidth(),
          shape = RoundedCornerShape(10.dp),
          singleLine = true
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
          value = clientLocation,
          onValueChange = { clientLocation = it },
          label = { Text("আপনার এলাকা / ঠিকানা (যেমন: ত্রিশাল বাজার)") },
          modifier = Modifier.fillMaxWidth(),
          shape = RoundedCornerShape(10.dp),
          singleLine = true
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
          value = serviceNeeded,
          onValueChange = { serviceNeeded = it },
          label = { Text("কাজের বিবরণ (যেমন: নতুন বাড়ির ওয়্যারিং / বাথরুম ফিটিংস)") },
          modifier = Modifier.fillMaxWidth(),
          shape = RoundedCornerShape(10.dp),
          minLines = 2,
          maxLines = 4
        )

        Spacer(modifier = Modifier.height(14.dp))

        Button(
          onClick = {
            val msg = buildString {
              append("আসসালামু আলাইকুম মাজু ভাই।")
              if (clientName.isNotBlank()) append(" আমার নাম: ${clientName.trim()}।")
              if (clientLocation.isNotBlank()) append(" এলাকা: ${clientLocation.trim()}।")
              if (serviceNeeded.isNotBlank()) append(" কাজের বিবরণ: ${serviceNeeded.trim()}।")
              append(" এ ব্যাপারে আপনার সাথে কথা বলতে চাই।")
            }
            onWhatsAppClick(msg)
          },
          modifier = Modifier.fillMaxWidth(),
          shape = RoundedCornerShape(10.dp),
          colors = ButtonDefaults.buttonColors(containerColor = WhatsAppGreen)
        ) {
          Icon(
            imageVector = Icons.Default.Send,
            contentDescription = null,
            modifier = Modifier.size(18.dp)
          )
          Spacer(modifier = Modifier.width(8.dp))
          Text(
            text = "হোয়াটসঅ্যাপে পাঠিয়ে দিন",
            style = MaterialTheme.typography.labelLarge,
            color = Color.White
          )
        }
      }
    }
  }
}

@Composable
fun ContactChannelCard(
  icon: ImageVector,
  iconBg: Color,
  iconTint: Color,
  title: String,
  actionText: String,
  subtext: String,
  onClick: () -> Unit
) {
  Card(
    modifier = Modifier
      .fillMaxWidth()
      .clickable(onClick = onClick),
    shape = RoundedCornerShape(14.dp),
    colors = CardDefaults.cardColors(containerColor = Color.White),
    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
  ) {
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(14.dp),
      verticalAlignment = Alignment.CenterVertically
    ) {
      Box(
        modifier = Modifier
          .size(46.dp)
          .background(iconBg, CircleShape),
        contentAlignment = Alignment.Center
      ) {
        Icon(
          imageVector = icon,
          contentDescription = null,
          tint = iconTint,
          modifier = Modifier.size(24.dp)
        )
      }

      Spacer(modifier = Modifier.width(14.dp))

      Column(modifier = Modifier.weight(1f)) {
        Text(
          text = title,
          style = MaterialTheme.typography.bodySmall,
          color = TextSecondary
        )
        Text(
          text = actionText,
          style = MaterialTheme.typography.titleMedium,
          color = NavyDark
        )
        Text(
          text = subtext,
          style = MaterialTheme.typography.labelSmall,
          color = SkyBlue
        )
      }

      Icon(
        imageVector = Icons.Default.OpenInNew,
        contentDescription = null,
        tint = Color(0xFF94A3B8),
        modifier = Modifier.size(20.dp)
      )
    }
  }
}
