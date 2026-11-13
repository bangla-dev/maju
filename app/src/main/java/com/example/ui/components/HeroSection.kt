package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.PhotoLibrary
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.R
import com.example.data.PortfolioData
import com.example.ui.theme.ElectricYellow
import com.example.ui.theme.NavyDark
import com.example.ui.theme.NavyPrimary
import com.example.ui.theme.SkyBlue
import com.example.ui.theme.SkyBlueContainer
import com.example.ui.theme.TextMuted
import com.example.ui.theme.TextPrimary
import com.example.ui.theme.TextSecondary

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HeroSection(
  onViewWorkClick: () -> Unit,
  onContactClick: () -> Unit,
  onOpenEstimatorClick: () -> Unit,
  modifier: Modifier = Modifier
) {
  Column(
    modifier = modifier.fillMaxWidth(),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    // 1. Cover Photo with Gradient Overlay
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .aspectRatio(16f / 7f)
    ) {
      AsyncImage(
        model = PortfolioData.COVER_IMAGE_URL,
        placeholder = painterResource(id = R.drawable.img_cover),
        error = painterResource(id = R.drawable.img_cover),
        contentDescription = "মাজু ইলেকট্রিশিয়ানের কভার ব্যানার",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
      )

      // Navy-black tinted overlay to ensure text contrast and premium aesthetic
      Box(
        modifier = Modifier
          .fillMaxSize()
          .background(
            Brush.verticalGradient(
              colors = listOf(
                NavyDark.copy(alpha = 0.45f),
                NavyDark.copy(alpha = 0.85f)
              )
            )
          )
      )

      // Badges over cover
      Row(
        modifier = Modifier
          .align(Alignment.TopEnd)
          .padding(12.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
      ) {
        Surface(
          color = ElectricYellow,
          shape = RoundedCornerShape(20.dp),
          shadowElevation = 3.dp
        ) {
          Row(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically
          ) {
            Icon(
              imageVector = Icons.Default.Star,
              contentDescription = null,
              tint = NavyDark,
              modifier = Modifier.size(14.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
              text = "৮+ বছর",
              fontSize = 12.sp,
              fontWeight = FontWeight.Bold,
              color = NavyDark
            )
          }
        }
      }
    }

    // 2. Profile Photo overlapping the cover boundary
    Box(
      modifier = Modifier
        .offset(y = (-55).dp)
        .padding(horizontal = 16.dp),
      contentAlignment = Alignment.Center
    ) {
      Box(
        modifier = Modifier
          .size(114.dp)
          .shadow(10.dp, CircleShape)
          .border(4.dp, Color.White, CircleShape)
          .clip(CircleShape)
          .background(NavyPrimary)
      ) {
        AsyncImage(
          model = PortfolioData.PROFILE_IMAGE_URL,
          placeholder = painterResource(id = R.drawable.img_profile),
          error = painterResource(id = R.drawable.img_profile),
          contentDescription = "মাজু ইলেকট্রিশিয়ানের প্রোফাইল ছবি",
          contentScale = ContentScale.Crop,
          modifier = Modifier.fillMaxSize()
        )
      }
    }

    // 3. Name, Profession & Location
    Column(
      modifier = Modifier
        .offset(y = (-45).dp)
        .padding(horizontal = 16.dp),
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Text(
        text = PortfolioData.NAME,
        style = MaterialTheme.typography.displayMedium,
        color = NavyDark,
        textAlign = TextAlign.Center
      )

      Spacer(modifier = Modifier.height(4.dp))

      Text(
        text = PortfolioData.PROFESSION,
        style = MaterialTheme.typography.titleMedium,
        color = SkyBlue,
        fontWeight = FontWeight.SemiBold,
        textAlign = TextAlign.Center
      )

      Spacer(modifier = Modifier.height(8.dp))

      // Badges
      FlowRow(
        horizontalArrangement = Arrangement.Center,
        verticalArrangement = Arrangement.spacedBy(6.dp),
        modifier = Modifier.fillMaxWidth()
      ) {
        Surface(
          color = SkyBlueContainer,
          shape = RoundedCornerShape(16.dp),
          modifier = Modifier.padding(horizontal = 4.dp)
        ) {
          Row(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
            verticalAlignment = Alignment.CenterVertically
          ) {
            Icon(
              imageVector = Icons.Default.LocationOn,
              contentDescription = null,
              tint = NavyPrimary,
              modifier = Modifier.size(14.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
              text = PortfolioData.LOCATION_PRIMARY,
              style = MaterialTheme.typography.labelMedium,
              color = NavyPrimary
            )
          }
        }

        Surface(
          color = Color(0xFFFEF3C7),
          shape = RoundedCornerShape(16.dp),
          modifier = Modifier.padding(horizontal = 4.dp)
        ) {
          Row(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
            verticalAlignment = Alignment.CenterVertically
          ) {
            Icon(
              imageVector = Icons.Default.Star,
              contentDescription = null,
              tint = Color(0xFFB45309),
              modifier = Modifier.size(14.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
              text = PortfolioData.EXPERIENCE,
              style = MaterialTheme.typography.labelMedium,
              color = Color(0xFFB45309),
              fontWeight = FontWeight.Bold
            )
          }
        }
      }

      Spacer(modifier = Modifier.height(16.dp))

      // 4. Intro Text Card
      Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
          containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
      ) {
        Column(
          modifier = Modifier.padding(16.dp)
        ) {
          Text(
            text = PortfolioData.INTRO_TEXT,
            style = MaterialTheme.typography.bodyLarge,
            color = TextSecondary,
            lineHeight = 25.sp,
            textAlign = TextAlign.Start
          )
        }
      }

      Spacer(modifier = Modifier.height(16.dp))

      // 5. Action Buttons ("আমার কাজ দেখুন" and "যোগাযোগ করুন")
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
      ) {
        Button(
          onClick = onViewWorkClick,
          modifier = Modifier
            .weight(1f)
            .height(48.dp)
            .testTag("btn_view_work"),
          shape = RoundedCornerShape(12.dp),
          colors = ButtonDefaults.buttonColors(
            containerColor = NavyPrimary,
            contentColor = Color.White
          )
        ) {
          Icon(
            imageVector = Icons.Default.PhotoLibrary,
            contentDescription = null,
            modifier = Modifier.size(18.dp)
          )
          Spacer(modifier = Modifier.width(6.dp))
          Text(
            text = "আমার কাজ দেখুন",
            style = MaterialTheme.typography.labelLarge
          )
        }

        Button(
          onClick = onContactClick,
          modifier = Modifier
            .weight(1f)
            .height(48.dp)
            .testTag("btn_contact_hero"),
          shape = RoundedCornerShape(12.dp),
          colors = ButtonDefaults.buttonColors(
            containerColor = SkyBlue,
            contentColor = Color.White
          )
        ) {
          Icon(
            imageVector = Icons.Default.Phone,
            contentDescription = null,
            modifier = Modifier.size(18.dp)
          )
          Spacer(modifier = Modifier.width(6.dp))
          Text(
            text = "যোগাযোগ করুন",
            style = MaterialTheme.typography.labelLarge
          )
        }
      }

      Spacer(modifier = Modifier.height(10.dp))

      // Estimator banner
      OutlinedButton(
        onClick = onOpenEstimatorClick,
        modifier = Modifier
          .fillMaxWidth()
          .height(46.dp)
          .testTag("btn_open_estimator"),
        shape = RoundedCornerShape(12.dp)
      ) {
        Icon(
          imageVector = Icons.Default.Calculate,
          contentDescription = null,
          tint = SkyBlue,
          modifier = Modifier.size(18.dp)
        )
        Spacer(modifier = Modifier.width(6.dp))
        Text(
          text = "কাজের আনুমানিক খরচ ক্যালকুলেটর",
          style = MaterialTheme.typography.labelLarge,
          color = SkyBlue
        )
      }
    }
  }
}
