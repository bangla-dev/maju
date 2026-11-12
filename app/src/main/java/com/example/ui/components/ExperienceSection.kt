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
import androidx.compose.material.icons.filled.AssignmentTurnedIn
import androidx.compose.material.icons.filled.ElectricBolt
import androidx.compose.material.icons.filled.Handyman
import androidx.compose.material.icons.filled.Plumbing
import androidx.compose.material.icons.filled.ThumbUp
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
import com.example.ui.theme.ElectricYellow
import com.example.ui.theme.NavyDark
import com.example.ui.theme.NavyPrimary
import com.example.ui.theme.SkyBlue
import com.example.ui.theme.SkyBlueContainer
import com.example.ui.theme.TextPrimary
import com.example.ui.theme.TextSecondary

@Composable
fun ExperienceSection(
  modifier: Modifier = Modifier
) {
  Column(
    modifier = modifier
      .fillMaxWidth()
      .padding(horizontal = 16.dp, vertical = 12.dp)
  ) {
    SectionHeader(
      title = "আমার অভিজ্ঞতা ও কাজের নীতি",
      subtitle = "দীর্ঘ ৮ বছরের বেশি সময়ের মাঠপর্যায়ের কর্মদক্ষতা"
    )

    Spacer(modifier = Modifier.height(14.dp))

    Card(
      modifier = Modifier.fillMaxWidth(),
      shape = RoundedCornerShape(16.dp),
      colors = CardDefaults.cardColors(containerColor = Color.White),
      elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
      Column(
        modifier = Modifier.padding(18.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
      ) {
        ExperienceItem(
          icon = Icons.Default.AssignmentTurnedIn,
          iconBg = Color(0xFFFEF3C7),
          iconTint = Color(0xFFD97706),
          title = "৮ বছরের বেশি বাস্তব অভিজ্ঞতা",
          description = "ত্রিশাল ও ময়মনসিংহের বিভিন্ন গ্রামীণ ও পৌর বাসাবাড়িতে বৈদ্যুতিক ও স্যানিটারি কাজের দীর্ঘদিনের প্রত্যক্ষ অভিজ্ঞতা।"
        )

        ExperienceItem(
          icon = Icons.Default.ElectricBolt,
          iconBg = SkyBlueContainer,
          iconTint = SkyBlue,
          title = "বৈদ্যুতিক ওয়্যারিংয়ে পারদর্শিতা",
          description = "নতুন ভবনের কনসিলড বা ওপেন ওয়্যারিং, লোড ক্যালকুলেশন অনুযায়ী সঠিক গেজের তার ও আধুনিক সার্কিট সুরক্ষা।"
        )

        ExperienceItem(
          icon = Icons.Default.Plumbing,
          iconBg = Color(0xFFE0F7FA),
          iconTint = Color(0xFF00838F),
          title = "স্যানিটারি ও প্লাম্বিং ফিটিং",
          description = "উন্নত মানের স্যানিটারি ওয়্যার, শাওয়ার ও কমোড স্থাপন এবং পানির প্রেসার বজায় রেখে সুশৃঙ্খল পাইপলাইন।"
        )

        ExperienceItem(
          icon = Icons.Default.Handyman,
          iconBg = Color(0xFFF3E8FF),
          iconTint = Color(0xFF7E22CE),
          title = "পানির মোটর স্থাপন ও টেস্ট রান",
          description = "মোটর ভাইব্রেশন মুক্ত বসানো, নন-রিটার্ন ভালভ এবং স্বয়ংক্রিয় কন্ট্রোলারের সঠিক সংযোগ।"
        )

        ExperienceItem(
          icon = Icons.Default.ThumbUp,
          iconBg = Color(0xFFDCFCE7),
          iconTint = Color(0xFF16A34A),
          title = "দায়িত্বশীল কাজের প্রতিশ্রুতি",
          description = "কাজের শুরুতে পরিষ্কার পরামর্শ, সঠিক বাজেটে কাজ সম্পন্ন করা এবং কাজ শেষে প্রতিটি লাইন পরীক্ষা করে বুঝিয়ে দেওয়া।"
        )
      }
    }
  }
}

@Composable
private fun ExperienceItem(
  icon: ImageVector,
  iconBg: Color,
  iconTint: Color,
  title: String,
  description: String
) {
  Row(
    modifier = Modifier.fillMaxWidth(),
    verticalAlignment = Alignment.Top
  ) {
    Box(
      modifier = Modifier
        .size(40.dp)
        .background(iconBg, CircleShape),
      contentAlignment = Alignment.Center
    ) {
      Icon(
        imageVector = icon,
        contentDescription = null,
        tint = iconTint,
        modifier = Modifier.size(22.dp)
      )
    }

    Spacer(modifier = Modifier.width(14.dp))

    Column(modifier = Modifier.weight(1f)) {
      Text(
        text = title,
        style = MaterialTheme.typography.titleSmall,
        color = NavyDark
      )
      Spacer(modifier = Modifier.height(2.dp))
      Text(
        text = description,
        style = MaterialTheme.typography.bodyMedium,
        color = TextSecondary,
        lineHeight = 22.sp
      )
    }
  }
}
