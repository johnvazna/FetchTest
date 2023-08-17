package com.johnvazna.hiring.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.johnvazna.hiring.R
import com.johnvazna.hiring.presentation.entities.PersonUI

/** */
@Composable
fun PersonListWithHeader(persons: List<PersonUI>) {

    val filteredPersons = persons.filter { !it.name.isNullOrBlank() }
    val sortedPersons = filteredPersons.sortedWith(compareBy({ it.listId }, { it.name }))
    val groupedPersons = sortedPersons.groupBy { it.listId }

    val itemsWithHeaders = mutableListOf<Any?>()
    groupedPersons.forEach { (listId, personsOfList) ->
        itemsWithHeaders.add(listId)
        itemsWithHeaders.addAll(personsOfList)
    }

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.welcome_fetch),
                fontSize = 20.sp,
                style = TextStyle(fontWeight = FontWeight.Bold)
            )
        }

        LazyColumn {
            itemsIndexed(itemsWithHeaders) { _, item ->
                when (item) {
                    is Int -> PersonHeader(listId = item)
                    is PersonUI -> PersonItem(personUI = item)
                }
            }
        }
    }
}

@Composable
fun PersonHeader(listId: Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "ListId: $listId",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(10.dp)
        )
    }
}

@Composable
fun PersonItem(personUI: PersonUI) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp), contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .clip(RoundedCornerShape(30.dp))
                .background(Color.Black)
                .padding(10.dp)
        ) {
            Text(
                text = "${personUI.name}, ${personUI.listId}",
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPersonsList() {
    val samplePersons = listOf(
        PersonUI(684, 1, "Item 684"),
        PersonUI(276, 1, "Item 276"),
        PersonUI(808, 4, "Item 808")
    )
    PersonListWithHeader(persons = samplePersons)
}
