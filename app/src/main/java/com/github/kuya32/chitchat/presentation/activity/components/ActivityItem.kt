package com.github.kuya32.chitchat.presentation.activity

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.github.kuya32.chitchat.R
import com.github.kuya32.chitchat.domain.models.Activity
import com.github.kuya32.chitchat.domain.utils.ActivityAction
import com.github.kuya32.chitchat.presentation.ui.theme.SpaceSmall

@Composable
fun ActivityItem(
    activity: Activity,
    viewModel: ActivityViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    Card(
        shape = MaterialTheme.shapes.medium,
        backgroundColor = MaterialTheme.colors.onSurface,
        modifier = Modifier
            .padding(SpaceSmall)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(SpaceSmall),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val actionText = when (activity.actionType) {
                is ActivityAction.LikedPost -> {
                    stringResource(id = R.string.lower_liked)
                }
                is ActivityAction.CommentedOnPost -> {
                    stringResource(id = R.string.commented_on)
                }
            }
            Text(
                text = buildAnnotatedString {
                    withStyle(SpanStyle(
                        fontWeight = FontWeight.Bold
                    )) {
                        append(activity.username)
                    }
                    append(" $actionText ")
                    withStyle(
                        SpanStyle(
                            fontWeight = FontWeight.Bold
                        )) {
                        append(stringResource(id = R.string.your_post))
                    }
                },
                style = MaterialTheme.typography.body2,
                fontSize = 10.sp
            )
            Text(
                text = viewModel.getDateAndTime(activity.timeStamp),
                style = MaterialTheme.typography.body2,
                fontSize = 10.sp
            )
        }

    }
}