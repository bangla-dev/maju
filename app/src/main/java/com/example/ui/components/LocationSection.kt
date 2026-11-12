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
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.LocationCity
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.PinDrop
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.PortfolioData
import com.example.model.WorkArea
import com.example.ui.theme.NavyDark
import com.example.ui.theme.NavyPrimary
import com.example.ui.theme.SkyBlue
import com.example.ui.theme.SkyBlueContainer
import com.example.ui.theme.TextPrimary
import com.example.ui.theme.TextSecondary

@Composable
fun LocationSection(
  onCallForAreaClick: () -> Unit,
  modifier: Modifier = Modifier
) {
  Column(
    modifier = modifier
      .fillMaxWidth()
      .padding(horizontal = 16.dp, vertical = 12.dp)
  ) {
    SectionHeader(
      title = "আমার কর্মস্থল ও সেবার এলাকা",
      subtitle = "ত্রিশাল ও ময়মনসিংহ জেলার বিভিন্ন প্রান্তে সেবা প্রদান"
    )

    Spacer(modifier = Modifier.height(14.dp))

    Card(
      modifier = Modifier.fillMaxWidth(),
      shape = RoundedCornerShape(16.dp),
      colors = CardDefaults.cardColors(containerColor = Color.White),
      elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
      Column(modifier = Modifier.padding(18.dp)) {
        // Location header
        Row(verticalAlignment = Alignment.CenterVertically) {
          Box(
            modifier = Modifier
              .size(44.dp)
              .background(SkyBlueContainer, CircleShape),
            contentAlignment = Alignment.Center
          ) {
            Icon(
              imageVector = Icons.Default.PinDrop,
              contentDescription = null,
              tint = NavyPrimary,
              modifier = Modifier.size(24.dp)
            )
          }

          Spacer(modifier = Modifier.width(12.dp))

          Column {
            Text(
              text = "প্রধান কর্মস্থল",
              style = MaterialTheme.typography.bodySmall,
              color = TextSecondary
            )
            Text(
              text = PortfolioData.LOCATION_PRIMARY,
              style = MaterialTheme.typography.titleMedium,
              color = NavyDark
            )
          }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
          text = "সেবার আওতাভুক্ত এলাকাসমূহ:",
          style = MaterialTheme.typography.titleSmall,
          color = NavyPrimary
        )

        Spacer(modifier = Modifier.height(10.dp))

        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
          PortfolioData.workAreas.forEach { area ->
            WorkAreaRow(area = area)
          }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Note regarding service on demand
        Surface(
          color = Color(0xFFF8FAFC),
          shape = RoundedCornerShape(10.dp),
          modifier = Modifier.fillMaxWidth()
        ) {
          Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
          ) {
            Icon(
              imageVector = Icons.Default.LocationCity,
              contentDescription = null,
              tint = SkyBlue,
              modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
              text = "আপনার বাড়ি বা কর্মস্থল উল্লিখিত এলাকার মধ্যে হলে সরাসরি কাজের জন্য যোগাযোগ করুন।",
              style = MaterialTheme.typography.bodySmall,
              color = TextSecondary,
              lineHeight = 19.sp
            )
          }
        }

        Spacer(modifier = Modifier.height(14.dp))

        Button(
          onClick = onCallForAreaClick,
          modifier = Modifier.fillMaxWidth(),
          shape = RoundedCornerShape(12.dp),
          colors = ButtonDefaults.buttonColors(containerColor = NavyPrimary)
        ) {
          Icon(
            imageVector = Icons.Default.Call,
            contentDescription = null,
            modifier = Modifier.size(18.dp)
          )
          Spacer(modifier = Modifier.width(8.dp))
          Text(
            text = "কাজের জন্য এখনই কল দিন",
            style = MaterialTheme.typography.labelLarge
          )
        }
      }
    }
  }
}

@Composable
private fun WorkAreaRow(area: WorkArea) {
  Row(
    modifier = Modifier.fillMaxWidth(),
    verticalAlignment = Alignment.Top
  ) {
    Box(
      modifier = Modifier
        .size(24.dp)
        .background(
          if (area.isPrimary) Color(0xFFDCFCE7) else SkyBlueContainer,
          CircleShape
        ),
      contentAlignment = Alignment.Center
    ) {
      Icon(
        imageVector = Icons.Default.Check,
        contentDescription = null,
        tint = if (area.isPrimary) Color(0xFF16A34A) else SkyBlue,
        modifier = Modifier.size(14.dp)
      )
    }

    Spacer(modifier = Modifier.width(10.dp))

    Column {
      Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
          text = area.title,
          style = MaterialTheme.typography.titleSmall,
          color = TextPrimary
        )
        if (area.isPrimary) {
          Spacer(modifier = Modifier.width(8.dp))
          Surface(
            color = Color(0xFFDCFCE7),
            shape = RoundedCornerShape(6.dp)
          ) {
            Text(
              text = "মূল কেন্দ্র",
              fontSize = 11.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFF16A34A),
              modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
            )
          }
        }
      }
      Text(
        text = area.coverage,
        style = MaterialTheme.typography.bodySmall,
        color = TextSecondary
      )
    }
  }
}
