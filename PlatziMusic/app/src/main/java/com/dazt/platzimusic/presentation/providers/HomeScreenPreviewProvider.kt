package com.dazt.platzimusic.presentation.providers

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.dazt.platzimusic.domain.Category
import com.dazt.platzimusic.domain.Task
import com.dazt.platzimusic.presentation.home.HomeDataState

class HomeScreenPreviewProvider : PreviewParameterProvider<HomeDataState> {

    override val values: Sequence<HomeDataState>
        get() = sequenceOf(
            HomeDataState(
                date = "March 9, 2024",
                summary = "5 incomplete, 5 completed",
                completedTask = completedTask,
                pendingTask = pendingTask
            )
        )


    val completedTask = mutableListOf<Task>()
        .apply {
            repeat(20) {
                add(
                    Task(
                        id = it.toString(),
                        title = "Task $it",
                        description = "Description $it",
                        category = Category.WORK,
                        isDone = false
                    )
                )
            }
        }

    val pendingTask = mutableListOf<Task>()
        .apply {
            repeat(20) {
                add(
                    Task(
                        id = (it + 30).toString(),
                        title = "Task $it",
                        description = "Description $it",
                        category = Category.OTHER,
                        isDone = true
                    )
                )
            }
        }

}