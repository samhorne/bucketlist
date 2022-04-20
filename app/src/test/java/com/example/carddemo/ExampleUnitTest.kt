package com.example.carddemo

import org.mockito.kotlin.*
import org.junit.Test
import org.junit.Assert.*

val EXP_JSON = "{\"id\":1,\"name\":\"Japan\",\"suggestions\":[{\"id\":2,\"type\":\"image\",\"text\":\"Tokyo\",\"img_url\":\"https://global.unitednations.entermediadb.net/assets/mediadb/services/module/asset/downloads/preset/Libraries/Production+Library/26-10-2020-Unplash-Japan.jpg/image1170x530cropped.jpg\",\"link_url\":\"https://www.google.com/search?q=tokyo\"},{\"id\":3,\"type\":\"image\",\"text\":\"Iwakuni\",\"img_url\":\"https://c4.wallpaperflare.com/wallpaper/98/332/42/dragon-bridge-wallpaper-preview.jpg\",\"link_url\":\"https://www.google.com/search?q=iwakuni\"},{\"id\":1,\"type\":\"image\",\"text\":\"Osaka\",\"img_url\":\"https://cdn-japantimes.com/wp-content/uploads/2021/06/np_file_95168.jpeg\",\"link_url\":\"https://www.google.com/search?q=osaka\"}]}"

class ExampleUnitTest {

    private val detailActivitySpy = spy<DetailActivity>()

    @Test
    fun `json successfully parsed into list of suggestions`() {
        val mockedSuggestions = mutableListOf<Suggestion>()
        mockedSuggestions.add(
            Suggestion(
                "image",
                "Tokyo",
                "https://global.unitednations.entermediadb.net/assets/mediadb/services/module/asset/downloads/preset/Libraries/Production+Library/26-10-2020-Unplash-Japan.jpg/image1170x530cropped.jpg",
                "https://www.google.com/search?q=tokyo",
            )
        )
        mockedSuggestions.add(
            Suggestion(
                "image",
                "Iwakuni",
                "https://c4.wallpaperflare.com/wallpaper/98/332/42/dragon-bridge-wallpaper-preview.jpg",
                "https://www.google.com/search?q=iwakuni",
            )
        )
        mockedSuggestions.add(
            Suggestion(
                "image",
                "Osaka",
                "https://cdn-japantimes.com/wp-content/uploads/2021/06/np_file_95168.jpeg",
                "https://www.google.com/search?q=osaka",
            )
        )

//        whenever(detailActivitySpy.callLocationApi())
//            .thenReturn(EXP_JSON)

        val actualSuggestions = detailActivitySpy.createObjectsFromApiCall()
        assertEquals(
            mockedSuggestions,
            actualSuggestions
        )
    }


}