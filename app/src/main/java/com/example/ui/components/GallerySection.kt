package com.example.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.ZoomIn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.PortfolioData
import com.example.model.GalleryItem
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
fun GallerySection(
  onImageClick: (GalleryItem) -> Unit,
  modifier: Modifier = Modifier
) {
  var selectedCategory by remember { mutableStateOf("all") }

  val filteredItems = remember(selectedCategory) {
    if (selectedCategory == "all") {
      PortfolioData.galleryItems
    } else {
      PortfolioData.galleryItems.filter { it.categoryId == selectedCategory }
    }
  }

  Column(
    modifier = modifier
      .fillMaxWidth()
      .padding(horizontal = 16.dp, vertical = 12.dp)
  ) {
    SectionHeader(
      title = "আমার কাজের ছবি ও নমুনা",
      subtitle = "ওয়্যারিং, বাথরুম ফিটিংস ও মোটর সংযোগের সচিত্র প্রদর্শনী"
    )

    Spacer(modifier = Modifier.height(10.dp))

    // Notice banner regarding sample reference images (per prompt instructions)
    Surface(
      color = Color(0xFFF1F5F9),
      shape = RoundedCornerShape(10.dp),
      modifier = Modifier.fillMaxWidth()
    ) {
      Row(
        modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
      ) {
        Icon(
          imageVector = Icons.Default.Info,
          contentDescription = null,
          tint = SkyBlue,
          modifier = Modifier.size(16.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
          text = "ছবিতে চাপ দিয়ে বিস্তারিত দেখুন। কাজের ধরণ ও ফিনিশিং প্রদর্শনে নমুনা চিত্র অন্তর্ভুক্ত।",
          style = MaterialTheme.typography.bodySmall,
          color = TextSecondary
        )
      }
    }

    Spacer(modifier = Modifier.height(12.dp))

    // Category Filter Chips
    FlowRow(
      horizontalArrangement = Arrangement.spacedBy(8.dp),
      verticalArrangement = Arrangement.spacedBy(6.dp),
      modifier = Modifier.fillMaxWidth()
    ) {
      val categories = listOf(
        "all" to "সকল ছবি",
        "electrical" to "বৈদ্যুতিক ওয়্যারিং",
        "sanitary" to "স্যানিটারি কাজ",
        "pump" to "পানির মোটর"
      )

      categories.forEach { (catId, label) ->
        val isSelected = selectedCategory == catId
        FilterChip(
          selected = isSelected,
          onClick = { selectedCategory = catId },
          label = {
            Text(
              text = label,
              style = MaterialTheme.typography.labelMedium
            )
          },
          colors = FilterChipDefaults.filterChipColors(
            selectedContainerColor = NavyPrimary,
            selectedLabelColor = Color.White,
            containerColor = Color.White,
            labelColor = NavyPrimary
          ),
          shape = RoundedCornerShape(12.dp)
        )
      }
    }

    Spacer(modifier = Modifier.height(14.dp))

    // Gallery Cards List
    Column(
      verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
      filteredItems.forEach { item ->
        GalleryCard(
          item = item,
          onClick = { onImageClick(item) }
        )
      }
    }
  }
}

@Composable
fun GalleryCard(
  item: GalleryItem,
  onClick: () -> Unit,
  modifier: Modifier = Modifier
) {
  Card(
    modifier = modifier
      .fillMaxWidth()
      .clickable(onClick = onClick),
    shape = RoundedCornerShape(16.dp),
    colors = CardDefaults.cardColors(containerColor = Color.White),
    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
  ) {
    Column {
      Box(
        modifier = Modifier
          .fillMaxWidth()
          .aspectRatio(16f / 10f)
      ) {
        Image(
          painter = painterResource(id = item.imageRes),
          contentDescription = item.title,
          contentScale = ContentScale.Crop,
          modifier = Modifier.fillMaxSize()
        )

        // Subtle gradient overlay at bottom
        Box(
          modifier = Modifier
            .fillMaxSize()
            .background(
              Brush.verticalGradient(
                colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.55f)),
                startY = 150f
              )
            )
        )

        // Top badges: Category + Sample indicator
        Row(
          modifier = Modifier
            .align(Alignment.TopStart)
            .padding(10.dp),
          horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
          Surface(
            color = NavyPrimary.copy(alpha = 0.9f),
            shape = RoundedCornerShape(8.dp)
          ) {
            Text(
              text = item.categoryName,
              style = MaterialTheme.typography.labelSmall,
              color = Color.White,
              modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
            )
          }

          if (item.isSample) {
            Surface(
              color = ElectricYellow.copy(alpha = 0.95f),
              shape = RoundedCornerShape(8.dp)
            ) {
              Text(
                text = "সার্ভিস নমুনা",
                style = MaterialTheme.typography.labelSmall,
                color = NavyDark,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
              )
            }
          }
        }

        // Tap to zoom hint icon
        Box(
          modifier = Modifier
            .align(Alignment.BottomEnd)
            .padding(10.dp)
            .background(Color.Black.copy(alpha = 0.6f), RoundedCornerShape(20.dp))
            .padding(horizontal = 8.dp, vertical = 4.dp)
        ) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
              imageVector = Icons.Default.ZoomIn,
              contentDescription = null,
              tint = Color.White,
              modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
              text = "বড় করে দেখুন",
              style = MaterialTheme.typography.labelSmall,
              color = Color.White
            )
          }
        }
      }

      // Title & Description
      Column(
        modifier = Modifier.padding(14.dp)
      ) {
        Text(
          text = item.title,
          style = MaterialTheme.typography.titleMedium,
          color = NavyDark
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
          text = item.description,
          style = MaterialTheme.typography.bodyMedium,
          color = TextSecondary,
          lineHeight = 21.sp
        )
      }
    }
  }
}
