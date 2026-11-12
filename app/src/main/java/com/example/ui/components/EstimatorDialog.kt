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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.Whatsapp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.ui.theme.NavyDark
import com.example.ui.theme.NavyPrimary
import com.example.ui.theme.SkyBlue
import com.example.ui.theme.SkyBlueContainer
import com.example.ui.theme.TextPrimary
import com.example.ui.theme.TextSecondary
import com.example.ui.theme.WhatsAppGreen

@Composable
fun EstimatorDialog(
  onDismiss: () -> Unit,
  onSendEstimateWhatsApp: (estimateSummary: String) -> Unit
) {
  var switchPoints by remember { mutableIntStateOf(10) }
  var lightFanPoints by remember { mutableIntStateOf(8) }
  var hasMainDb by remember { mutableStateOf(true) }
  var bathroomCount by remember { mutableIntStateOf(1) }
  var hasPumpMotor by remember { mutableStateOf(false) }

  Dialog(
    onDismissRequest = onDismiss,
    properties = DialogProperties(usePlatformDefaultWidth = false)
  ) {
    Card(
      modifier = Modifier
        .fillMaxWidth(0.92f)
        .padding(vertical = 16.dp),
      shape = RoundedCornerShape(18.dp),
      colors = CardDefaults.cardColors(containerColor = Color.White),
      elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .padding(20.dp)
          .verticalScroll(rememberScrollState())
      ) {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
              modifier = Modifier
                .size(36.dp)
                .background(SkyBlueContainer, CircleShape),
              contentAlignment = Alignment.Center
            ) {
              Icon(
                imageVector = Icons.Default.Calculate,
                contentDescription = null,
                tint = NavyPrimary,
                modifier = Modifier.size(20.dp)
              )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Text(
              text = "কাজের পরিধি ও আনুমানিক হিসাব",
              style = MaterialTheme.typography.titleMedium,
              color = NavyDark
            )
          }
          IconButton(onClick = onDismiss) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "বন্ধ করুন")
          }
        }

        Spacer(modifier = Modifier.height(14.dp))

        Text(
          text = "আপনার বাসাবাড়ির কাজের পয়েন্ট সংখ্যা নির্ধারণ করুন:",
          style = MaterialTheme.typography.bodyMedium,
          color = TextSecondary
        )

        Spacer(modifier = Modifier.height(12.dp))

        // 1. Switch / Socket Points Counter
        EstimatorCounterRow(
          title = "সুইচ ও সকেট পয়েন্ট",
          subtitle = "রুম, ডাইনিং ও রান্নাঘরের সুইচ-সকেট",
          count = switchPoints,
          onIncrement = { switchPoints += 1 },
          onDecrement = { if (switchPoints > 0) switchPoints -= 1 }
        )

        Spacer(modifier = Modifier.height(10.dp))

        // 2. Light & Fan Points Counter
        EstimatorCounterRow(
          title = "লাইট ও ফ্যান ফিটিং পয়েন্ট",
          subtitle = "সিলিং ফ্যান, ওয়াল লাইট ও ফলস সিলিং লাইট",
          count = lightFanPoints,
          onIncrement = { lightFanPoints += 1 },
          onDecrement = { if (lightFanPoints > 0) lightFanPoints -= 1 }
        )

        Spacer(modifier = Modifier.height(10.dp))

        // 3. Bathroom Sanitary Counter
        EstimatorCounterRow(
          title = "বাথরুম স্যানিটারি ফিটিংস",
          subtitle = "কমোড, বেসিন, শাওয়ার ও পাইপলাইন",
          count = bathroomCount,
          onIncrement = { bathroomCount += 1 },
          onDecrement = { if (bathroomCount > 0) bathroomCount -= 1 }
        )

        Spacer(modifier = Modifier.height(12.dp))

        // 4. Main Distribution Board Checkbox
        Row(
          modifier = Modifier.fillMaxWidth(),
          verticalAlignment = Alignment.CenterVertically
        ) {
          Checkbox(
            checked = hasMainDb,
            onCheckedChange = { hasMainDb = it }
          )
          Spacer(modifier = Modifier.width(6.dp))
          Column {
            Text(
              text = "মেইন ডিস্ট্রিবিউশন বোর্ড (এমসিবি)",
              style = MaterialTheme.typography.titleSmall,
              color = TextPrimary
            )
            Text(
              text = "সার্কিট ব্রেকার ও আর্থিং সংযোগ",
              style = MaterialTheme.typography.bodySmall,
              color = TextSecondary
            )
          }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // 5. Water Pump Motor Checkbox
        Row(
          modifier = Modifier.fillMaxWidth(),
          verticalAlignment = Alignment.CenterVertically
        ) {
          Checkbox(
            checked = hasPumpMotor,
            onCheckedChange = { hasPumpMotor = it }
          )
          Spacer(modifier = Modifier.width(6.dp))
          Column {
            Text(
              text = "পানির মোটর স্থাপন",
              style = MaterialTheme.typography.titleSmall,
              color = TextPrimary
            )
            Text(
              text = "মোটর বসানো, পাইপ ফিটিংস ও টেস্ট রান",
              style = MaterialTheme.typography.bodySmall,
              color = TextSecondary
            )
          }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Summary Box
        Surface(
          color = Color(0xFFF8FAFC),
          shape = RoundedCornerShape(12.dp),
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(modifier = Modifier.padding(14.dp)) {
            Text(
              text = "নির্বাচিত কাজের সারাংশ:",
              style = MaterialTheme.typography.titleSmall,
              color = NavyDark
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
              text = "• সুইচ/সকেট: $switchPoints টি\n• লাইট/ফ্যান: $lightFanPoints টি\n• বাথরুম: $bathroomCount টি\n• মেইন বোর্ড: ${if (hasMainDb) "হ্যাঁ" else "না"}\n• পানির মোটর: ${if (hasPumpMotor) "হ্যাঁ" else "না"}",
              style = MaterialTheme.typography.bodyMedium,
              color = TextSecondary,
              lineHeight = 22.sp
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
              text = "* সাইট পরিদর্শন ও তারের দূরত্বের ওপর নির্ভর করে নিখুঁত বাজেট জানিয়ে দেওয়া হবে।",
              style = MaterialTheme.typography.labelSmall,
              color = SkyBlue
            )
          }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
          onClick = {
            val summary = buildString {
              append("আসসালামু আলাইকুম মাজু ভাই। আমার বাসাবাড়ির জন্য একটি কাজের হিসাব প্রয়োজন:")
              append("\n- সুইচ/সকেট পয়েন্ট: $switchPoints টি")
              append("\n- লাইট/ফ্যান পয়েন্ট: $lightFanPoints টি")
              append("\n- বাথরুম স্যানিটারি: $bathroomCount টি")
              append("\n- মেইন ডিবি বোর্ড: ${if (hasMainDb) "হ্যাঁ" else "না"}")
              append("\n- পানির মোটর স্থাপন: ${if (hasPumpMotor) "হ্যাঁ" else "না"}")
              append("\nএ কাজের সম্ভাব্য বাজেট ও সময় কেমন লাগতে পারে জানালে উপকৃত হতাম।")
            }
            onSendEstimateWhatsApp(summary)
          },
          modifier = Modifier.fillMaxWidth(),
          shape = RoundedCornerShape(12.dp),
          colors = ButtonDefaults.buttonColors(containerColor = WhatsAppGreen)
        ) {
          Icon(
            imageVector = Icons.Default.Whatsapp,
            contentDescription = null,
            modifier = Modifier.size(18.dp)
          )
          Spacer(modifier = Modifier.width(8.dp))
          Text(
            text = "এই হিসাব হোয়াটসঅ্যাপে পাঠান",
            style = MaterialTheme.typography.labelLarge,
            color = Color.White
          )
        }
      }
    }
  }
}

@Composable
private fun EstimatorCounterRow(
  title: String,
  subtitle: String,
  count: Int,
  onIncrement: () -> Unit,
  onDecrement: () -> Unit
) {
  Row(
    modifier = Modifier.fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceBetween
  ) {
    Column(modifier = Modifier.weight(1f)) {
      Text(
        text = title,
        style = MaterialTheme.typography.titleSmall,
        color = TextPrimary
      )
      Text(
        text = subtitle,
        style = MaterialTheme.typography.bodySmall,
        color = TextSecondary
      )
    }

    Row(
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
      OutlinedIconButton(
        onClick = onDecrement,
        modifier = Modifier.size(34.dp),
        shape = CircleShape
      ) {
        Icon(imageVector = Icons.Default.Remove, contentDescription = "কমান", modifier = Modifier.size(16.dp))
      }

      Text(
        text = "$count",
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.Bold,
        color = NavyDark,
        modifier = Modifier.width(28.dp),
        textAlign = androidx.compose.ui.text.style.TextAlign.Center
      )

      OutlinedIconButton(
        onClick = onIncrement,
        modifier = Modifier.size(34.dp),
        shape = CircleShape
      ) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "বাড়ান", modifier = Modifier.size(16.dp))
      }
    }
  }
}
