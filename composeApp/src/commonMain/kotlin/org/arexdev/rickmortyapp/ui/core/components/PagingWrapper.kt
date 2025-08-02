package org.arexdev.rickmortyapp.ui.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.LoadState
import app.cash.paging.compose.LazyPagingItems
import org.arexdev.rickmortyapp.ui.core.BackgroundPrimaryColor
import org.arexdev.rickmortyapp.ui.core.DefaultTextColor

enum class PagingType {
    ROW,
    COLUMN,
    VERTICAL_GRID,
}

@Composable
fun <T : Any> PagingWrapper(
    pagingType: PagingType,
    pagingItems: LazyPagingItems<T>,
    initialView: @Composable () -> Unit = {},
    emptyView: @Composable () -> Unit = {},
    extraItemsView: @Composable () -> Unit = {},
    itemView: @Composable (T) -> Unit
) {

    when {

        pagingItems.loadState.refresh is LoadState.Loading && pagingItems.itemCount == 0 -> {
            //Initial loading
            initialView()
        }

        pagingItems.loadState.refresh is LoadState.NotLoading && pagingItems.itemCount == 0 -> {
            //Error loading
            emptyView()
        }

        else -> {

            when (pagingType) {
                PagingType.ROW -> {
                    LazyRow {
                        items(pagingItems.itemCount) { index ->
                            pagingItems[index]?.let { itemModel ->
                                itemView(itemModel)
                            }
                        }
                    }
                }

                PagingType.COLUMN -> {
                    LazyColumn {
                        items(pagingItems.itemCount) { index ->
                            pagingItems[index]?.let { itemModel ->
                                itemView(itemModel)
                            }
                        }
                    }
                }

                PagingType.VERTICAL_GRID -> LazyVerticalGrid(
                    modifier = Modifier.fillMaxSize().background(BackgroundPrimaryColor).padding(horizontal = 16.dp),
                    columns = GridCells.Fixed(2),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    item(span = { GridItemSpan(2) }) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                "Characters",
                                fontSize = 24.sp,
                                color = DefaultTextColor,
                                fontWeight = FontWeight.SemiBold
                            )
                            Spacer(Modifier.height(6.dp))
                            extraItemsView()
                        }
                    }
                    items(pagingItems.itemCount) { index ->
                        pagingItems[index]?.let { itemModel ->
                            itemView(itemModel)
                        }
                    }
                }
            }



            if (pagingItems.loadState.append is LoadState.Loading) {
                initialView()
            }
        }
    }

}