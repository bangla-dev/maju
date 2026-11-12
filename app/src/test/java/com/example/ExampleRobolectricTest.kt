package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.data.PortfolioData
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class ExampleRobolectricTest {

  @Test
  fun `read string from context`() {
    val context = ApplicationProvider.getApplicationContext<Context>()
    val appName = context.getString(R.string.app_name)
    assertEquals("মাজু ইলেকট্রিশিয়ান", appName)
  }

  @Test
  fun `verify portfolio data integrity`() {
    assertEquals("মাজু ইলেকট্রিশিয়ান", PortfolioData.NAME)
    assertEquals("01999234828", PortfolioData.PHONE_NUMBER)
    assertEquals("01758663620", PortfolioData.WHATSAPP_NUMBER)
    assertTrue(PortfolioData.services.isNotEmpty())
    assertTrue(PortfolioData.galleryItems.isNotEmpty())
    assertTrue(PortfolioData.workAreas.isNotEmpty())
  }
}
