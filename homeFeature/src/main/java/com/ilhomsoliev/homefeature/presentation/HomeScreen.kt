package com.ilhomsoliev.homefeature.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ResetTv
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ilhomsoliev.core.Routes
import com.ilhomsoliev.homefeature.presentation.components.StuffItem

@Composable
fun HomeScreen(navController: NavController, viewModel: ViewModelHome = hiltViewModel()) {

    val stuffsState by viewModel.stateStuffs

    Scaffold(
        topBar = {
            TopAppBar {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Stuff counting")
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(imageVector = Icons.Default.ResetTv, contentDescription = "")
                        }
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(imageVector = Icons.Default.Settings, contentDescription = "")
                        }
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(imageVector = Icons.Default.Menu, contentDescription = "")
                        }
                    }
                }
            }
        }, floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(Routes.ADD_STUFF_SCREEN)
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }
    ) {
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .background(Color.Gray)
        ) {
            LazyColumn {
                if (stuffsState.isLoading) {
                    item {
                        CircularProgressIndicator()
                    }
                }
                if (stuffsState.error != "") {
                    item {
                        Text(text = "Some ererer", color = Color.Red)
                    }
                }
                stuffsState.response?.let { stuffs ->
                    items(stuffs) { stuff ->
                        StuffItem(
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                            name = stuff.name,
                            count = stuff.count,
                            backgroundColor = Color(stuff.color.toInt()),
                            onMinusClick = {
                                viewModel.addStuff(
                                    id = stuff.id!!,
                                    name = stuff.name,
                                    count = stuff.count - stuff.decreaseBy,
                                    color = stuff.color,
                                    defaultValue = stuff.defaultValue,
                                    resetValue = stuff.resetValue,
                                    increaseBy = stuff.increaseBy,
                                    decreaseBy = stuff.decreaseBy,
                                )
                            },
                            onPlusClick = {
                                viewModel.addStuff(
                                    id = stuff.id!!,
                                    name = stuff.name,
                                    count = stuff.count + stuff.increaseBy,
                                    color = stuff.color,
                                    defaultValue = stuff.defaultValue,
                                    resetValue = stuff.resetValue,
                                    increaseBy = stuff.increaseBy,
                                    decreaseBy = stuff.decreaseBy,
                                )
                            },
                            onItemClick = {

                            },
                        )
                    }
                }
            }
        }
    }
}