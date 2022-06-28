package com.ilhomsoliev.addstufffeature.presentation

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Save
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ilhomsoliev.addstufffeature.presentation.pickColorDialog.PickColorDialog
import com.ilhomsoliev.core.Helper
import com.ilhomsoliev.theme.Red

@Composable
fun AddStuffScreen(
    navController: NavController,
    viewModel: ViewModelAddStuff = hiltViewModel()
) {
    var label by remember { mutableStateOf("") }
    var defaultValue by remember { mutableStateOf("0") }
    var resetValue by remember { mutableStateOf("0") }
    var increaseBy by remember { mutableStateOf("1") }
    var decreaseBy by remember { mutableStateOf("1") }
    var pickedColor by remember { mutableStateOf(Red) }
    var isAdvancedSettingsShown by remember { mutableStateOf(false) }
    var isDialogOpen by remember { mutableStateOf(false) }

    val addStuffState by viewModel.stateAddStuff

    if (addStuffState.response == true) {
        navController.popBackStack()
        viewModel.stop()
    }
    PickColorDialog(
        title = "Pick Color",
        isDialogOpen = isDialogOpen,
        onDismissRequest = { isDialogOpen = false },
        onCancelButtonClick = { isDialogOpen = false },
        onSaveButtonClick = {
            isDialogOpen = false
            pickedColor = it
        }
    )
    Scaffold(topBar = {
        TopAppBar() {
            Text(text = "Add Stuff")
        }
    }, floatingActionButton = {
        FloatingActionButton(onClick = {
            Log.d("HEllo", "Here11")
            viewModel.addStuff(
                name = label,
                count = defaultValue.toInt(),
                color = pickedColor.toArgb().toLong(),
                defaultValue = defaultValue.toInt(),
                resetValue = resetValue.toInt(),
                increaseBy = increaseBy.toInt(),
                decreaseBy = decreaseBy.toInt(),
            )
        }) {
            Icon(imageVector = Icons.Default.Save, contentDescription = "")
        }
    }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 8.dp)
            ) {
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = label,
                    label = { Text(text = "Stuff name") },
                    onValueChange = {
                        label = it
                    }
                )
                Text(text = "Color")
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(pickedColor)
                        .clickable {
                            isDialogOpen = true
                        },
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "")
                    Text(
                        modifier = Modifier.padding(vertical = 12.dp),
                        text = Helper.getColorName(pickedColor),
                        fontSize = 27.sp
                    )
                    Icon(
                        modifier = Modifier.size(34.dp),
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = null
                    )
                }
                AnimatedVisibility(visible = isAdvancedSettingsShown) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Row(modifier = Modifier.fillMaxWidth()) {
                            OutlinedTextField(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f),
                                value = defaultValue,
                                label = { Text(text = "Value") },
                                onValueChange = {
                                    defaultValue = it
                                }, keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Number
                                )
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            OutlinedTextField(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f),
                                value = resetValue,
                                label = { Text(text = "Reset value") },
                                onValueChange = {
                                    resetValue = it
                                }, keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Number
                                )
                            )
                        }
                        Spacer(modifier = Modifier.height(12.dp))
                        Row(modifier = Modifier.fillMaxWidth()) {
                            OutlinedTextField(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f),
                                value = increaseBy,
                                label = { Text(text = "Increase by") },
                                onValueChange = {
                                    increaseBy = it
                                }, keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Number
                                )
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            OutlinedTextField(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f),
                                value = decreaseBy,
                                label = { Text(text = "Decrease by") },
                                onValueChange = {
                                    decreaseBy = it
                                }, keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Number
                                )
                            )
                        }
                    }
                }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(onClick = {
                        isAdvancedSettingsShown = !isAdvancedSettingsShown
                    }) {
                        Text(text = "Show advanced Settings".toUpperCase())
                    }
                }
            }
        }
    }
}