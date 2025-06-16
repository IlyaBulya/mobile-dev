package com.cmota.unsplash.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cmota.unsplash.R
import com.cmota.unsplash.ui.theme.UnsplashTheme

@Composable
fun DetailsScreen(
  @DrawableRes image: Int,
  onAction: (Int) -> Unit = {}
) {
  Column(modifier = Modifier.fillMaxSize().background(Color.Black)) { // Set background to black
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .height(300.dp) // Adjust height as needed
    ) {
      Image(
        painter = painterResource(image),
        modifier = Modifier
          .fillMaxSize()
          .clickable(onClick = {
            onAction(image)
          }),
        contentScale = ContentScale.Crop,
        contentDescription = stringResource(R.string.description_bcn_sagrada_familia)
      )

      // Overlay for location
      Row(
        modifier = Modifier
          .align(Alignment.BottomStart)
          .padding(start = 16.dp, bottom = 16.dp)
          .background(Color.Black.copy(alpha = 0.5f), RoundedCornerShape(8.dp))
          .padding(horizontal = 8.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
      ) {
        Icon(
          Icons.Filled.LocationOn,
          contentDescription = "Location Pin",
          tint = Color.White,
          modifier = Modifier.size(16.dp)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
          text = stringResource(R.string.location_barcelona_spain), // This will be a string resource
          color = Color.White,
          fontSize = 12.sp
        )
      }
    }

    Column(modifier = Modifier.weight(1f).background(Color.Black)) {
      // User info and action buttons layer
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .offset(y = (20).dp) // Adjusted offset to move it further down
          .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
      ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
          Image(
            painter = painterResource(R.drawable.profile), // Placeholder for user avatar, assuming drawable exists. Please replace R.drawable.profile_avatar_1 with your actual avatar image resource.
            contentDescription = "User Avatar",
            modifier = Modifier
              .size(60.dp)
              .clip(CircleShape)
              .background(Color.Gray), // Placeholder background
            contentScale = ContentScale.Crop
          )
          Spacer(modifier = Modifier.width(8.dp))
          Text(
            text = stringResource(R.string.user_biel_morro), // This will be a string resource
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = Color.White
          )
        }

        Row {
          IconButton(onClick = { /* Handle download */ }) {
            Icon(Icons.Filled.Download, contentDescription = "Download", tint = Color.White)
          }
          IconButton(onClick = { /* Handle like */ }) {
            Icon(Icons.Filled.Favorite, contentDescription = "Like", tint = Color.White)
          }
          IconButton(onClick = { /* Handle bookmark */ }) {
            Icon(Icons.Filled.Bookmark, contentDescription = "Bookmark", tint = Color.White)
          }
        }
      }
      HorizontalDivider(
        modifier = Modifier
          .fillMaxWidth()
          .offset(y = (20).dp)
          .padding(16.dp),
        thickness = 1.dp,
        color = Color.LightGray
      )

      // Original Photo Info Rows - adjust padding
      Column(modifier = Modifier.padding(top = 16.dp)) {
        Row {
          AddPhotoInfoRow(
            title1 = R.string.info_camera,
            subtitle1 = R.string.info_camera_placeholder,
            title2 = R.string.info_aperture,
            subtitle2 = R.string.info_aperture_placeholder
          )
        }

        Row {
          AddPhotoInfoRow(
            title1 = R.string.info_focal_length,
            subtitle1 = R.string.info_focal_length_placeholder,
            title2 = R.string.info_shutter_speed,
            subtitle2 = R.string.info_shutter_speed_placeholder
          )
        }

        Row {
          AddPhotoInfoRow(
            title1 = R.string.info_iso,
            subtitle1 = R.string.info_iso_placeholder,
            title2 = R.string.info_dimensions,
            subtitle2 = R.string.info_dimensions_placeholder
          )
        }
      }

      HorizontalDivider(
        modifier = Modifier
          .fillMaxWidth()
          .padding(16.dp),
        thickness = 1.dp,
        color = Color.LightGray
      )

      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
      ) {
        Column(
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          Text(stringResource(R.string.info_views), color = Color.White)
          Text(stringResource(R.string.info_views_placeholder), color = Color.White)
        }

        Column(
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          Text(stringResource(R.string.info_downloads), color = Color.White)
          Text(stringResource(R.string.info_downloads_placeholder), color = Color.White)
        }

        Column(
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          Text(stringResource(R.string.info_likes), color = Color.White)
          Text(stringResource(R.string.info_likes_placeholder), color = Color.White)
        }
      }
      HorizontalDivider(
        modifier = Modifier
          .fillMaxWidth()
          .padding(16.dp),
        thickness = 1.dp,
        color = Color.LightGray
      )
      Spacer(modifier = Modifier.height(0.dp)) // Add some space before the buttons

      // Tag buttons
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.Center
      ) {
        Button(
          onClick = { /* Handle Barcelona tag click */ },
          colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray), // Dark background for tags
          shape = RoundedCornerShape(50) // Rounded corners for tags
        ) {
          Text(text = stringResource(R.string.tag_barcelona), color = Color.White) // This will be a string resource
        }
        Spacer(modifier = Modifier.width(8.dp))
        Button(
          onClick = { /* Handle Spain tag click */ },
          colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
          shape = RoundedCornerShape(50)
        ) {
          Text(text = stringResource(R.string.tag_spain), color = Color.White) // This will be a string resource
        }
      }
    }
  }
}

@Composable
fun AddPhotoInfoRow(
  @StringRes title1: Int,
  @StringRes subtitle1: Int,
  @StringRes title2: Int,
  @StringRes subtitle2: Int
) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 16.dp, vertical = 8.dp),
    horizontalArrangement = Arrangement.SpaceBetween
  ) {
    Column(
      modifier = Modifier
        .weight(1f)
        .padding(end = 8.dp)
    ) {
      Text(
        text = stringResource(id = title1),
        fontWeight = FontWeight.Bold,
        color = Color.White
      )
      Text(
        text = stringResource(id = subtitle1),
        color = Color.White
      )
    }

    Column(
      modifier = Modifier
        .weight(1f)
        .padding(start = 8.dp)
    ) {
      Text(
        text = stringResource(id = title2),
        fontWeight = FontWeight.Bold,
        color = Color.White
      )
      Text(
        text = stringResource(id = subtitle2),
        color = Color.White
      )
    }
  }
}

@Composable
@Preview(showBackground = true)
fun PreviewDetailsScreen() {
  UnsplashTheme {
    DetailsScreen(R.drawable.bcn_la_sagrada_familia)
  }
}