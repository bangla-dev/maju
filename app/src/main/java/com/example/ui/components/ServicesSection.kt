package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.FormatPaint
import androidx.compose.material.icons.filled.Handyman
import androidx.compose.material.icons.filled.Plumbing
import androidx.compose.material.icons.filled.WaterDrop
import androidx.compose.material.icons.filled.Whatsapp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.PortfolioData
import com.example.model.ServiceCategory
import com.example.ui.theme.ElectricYellow
import com.example.ui.theme.NavyDark
import com.example.ui.theme.NavyPrimary
import com.example.ui.theme.SkyBlue
import com.example.ui.theme.SkyBlueContainer
import com.example.ui.theme.SurfaceBorder
import com.example.ui.theme.TextPrimary
import com.example.ui.theme.TextSecondary
import com.example.ui.theme.WhatsAppGreen

@Composable
fun ServicesSection(
  onServiceSelect: (ServiceCategory) -> Unit,
  modifier: Modifier = Modifier
) {
  Column(
    modifier = modifier
      .fillMaxWidth()
      .padding(horizontal = 16.dp, vertical = 12.dp)
  ) {
    SectionHeader(
      title = "আমার সেবাসমূহ",
      subtitle = "বাসাবাড়ির ওয়্যারিং, স্যানিটারি ফিটিংস ও পানির মোটর স্থাপন"
    )

    Spacer(modifier = Modifier.height(14.dp))

    // Services cards list
    Column(
      verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
      PortfolioData.services.forEach { service ->
        ServiceCard(
          service = service,
          onBookClick = { onServiceSelect(service) }
        )
      }
    }
  }
}

@Composable
fun ServiceCard(
  service: ServiceCategory,
  onBookClick: () -> Unit,
  modifier: Modifier = Modifier
) {
  val (icon, iconBg, iconTint) = when (service.id) {
    "electrical" -> Triple(Icons.Default.Bolt, Color(0xFFFEF3C7), Color(0xFFD97706))
    "sanitary" -> Triple(Icons.Default.Plumbing, SkyBlueContainer, SkyBlue)
    else -> Triple(Icons.Default.WaterDrop, Color(0xFFE0F7FA), Color(0xFF00838F))
  }

  Card(
    modifier = modifier.fillMaxWidth(),
    shape = RoundedCornerShape(18.dp),
    colors = CardDefaults.cardColors(containerColor = Color.White),
    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
  ) {
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(18.dp)
    ) {
      // Header of card: Icon + Title + Subtitle
      Row(
        verticalAlignment = Alignment.CenterVertically
      ) {
        Box(
          modifier = Modifier
            .size(46.dp)
            .background(iconBg, RoundedCornerShape(12.dp)),
          contentAlignment = Alignment.Center
        ) {
          Icon(
            imageVector = icon,
            contentDescription = null,
            tint = iconTint,
            modifier = Modifier.size(26.dp)
          )
        }

        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {
          Text(
            text = service.title,
            style = MaterialTheme.typography.titleMedium,
            color = NavyDark
          )
          Text(
            text = service.subtitle,
            style = MaterialTheme.typography.bodySmall,
            color = TextSecondary
          )
        }
      }

      Spacer(modifier = Modifier.height(14.dp))

      // Service items checklist
      Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
      ) {
        service.items.forEach { item ->
          Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
          ) {
            Icon(
              imageVector = Icons.Default.CheckCircle,
              contentDescription = null,
              tint = SkyBlue,
              modifier = Modifier.size(17.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
              text = item,
              style = MaterialTheme.typography.bodyMedium,
              color = TextPrimary
            )
          }
        }
      }

      Spacer(modifier = Modifier.height(16.dp))

      // Action button
      OutlinedButton(
        onClick = onBookClick,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp)
      ) {
        Icon(
          imageVector = Icons.Default.Whatsapp,
          contentDescription = null,
          tint = WhatsAppGreen,
          modifier = Modifier.size(18.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
          text = "${service.title} বুকিং / পরামর্শ করুন",
          style = MaterialTheme.typography.labelLarge,
          color = NavyPrimary
        )
      }
    }
  }
}
