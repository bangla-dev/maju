package com.example.ui

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.Whatsapp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.data.PortfolioData
import com.example.model.CustomerReview
import com.example.model.GalleryItem
import com.example.model.ServiceCategory
import com.example.ui.components.AboutSection
import com.example.ui.components.AddReviewDialog
import com.example.ui.components.ContactSection
import com.example.ui.components.EstimatorDialog
import com.example.ui.components.ExperienceSection
import com.example.ui.components.FloatingContactButtons
import com.example.ui.components.FooterSection
import com.example.ui.components.GallerySection
import com.example.ui.components.HeroSection
import com.example.ui.components.ImageDetailDialog
import com.example.ui.components.LocationSection
import com.example.ui.components.ReviewsSection
import com.example.ui.components.ServicesSection
import com.example.ui.theme.CallBlue
import com.example.ui.theme.NavyDark
import com.example.ui.theme.NavyPrimary
import com.example.ui.theme.SkyBlue
import com.example.ui.theme.SurfaceLight
import com.example.ui.theme.WhatsAppGreen
import kotlinx.coroutines.launch
import java.net.URLEncoder

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
  val context = LocalContext.current
  val coroutineScope = rememberCoroutineScope()
  val listState = rememberLazyListState()

  // Dynamic state for reviews
  val reviews = remember {
    mutableStateListOf<CustomerReview>()
  }

  // Dialog States
  var selectedGalleryItem by remember { mutableStateOf<GalleryItem?>(null) }
  var isAddReviewOpen by remember { mutableStateOf(false) }
  var isEstimatorOpen by remember { mutableStateOf(false) }

  // Action helpers
  val openWhatsApp = { customText: String? ->
    try {
      val url = if (!customText.isNullOrBlank()) {
        val encoded = URLEncoder.encode(customText, "UTF-8")
        "${PortfolioData.WHATSAPP_URL}?text=$encoded"
      } else {
        PortfolioData.WHATSAPP_URL
      }
      val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
      context.startActivity(intent)
    } catch (e: Exception) {
      Toast.makeText(context, "হোয়াটসঅ্যাপ খুলতে সমস্যা হয়েছে", Toast.LENGTH_SHORT).show()
    }
  }

  val openDialer = {
    try {
      val intent = Intent(Intent.ACTION_DIAL, Uri.parse(PortfolioData.CALL_URI))
      context.startActivity(intent)
    } catch (e: Exception) {
      Toast.makeText(context, "ফোন ডায়ালার খুলতে সমস্যা হয়েছে", Toast.LENGTH_SHORT).show()
    }
  }

  val openFacebook = {
    try {
      val intent = Intent(Intent.ACTION_VIEW, Uri.parse(PortfolioData.FACEBOOK_URL))
      context.startActivity(intent)
    } catch (e: Exception) {
      Toast.makeText(context, "ফেসবুক লিংক খুলতে সমস্যা হয়েছে", Toast.LENGTH_SHORT).show()
    }
  }

  Scaffold(
    topBar = {
      TopAppBar(
        title = {
          Text(
            text = PortfolioData.NAME,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = Color.White
          )
        },
        actions = {
          IconButton(
            onClick = { isEstimatorOpen = true },
            modifier = Modifier.testTag("topbar_estimator")
          ) {
            Icon(
              imageVector = Icons.Default.Calculate,
              contentDescription = "খরচ ক্যালকুলেটর",
              tint = Color.White
            )
          }
          IconButton(
            onClick = { openWhatsApp(null) },
            modifier = Modifier.testTag("topbar_whatsapp")
          ) {
            Icon(
              imageVector = Icons.Default.Whatsapp,
              contentDescription = "হোয়াটসঅ্যাপ",
              tint = WhatsAppGreen
            )
          }
          IconButton(
            onClick = openDialer,
            modifier = Modifier.testTag("topbar_call")
          ) {
            Icon(
              imageVector = Icons.Default.Call,
              contentDescription = "কল দিন",
              tint = SkyBlue
            )
          }
        },
        colors = TopAppBarDefaults.topAppBarColors(
          containerColor = NavyDark
        )
      )
    },
    containerColor = SurfaceLight
  ) { paddingValues ->
    Box(
      modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues)
    ) {
      LazyColumn(
        state = listState,
        modifier = Modifier.fillMaxSize()
      ) {
        // Item 0: Hero Section
        item {
          HeroSection(
            onViewWorkClick = {
              coroutineScope.launch {
                listState.animateScrollToItem(index = 3) // Gallery index
              }
            },
            onContactClick = {
              coroutineScope.launch {
                listState.animateScrollToItem(index = 7) // Contact index
              }
            },
            onOpenEstimatorClick = { isEstimatorOpen = true }
          )
        }

        // Item 1: About Section
        item {
          AboutSection()
        }

        // Item 2: Services Section
        item {
          ServicesSection(
            onServiceSelect = { service ->
              openWhatsApp("আসসালামু আলাইকুম মাজু ভাই। আমি '${service.title}' সেবার ব্যাপারে আপনার সাথে কথা বলতে আগ্রহী।")
            }
          )
        }

        // Item 3: Gallery Section
        item {
          GallerySection(
            onImageClick = { item ->
              selectedGalleryItem = item
            }
          )
        }

        // Item 4: Experience Section
        item {
          ExperienceSection()
        }

        // Item 5: Reviews Section
        item {
          ReviewsSection(
            reviews = reviews,
            onAddReviewClick = { isAddReviewOpen = true }
          )
        }

        // Item 6: Location Section
        item {
          LocationSection(
            onCallForAreaClick = openDialer
          )
        }

        // Item 7: Contact Section
        item {
          ContactSection(
            onCallClick = openDialer,
            onWhatsAppClick = { customMsg -> openWhatsApp(customMsg) },
            onFacebookClick = openFacebook
          )
        }

        // Item 8: Footer Section
        item {
          FooterSection(
            onWhatsAppClick = { openWhatsApp(null) },
            onCallClick = openDialer,
            onFacebookClick = openFacebook
          )
        }

        // Bottom space so FAB does not cover text
        item {
          Spacer(modifier = Modifier.height(80.dp))
        }
      }

      // Mandatory Floating Action Buttons (Bottom Right: Call & WhatsApp icons only)
      FloatingContactButtons(
        onWhatsAppClick = { openWhatsApp(null) },
        onCallClick = openDialer,
        modifier = Modifier.align(Alignment.BottomEnd)
      )

      // Dialogs
      selectedGalleryItem?.let { galleryItem ->
        ImageDetailDialog(
          item = galleryItem,
          onDismiss = { selectedGalleryItem = null },
          onInquireWhatsApp = { item ->
            selectedGalleryItem = null
            openWhatsApp("আসসালামু আলাইকুম মাজু ভাই। আপনার গ্যালারির '${item.title}' কাজের মতো আমার এখানে কাজ করাতে চাই। বিস্তারিত আলোচনা করতে আগ্রহী।")
          }
        )
      }

      if (isAddReviewOpen) {
        AddReviewDialog(
          onDismiss = { isAddReviewOpen = false },
          onSubmit = { newReview ->
            reviews.add(0, newReview)
            isAddReviewOpen = false
            Toast.makeText(context, "আপনার মূল্যবান মতামতের জন্য ধন্যবাদ!", Toast.LENGTH_SHORT).show()
          }
        )
      }

      if (isEstimatorOpen) {
        EstimatorDialog(
          onDismiss = { isEstimatorOpen = false },
          onSendEstimateWhatsApp = { estimateText ->
            isEstimatorOpen = false
            openWhatsApp(estimateText)
          }
        )
      }
    }
  }
}
