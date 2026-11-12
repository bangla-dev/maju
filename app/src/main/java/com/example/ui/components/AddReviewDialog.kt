package com.example.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.model.CustomerReview
import com.example.ui.theme.ElectricYellow
import com.example.ui.theme.NavyDark
import com.example.ui.theme.SkyBlue
import com.example.ui.theme.TextSecondary
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.UUID

@Composable
fun AddReviewDialog(
  onDismiss: () -> Unit,
  onSubmit: (CustomerReview) -> Unit
) {
  var name by remember { mutableStateOf("") }
  var location by remember { mutableStateOf("") }
  var serviceTaken by remember { mutableStateOf("বৈদ্যুতিক ওয়্যারিং") }
  var rating by remember { mutableIntStateOf(5) }
  var comment by remember { mutableStateOf("") }
  var errorMessage by remember { mutableStateOf<String?>(null) }

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
          Text(
            text = "আপনার মতামত জানান",
            style = MaterialTheme.typography.titleMedium,
            color = NavyDark
          )
          IconButton(onClick = onDismiss) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "বন্ধ করুন")
          }
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Rating Stars Picker
        Text(
          text = "কাজের সন্তুষ্টির রেটিং:",
          style = MaterialTheme.typography.bodyMedium,
          color = TextSecondary
        )
        Row(
          modifier = Modifier.padding(vertical = 6.dp),
          horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
          (1..5).forEach { starIndex ->
            Icon(
              imageVector = if (starIndex <= rating) Icons.Filled.Star else Icons.Outlined.Star,
              contentDescription = "$starIndex স্টার",
              tint = if (starIndex <= rating) ElectricYellow else Color.LightGray,
              modifier = Modifier
                .size(32.dp)
                .clickable { rating = starIndex }
            )
          }
        }

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
          value = name,
          onValueChange = { name = it },
          label = { Text("আপনার নাম") },
          singleLine = true,
          modifier = Modifier.fillMaxWidth(),
          shape = RoundedCornerShape(10.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
          value = location,
          onValueChange = { location = it },
          label = { Text("আপনার এলাকা (যেমন: ত্রিশাল পৌরসভা)") },
          singleLine = true,
          modifier = Modifier.fillMaxWidth(),
          shape = RoundedCornerShape(10.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
          text = "যে সেবা নিয়েছেন:",
          style = MaterialTheme.typography.bodyMedium,
          color = TextSecondary
        )
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
          horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
          listOf("বৈদ্যুতিক ওয়্যারিং", "স্যানিটারি", "পানির মোটর").forEach { s ->
            FilterChip(
              selected = serviceTaken == s,
              onClick = { serviceTaken = s },
              label = { Text(s, style = MaterialTheme.typography.labelSmall) },
              colors = FilterChipDefaults.filterChipColors(
                selectedContainerColor = SkyBlue,
                selectedLabelColor = Color.White
              )
            )
          }
        }

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
          value = comment,
          onValueChange = { comment = it },
          label = { Text("আপনার মন্তব্য ও অভিজ্ঞতা") },
          minLines = 3,
          maxLines = 5,
          modifier = Modifier.fillMaxWidth(),
          shape = RoundedCornerShape(10.dp)
        )

        if (errorMessage != null) {
          Spacer(modifier = Modifier.height(8.dp))
          Text(
            text = errorMessage!!,
            color = MaterialTheme.colorScheme.error,
            style = MaterialTheme.typography.bodySmall
          )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
          OutlinedButton(
            onClick = onDismiss,
            modifier = Modifier.weight(1f),
            shape = RoundedCornerShape(10.dp)
          ) {
            Text("বাতিল")
          }

          Button(
            onClick = {
              if (name.isBlank()) {
                errorMessage = "অনুগ্রহ করে আপনার নাম লিখুন"
                return@Button
              }
              if (comment.isBlank()) {
                errorMessage = "অনুগ্রহ করে আপনার মন্তব্য লিখুন"
                return@Button
              }
              val currentDate = SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(Date())
              onSubmit(
                CustomerReview(
                  id = UUID.randomUUID().toString(),
                  name = name.trim(),
                  location = if (location.isNotBlank()) location.trim() else "ত্রিশাল",
                  serviceTaken = serviceTaken,
                  rating = rating,
                  comment = comment.trim(),
                  date = currentDate
                )
              )
            },
            modifier = Modifier.weight(1f),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = SkyBlue)
          ) {
            Text("জমা দিন")
          }
        }
      }
    }
  }
}
