package com.orange.noteappbasic.screen

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.orange.noteappbasic.components.NoteButton
import com.orange.noteappbasic.components.NoteInputText
import com.orange.noteappbasic.components.TopAppBar
import com.orange.noteappbasic.data.NotesDataSource
import com.orange.noteappbasic.model.Note
import java.time.format.DateTimeFormatter


@Composable
fun NoteScreen(
    notes: List<Note>,
    onAddNote: (Note) -> Unit,
    onRemoveNote: (Note) -> Unit
) {
    var title by rememberSaveable { mutableStateOf("") }
    var note by rememberSaveable {
        mutableStateOf("")
    }

    val context = LocalContext.current
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar()
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Top,
        ) {


            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                NoteInputText(label = "Title", maxLine = 2, text = title, onTextChange = { text ->
                    if (text.all { char ->
                            char.isLetter() || char.isWhitespace()
                        }) title = text
                })
                NoteInputText(label = "Add note", maxLine = 4, text = note, onTextChange = { text ->
                    if (text.all { char ->
                            char.isLetter() || char.isWhitespace()
                        }) note = text
                })
                NoteButton(
                    text = "SAVE",
                    onClick = {
                        if (title.isNotEmpty() && note.isNotEmpty()) {
                            //save note
                            onAddNote(Note(title = title, desc =  note))
                            //empty text fields
                            title = ""
                            note = ""
                            Toast.makeText(context, "Note saved successfully", Toast.LENGTH_SHORT).show()
                        }
                    },

                    )
                Divider(
                    modifier = Modifier.padding(10.dp),
                    color = Color.LightGray
                )

            }
            LazyColumn {
                items(notes) { it ->
                    NoteRow(note = it, onNoteClicked = {
                        onRemoveNote(it)
                        Toast.makeText(context, "Note deleted Successfully", Toast.LENGTH_SHORT).show()
                    })

                }
            }

        }
    }
}

@Composable
fun NoteRow(
    modifier: Modifier = Modifier,
    note: Note,
    onNoteClicked: (Note) -> Unit,
) {
    Surface(
        Modifier
            .padding(4.dp)
            .clip(shape = RoundedCornerShape(topEnd = 33.dp, bottomStart = 33.dp))
            .fillMaxWidth(),
        color = Color(0XFFDFE6EB),
        elevation = 6.dp
    ) {
        Column(
            modifier = modifier
                .clickable {onNoteClicked(note)}
                .padding(horizontal = 14.dp, vertical = 6.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = note.title, style = MaterialTheme.typography.subtitle2)
            Text(text = note.desc, style = MaterialTheme.typography.subtitle1)
            Text(
                text = note.entryDate.format(DateTimeFormatter.ofPattern("EEE, d MMM")),
                style = MaterialTheme.typography.caption
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NoteScreenPreview() {
    NoteScreen(notes = emptyList(), onAddNote = {}, onRemoveNote = {})
}