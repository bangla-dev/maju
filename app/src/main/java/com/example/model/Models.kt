package com.example.model

import androidx.annotation.DrawableRes

data class ServiceCategory(
  val id: String,
  val title: String,
  val subtitle: String,
  val iconName: String,
  val items: List<String>
)

data class GalleryItem(
  val id: String,
  val title: String,
  val categoryId: String,
  val categoryName: String,
  @DrawableRes val imageRes: Int,
  val description: String,
  val isSample: Boolean = true
)

data class CustomerReview(
  val id: String,
  val name: String,
  val location: String,
  val serviceTaken: String,
  val rating: Int,
  val comment: String,
  val date: String
)

data class WorkArea(
  val title: String,
  val coverage: String,
  val isPrimary: Boolean = false
)
