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
import androidx.compose.material.icons.filled.AddComment
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.RateReview
import androidx.compose.material.icons.filled.Star
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.CustomerReview
import com.example.ui.theme.ElectricYellow
import com.example.ui.theme.NavyDark
import com.example.ui.theme.NavyPrimary
import com.example.ui.theme.SkyBlue
import com.example.ui.theme.SkyBlueContainer
import com.example.ui.theme.TextMuted
import com.example.ui.theme.TextPrimary
import com.example.ui.theme.TextSecondary

@Composable
fun ReviewsSection(
  reviews: List<CustomerReview>,
  onAddReviewClick: () -> Unit,
  modifier: Modifier = Modifier
) {
  Column(
    modifier = modifier
      .fillMaxWidth()
      .padding(horizontal = 16.dp, vertical = 12.dp)
  ) {
    SectionHeader(
      title = "গ্রাহকদের মতামত",
      subtitle = "সেবা গ্রহণকারী সম্মানিত গ্রাহকদের বাস্তব অভিজ্ঞতা"
    )

    Spacer(modifier = Modifier.height(14.dp))

    if (reviews.isEmpty()) {
      // Per instructions: "প্রাথমিকভাবে কোনো মতামত না থাকলে সুন্দরভাবে লিখবেন যে গ্রাহকদের মতামত এখানে যুক্ত করা হবে।"
      Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
      ) {
        Column(
          modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          Box(
            modifier = Modifier
              .size(56.dp)
              .background(SkyBlueContainer, CircleShape),
            contentAlignment = Alignment.Center
          ) {
            Icon(
              imageVector = Icons.Default.RateReview,
              contentDescription = null,
              tint = NavyPrimary,
              modifier = Modifier.size(30.dp)
            )
          }

          Spacer(modifier = Modifier.height(12.dp))

          Text(
            text = "সম্মানিত গ্রাহকদের মতামত শীঘ্রই এখানে যুক্ত হবে",
            style = MaterialTheme.typography.titleSmall,
            color = NavyDark,
            textAlign = TextAlign.Center
          )

          Spacer(modifier = Modifier.height(6.dp))

          Text(
            text = "কাজের শতভাগ সততা ও স্বচ্ছতা বজায় রাখতে কোনো ভুয়া মতামত বা রেটিং প্রদর্শন করা হয় না। আপনি যদি আমার কাজের সেবা গ্রহণ করে থাকেন, তবে আপনার মূল্যবান অভিজ্ঞতা যুক্ত করতে পারেন।",
            style = MaterialTheme.typography.bodyMedium,
            color = TextSecondary,
            textAlign = TextAlign.Center,
            lineHeight = 22.sp
          )

          Spacer(modifier = Modifier.height(16.dp))

          Button(
            onClick = onAddReviewClick,
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = SkyBlue)
          ) {
            Icon(
              imageVector = Icons.Default.AddComment,
              contentDescription = null,
              modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
              text = "আপনার মতামত জানান",
              style = MaterialTheme.typography.labelLarge
            )
          }
        }
      }
    } else {
      Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        reviews.forEach { review ->
          ReviewCard(review = review)
        }

        Spacer(modifier = Modifier.height(6.dp))

        OutlinedButton(
          onClick = onAddReviewClick,
          modifier = Modifier.fillMaxWidth(),
          shape = RoundedCornerShape(12.dp)
        ) {
          Icon(
            imageVector = Icons.Default.AddComment,
            contentDescription = null,
            tint = SkyBlue,
            modifier = Modifier.size(18.dp)
          )
          Spacer(modifier = Modifier.width(6.dp))
          Text(
            text = "নতুন মতামত যুক্ত করুন",
            style = MaterialTheme.typography.labelLarge,
            color = SkyBlue
          )
        }
      }
    }
  }
}

@Composable
fun ReviewCard(
  review: CustomerReview,
  modifier: Modifier = Modifier
) {
  Card(
    modifier = modifier.fillMaxWidth(),
    shape = RoundedCornerShape(14.dp),
    colors = CardDefaults.cardColors(containerColor = Color.White),
    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
  ) {
    Column(modifier = Modifier.padding(16.dp)) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
      ) {
        Box(
          modifier = Modifier
            .size(40.dp)
            .background(SkyBlueContainer, CircleShape),
          contentAlignment = Alignment.Center
        ) {
          Icon(
            imageVector = Icons.Default.Person,
            contentDescription = null,
            tint = NavyPrimary,
            modifier = Modifier.size(24.dp)
          )
        }

        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {
          Text(
            text = review.name,
            style = MaterialTheme.typography.titleSmall,
            color = NavyDark
          )
          Text(
            text = "${review.location} • ${review.serviceTaken}",
            style = MaterialTheme.typography.bodySmall,
            color = TextMuted
          )
        }

        // Star rating
        Row {
          repeat(review.rating) {
            Icon(
              imageVector = Icons.Default.Star,
              contentDescription = null,
              tint = ElectricYellow,
              modifier = Modifier.size(16.dp)
            )
          }
        }
      }

      Spacer(modifier = Modifier.height(10.dp))

      Text(
        text = review.comment,
        style = MaterialTheme.typography.bodyMedium,
        color = TextSecondary,
        lineHeight = 22.sp
      )

      if (review.date.isNotEmpty()) {
        Spacer(modifier = Modifier.height(6.dp))
        Text(
          text = review.date,
          style = MaterialTheme.typography.labelSmall,
          color = TextMuted
        )
      }
    }
  }
}
