package com.example.news_app.presentation.newsDetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsDetailScreen(
    title: String,
    description: String,
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Article Details") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = null)
                    }
                },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.Share, contentDescription = null)
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color.White, Color(0xFFF0F2F5))
                    )
                )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .background(Color(0xFFE9ECEF))
            ) {
                Surface(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(16.dp),
                    color = Color(0xFF007BFF),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "WORLD NEWS",
                        color = Color.White,
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                        style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold)
                    )
                }
            }

            Column(modifier = Modifier.padding(20.dp)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.Black,
                        lineHeight = 36.sp,
                        color = Color(0xFF212529)
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Surface(
                        modifier = Modifier.size(40.dp),
                        shape = RoundedCornerShape(20.dp),
                        color = Color(0xFF6C757D)
                    ) {}
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(
                            text = "By News Editor",
                            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                        )
                        Text(
                            text = "Oct 24, 2023 · 5 min read",
                            style = MaterialTheme.typography.labelSmall,
                            color = Color.Gray
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                HorizontalDivider(color = Color(0xFFDEE2E6))

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        lineHeight = 28.sp,
                        color = Color(0xFF495057),
                        letterSpacing = 0.5.sp
                    )
                )
                
                Spacer(modifier = Modifier.height(32.dp))
                
                Button(
                    onClick = { },
                    modifier = Modifier.fillMaxWidth().height(56.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF007BFF))
                ) {
                    Text("Read Full Coverage", fontWeight = FontWeight.Bold)
                }
                
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}
