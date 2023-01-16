package com.orange.noteappbasic.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.orange.noteappbasic.components.NoteButton
import com.orange.noteappbasic.components.NoteInputText

import com.orange.noteappbasic.components.TopAppBar


@Composable
fun NoteScreen() {
    var title by rememberSaveable { mutableStateOf("") }
    var note by rememberSaveable {
        mutableStateOf("")
    }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar()
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(20.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            NoteInputText(label = "Title", maxLine = 2, text = title, onTextChange = {
                text->
                if (text.all { char ->
                        char.isLetter() || char.isWhitespace()
                    }) title = text
            })
            NoteInputText(label = "Add note", maxLine = 4, text = note, onTextChange = {
                    text->
                if (text.all { char ->
                        char.isLetter() || char.isWhitespace()
                    }) note = text
            })
            NoteButton(text = "SAVE", onClick = {})
        }
    }
}



@Preview(showBackground = true)
@Composable
fun NoteScreenPreview() {
    NoteScreen()
}