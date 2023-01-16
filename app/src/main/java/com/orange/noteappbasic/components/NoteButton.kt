package com.orange.noteappbasic.components

import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NoteButton(
    modifier: Modifier = Modifier,
    text:String,
    onClick:()->Unit,
    enabled:Boolean = true
) {
    Button(
        onClick = onClick,
        shape = CircleShape,
        enabled = enabled
    ) {
        Text(text)
    }
}

//@Preview(showBackground = true)
//@Composable
//fun SaveButtonPreview() {
//    SaveButton()
//}