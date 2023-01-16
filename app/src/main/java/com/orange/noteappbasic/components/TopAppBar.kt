package com.orange.noteappbasic.components


import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.TopAppBar
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource

import com.orange.noteappbasic.R

@Composable
fun TopAppBar(
    modifier: Modifier = Modifier
) {
    TopAppBar(
        backgroundColor = Color.LightGray,
        contentColor = Color.Black,
        title = {
            Text(
                text = stringResource(id = R.string.note_app),
                fontStyle = MaterialTheme.typography.h3.fontStyle
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    TopAppBar()
}