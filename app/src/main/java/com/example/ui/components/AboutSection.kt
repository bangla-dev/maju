package com.example.ui.components

import androidx.compose.foundation.background
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
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Handyman
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material.icons.filled.WorkspacePremium
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.PortfolioData
import com.example.ui.theme.NavyDark
import com.example.ui.theme.NavyPrimary
import com.example.ui.theme.SkyBlue
import com.example.ui.theme.SkyBlueContainer
import com.example.ui.theme.TextPrimary
import com.example.ui.theme.TextSecondary

@Composable
fun AboutSection(
  modifier: Modifier = Modifier
) {
  Column(
    modifier = modifier
      .fillMaxWidth()
      .padding(horizontal = 16.dp, vertical = 8.dp)
  ) {
    // Section Header
    SectionHeader(
      title = "আমার পরিচয়",
      subtitle = "অভিজ্ঞতা, কাজের দক্ষতা ও কর্মস্থলের বিবরণ"
    )

    Spacer(modifier = Modifier.height(14.dp))

    // Main Bio Card
    Card(
      modifier = Modifier.fillMaxWidth(),
      shape = RoundedCornerShape(16.dp),
      colors = CardDefaults.cardColors(containerColor = Color.White),
      elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
      Column(modifier = Modifier.padding(18.dp)) {
        Text(
          text = "বিশ্বস্ততা ও নিখুঁত কারিগরি সেবা",
          style = MaterialTheme.typography.titleMedium,
          color = NavyPrimary
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
          text = PortfolioData.ABOUT_DETAILS,
          style = MaterialTheme.typography.bodyLarge,
          color = TextSecondary,
          lineHeight = 24.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Key Value Highlights
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
          AboutFeatureRow(
            icon = Icons.Default.WorkspacePremium,
            title = "৮+ বছরের মাঠপর্যায়ের অভিজ্ঞতা",
            subtitle = "ত্রিশাল ও ময়মনসিংহে শত শত বাসাবাড়ির ওয়্যারিং ও স্যানিটারি কাজ সম্পন্ন"
          )
          AboutFeatureRow(
            icon = Icons.Default.Security,
            title = "শতভাগ নিরাপত্তা অগ্রাধিকার",
            subtitle = "সার্কিট ব্রেকার, আর্থিং ও উচ্চমানের ইন্সুলেশনের মাধ্যমে শর্টসার্কিট ঝুঁকি প্রতিরোধ"
          )
          AboutFeatureRow(
            icon = Icons.Default.Handyman,
            title = "আধুনিক টুলস ও নিখুঁত ফিটিংস",
            subtitle = "সঠিক মাপ ও উন্নত প্রযুক্তির যন্ত্রপাতির সাহায্যে দীর্ঘস্থায়ী কাজ"
          )
          AboutFeatureRow(
            icon = Icons.Default.Timer,
            title = "সময়মতো কাজ সম্পন্ন",
            subtitle = "কথার দাম ও গ্রাহকের সুবিধার প্রতি সর্বোচ্চ সম্মান"
          )
        }
      }
    }
  }
}

@Composable
fun AboutFeatureRow(
  icon: ImageVector,
  title: String,
  subtitle: String
) {
  Row(
    modifier = Modifier.fillMaxWidth(),
    verticalAlignment = Alignment.Top
  ) {
    Box(
      modifier = Modifier
        .size(36.dp)
        .background(SkyBlueContainer, CircleShape),
      contentAlignment = Alignment.Center
    ) {
      Icon(
        imageVector = icon,
        contentDescription = null,
        tint = NavyPrimary,
        modifier = Modifier.size(20.dp)
      )
    }

    Spacer(modifier = Modifier.width(12.dp))

    Column(modifier = Modifier.weight(1f)) {
      Text(
        text = title,
        style = MaterialTheme.typography.titleSmall,
        color = TextPrimary
      )
      Spacer(modifier = Modifier.height(2.dp))
      Text(
        text = subtitle,
        style = MaterialTheme.typography.bodyMedium,
        color = TextSecondary,
        lineHeight = 19.sp
      )
    }
  }
}

@Composable
fun SectionHeader(
  title: String,
  subtitle: String,
  modifier: Modifier = Modifier
) {
  Column(modifier = modifier.fillMaxWidth()) {
    Row(verticalAlignment = Alignment.CenterVertically) {
      Box(
        modifier = Modifier
          .width(4.dp)
          .height(22.dp)
          .background(SkyBlue, RoundedCornerShape(2.dp))
      )
      Spacer(modifier = Modifier.width(8.dp))
      Text(
        text = title,
        style = MaterialTheme.typography.titleLarge,
        color = NavyDark
      )
    }
    Spacer(modifier = Modifier.height(4.dp))
    Text(
      text = subtitle,
      style = MaterialTheme.typography.bodyMedium,
      color = TextSecondary
    )
  }
}
