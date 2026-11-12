package com.example.data

import com.example.R
import com.example.model.GalleryItem
import com.example.model.ServiceCategory
import com.example.model.WorkArea

object PortfolioData {
  const val NAME = "মাজু ইলেকট্রিশিয়ান"
  const val PROFESSION = "ইলেকট্রিক্যাল ও স্যানিটারি কাজের কারিগর"
  const val EXPERIENCE = "৮ বছরের বেশি অভিজ্ঞতা"
  const val LOCATION_PRIMARY = "ত্রিশাল, ময়মনসিংহ, বাংলাদেশ"
  
  const val PHONE_NUMBER = "01999234828"
  const val WHATSAPP_NUMBER = "01758663620"
  const val WHATSAPP_URL = "https://wa.me/8801758663620"
  const val CALL_URI = "tel:+8801999234828"
  const val FACEBOOK_URL = "https://www.facebook.com/share/1cdgq2jxQt/"

  const val INTRO_TEXT = "আসসালামু আলাইকুম। আমি মাজু ইলেকট্রিশিয়ান। দীর্ঘ ৮ বছরের বেশি সময় ধরে বাসাবাড়ির বৈদ্যুতিক ওয়্যারিং, নতুন বাড়ির বৈদ্যুতিক সংযোগ, সুইচ-সকেট ও লাইট-ফ্যান ফিটিং, বাথরুমের স্যানিটারি কাজ এবং পানির মোটর স্থাপনের কাজ করে আসছি। আমি ত্রিশাল, ময়মনসিংহ এবং প্রয়োজন অনুযায়ী ময়মনসিংহ জেলার বিভিন্ন এলাকায় সেবা দিয়ে থাকি।"

  const val ABOUT_DETAILS = "আমি কাজের গুণমান এবং নিরাপত্তাকে সর্বোচ্চ অগ্রাধিকার দিই। বৈদ্যুতিক কাজের প্রতিটি ধাপে সঠিক মাপের তার ও নিরাপত্তা সার্কিট নিশ্চিত করি, যাতে ভবিষ্যতে কোনো দুর্ঘটনার ঝুঁকি না থাকে। স্যানিটারি ও পানির মোটরের কাজে সঠিক প্রেসার এবং লিকেজ-মুক্ত পাইপলাইন সংযোগে বিশেষভাবে যত্নবান থাকি।"

  val services = listOf(
    ServiceCategory(
      id = "electrical",
      title = "বৈদ্যুতিক ওয়্যারিং",
      subtitle = "নিরাপদ, আধুনিক ও ত্রুটিহীন ওয়্যারিং সেবা",
      iconName = "flash",
      items = listOf(
        "নতুন বাড়ির সম্পূর্ণ ওয়্যারিং",
        "পুরোনো বাড়ির ওয়্যারিং পরিবর্তন",
        "বৈদ্যুতিক তার সংযোগ",
        "সুইচ ও সকেট স্থাপন",
        "লাইট ও ফ্যান ফিটিং",
        "বৈদ্যুতিক বোর্ড ও এমসিবি স্থাপন"
      )
    ),
    ServiceCategory(
      id = "sanitary",
      title = "স্যানিটারি কাজ",
      subtitle = "উন্নত মানের বাথরুম ও পাইপ ফিটিংস",
      iconName = "plumbing",
      items = listOf(
        "বাথরুমের স্যানিটারি কাজ",
        "কমোড ও বেসিন স্থাপন",
        "পানির কল ও শাওয়ার ফিটিং",
        "পানির পাইপলাইন সংযোগ",
        "নতুন বাথরুমের স্যানিটারি ফিটিং"
      )
    ),
    ServiceCategory(
      id = "pump",
      title = "পানির মোটর স্থাপন",
      subtitle = "টেকসই ও লিকেজ-মুক্ত পানির মোটর সংযোগ",
      iconName = "water",
      items = listOf(
        "নতুন পানির মোটর স্থাপন",
        "মোটরের পানির পাইপ সংযোগ",
        "প্রয়োজনীয় ফিটিং ও টেস্ট রান"
      )
    )
  )

  val galleryItems = listOf(
    GalleryItem(
      id = "g1",
      title = "মেইন ডিস্ট্রিবিউশন বোর্ড ও এমসিবি ওয়্যারিং",
      categoryId = "electrical",
      categoryName = "বৈদ্যুতিক ওয়্যারিং",
      imageRes = R.drawable.gallery_elec_wiring,
      description = "বাসাবাড়ির প্রতিটি রুমের জন্য সঠিক অ্যাম্পিয়ারের এমসিবি (সার্কিট ব্রেকার) ও কালার-কোডেড তারের সুশৃঙ্খল সংযোগ।",
      isSample = true
    ),
    GalleryItem(
      id = "g2",
      title = "আধুনিক সুইচ বোর্ড ও আর্কিটেকচারাল লাইটিং",
      categoryId = "electrical",
      categoryName = "বৈদ্যুতিক ওয়্যারিং",
      imageRes = R.drawable.gallery_switch_lighting,
      description = "দেয়ালে আধুনিক পিয়ানো/মডুলার সুইচ ও সিলিংয়ে দৃষ্টিসুখকর ওয়ার্ম এলইডি লাইট ফিটিংস।",
      isSample = true
    ),
    GalleryItem(
      id = "g3",
      title = "লাক্সারি বাথরুম স্যানিটারি ও শাওয়ার সেটআপ",
      categoryId = "sanitary",
      categoryName = "স্যানিটারি কাজ",
      imageRes = R.drawable.gallery_sanitary_bath,
      description = "প্রিমিয়াম ক্রোম ওয়াটার শাওয়ার মিক্সার, কল ও কনসিলড পাইপিংয়ের লিকেজ-মুক্ত ফিটিংস।",
      isSample = true
    ),
    GalleryItem(
      id = "g4",
      title = "রেসিডেন্সিয়াল ওয়াটার পাম্প মোটর ও পাইপলাইন",
      categoryId = "pump",
      categoryName = "পানির মোটর",
      imageRes = R.drawable.gallery_water_pump,
      description = "শক্তিশালী পাম্প মোটর ইনস্টলেশন, উচ্চ চাপের পিভিসি পাইপলাইন, প্রেসার গেজ ও নিরাপদ কন্ট্রোল সুইচ।",
      isSample = true
    )
  )

  val workAreas = listOf(
    WorkArea(
      title = "ত্রিশাল",
      coverage = "ত্রিশাল পৌরসভা এবং সকল ইউনিয়নভুক্ত গ্রাম",
      isPrimary = true
    ),
    WorkArea(
      title = "ময়মনসিংহ সদর",
      coverage = "ময়মনসিংহ সিটি কর্পোরেশন ও সদর উপজেলা এলাকা",
      isPrimary = false
    ),
    WorkArea(
      title = "ময়মনসিংহ জেলার অন্যান্য এলাকা",
      coverage = "চুক্তি ও প্রয়োজন সাপেক্ষে ফুলবাড়িয়া, মুক্তাগাছা, ভালুকা ইত্যাদি",
      isPrimary = false
    )
  )
}
