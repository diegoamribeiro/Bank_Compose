package com.dmribeiro87.bankcompose.ui.screens.home.sections

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dmribeiro87.bankcompose.R
import com.dmribeiro87.bankcompose.data.Card
import com.dmribeiro87.bankcompose.ui.theme.BlueEnd
import com.dmribeiro87.bankcompose.ui.theme.BlueStart
import com.dmribeiro87.bankcompose.ui.theme.GreenEnd
import com.dmribeiro87.bankcompose.ui.theme.GreenStart
import com.dmribeiro87.bankcompose.ui.theme.OrangeEnd
import com.dmribeiro87.bankcompose.ui.theme.OrangeStart
import com.dmribeiro87.bankcompose.ui.theme.PurpleEnd
import com.dmribeiro87.bankcompose.ui.theme.PurpleStart


val cards = listOf(
    Card(
        cardType = "Visa",
        cardMember = "4303 4995 6612 0775",
        cardName = "Business",
        balance = 46.467,
        color = getGradient(PurpleStart, PurpleEnd)
    ),
    Card(
        cardType = "Master Card",
        cardMember = "1556 0095 7712 0665",
        cardName = "Savings",
        balance = 6.467,
        color = getGradient(BlueStart, BlueEnd)
    ),
    Card(
        cardType = "Visa",
        cardMember = "8867 4456 2234 0095",
        cardName = "School",
        balance = 2.345,
        color = getGradient(OrangeStart, OrangeEnd)
    ),
    Card(
        cardType = "Master Card",
        cardMember = "8867 4456 2234 0095",
        cardName = "Trips",
        balance = 3.345,
        color = getGradient(GreenStart, GreenEnd)
    ),
)

@Preview
@Composable
fun CardSection() {
    LazyRow{
        items(cards.size){ index ->
            CardItem(index)
        }
    }
}

@Composable
fun CardItem(
    index: Int
) {
    val card = cards[index]
    var lastItemPaddingEnd = 0.dp
    if (index == cards.size -1){
        lastItemPaddingEnd = 16.dp
    }
    var image = painterResource(id = R.drawable.ic_visa)
    if (card.cardType == "Master Card"){
        image = painterResource(id = R.drawable.ic_mastercard)
    }
    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = lastItemPaddingEnd))
    {
        Column (
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.color)
                .width(250.dp)
                .height(160.dp)
                .clickable { }
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ){

            Image(
                painter = image,
                contentDescription = card.cardName,
                modifier = Modifier.width(60.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = card.cardName,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "R$ ${card.balance}",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = card.cardMember,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

fun getGradient(
    startColor: Color,
    endColor: Color
) : Brush{
    return Brush.horizontalGradient(
        colors = listOf(startColor, endColor)
    )
}