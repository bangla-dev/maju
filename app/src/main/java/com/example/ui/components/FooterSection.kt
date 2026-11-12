package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.filled.Whatsapp
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.PortfolioData
import com.example.ui.theme.NavyDark
import com.example.ui.theme.NavyLight
import com.example.ui.theme.SkyBlue
import com.example.ui.theme.SkyBlueLight
import com.example.ui.theme.WhatsAppGreen

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FooterSection(
  onWhatsAppClick: () -> Unit,
  onCallClick: () -> Unit,
  onFacebookClick: () -> Unit,
  modifier: Modifier = Modifier
) {
  Column(
    modifier = modifier
      .fillMaxWidth()
      .background(NavyDark)
      .padding(horizontal = 20.dp, vertical = 24.dp)
  ) {
    Text(
      text = PortfolioData.NAME,
      style = MaterialTheme.typography.titleLarge,
      color = Color.White
    )

    Spacer(modifier = Modifier.height(4.dp))

    Text(
      text = PortfolioData.PROFESSION,
      style = MaterialTheme.typography.bodyMedium,
      color = SkyBlueLight
    )

    Spacer(modifier = Modifier.height(8.dp))

    Text(
      text = "বাসাবাড়ির আধুনিক ও নিরাপদ বৈদ্যুতিক ওয়্যারিং, স্যানিটারি বাথরুম ফিটিংস এবং পানির মোটর স্থাপনে বিশ্বস্ত কারিগর।",
      style = MaterialTheme.typography.bodySmall,
      color = Color(0xFF94A3B8),
      lineHeight = 20.sp
    )

    Spacer(modifier = Modifier.height(18.dp))

    // Quick links chips
    FlowRow(
      horizontalArrangement = Arrangement.spacedBy(8.dp),
      verticalArrangement = Arrangement.spacedBy(8.dp),
      modifier = Modifier.fillMaxWidth()
    ) {
      FooterActionChip(
        icon = Icons.Default.Whatsapp,
        label = "হোয়াটসঅ্যাপ",
        tint = WhatsAppGreen,
        onClick = onWhatsAppClick
      )
      FooterActionChip(
        icon = Icons.Default.Call,
        label = "কল দিন",
        tint = SkyBlueLight,
        onClick = onCallClick
      )
      FooterActionChip(
        icon = Icons.Default.Public,
        label = "ফেসবুক",
        tint = Color(0xFF60A5FA),
        onClick = onFacebookClick
      )
    }

    Spacer(modifier = Modifier.height(16.dp))

    Row(verticalAlignment = Alignment.CenterVertically) {
      Icon(
        imageVector = Icons.Default.LocationOn,
        contentDescription = null,
        tint = SkyBlueLight,
        modifier = Modifier.size(16.dp)
      )
      Spacer(modifier = Modifier.width(6.dp))
      Text(
        text = PortfolioData.LOCATION_PRIMARY,
        style = MaterialTheme.typography.bodySmall,
        color = Color(0xFFCBD5E1)
      )
    }

    Spacer(modifier = Modifier.height(18.dp))

    HorizontalDivider(color = NavyLight)

    Spacer(modifier = Modifier.height(14.dp))

    Text(
      text = "© ২০২৬ ${PortfolioData.NAME}। সর্বস্বত্ব সংরক্ষিত।",
      style = MaterialTheme.typography.labelSmall,
      color = Color(0xFF94A3B8),
      textAlign = TextAlign.Center,
      modifier = Modifier.fillMaxWidth()
    )
  }
}

@Composable
private fun FooterActionChip(
  icon: androidx.compose.ui.graphics.vector.ImageVector,
  label: String,
  tint: Color,
  onClick: () -> Unit
) {
  Surface(
    color = NavyLight,
    shape = RoundedCornerShape(20.dp),
    modifier = Modifier.clickable(onClick = onClick)
  ) {
    Row(
      modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
      verticalAlignment = Alignment.CenterVertically
    ) {
      Icon(
        imageVector = icon,
        contentDescription = null,
        tint = tint,
        modifier = Modifier.size(16.dp)
      )
      Spacer(modifier = Modifier.width(6.dp))
      Text(
        text = label,
        style = MaterialTheme.typography.labelSmall,
        color = Color.White
      )
    }
  }
}
