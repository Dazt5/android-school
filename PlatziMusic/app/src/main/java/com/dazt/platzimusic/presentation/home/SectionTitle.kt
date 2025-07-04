package com.dazt.platzimusic.presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dazt.platzimusic.ui.theme.MyAppTheme

@Composable
fun SectionTitle(
    modifier: Modifier = Modifier,
    title: String
) {
    Box(modifier = modifier) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SectionTitlePreview() {
    MyAppTheme {
        SectionTitle(title = "Today")
    }

}
