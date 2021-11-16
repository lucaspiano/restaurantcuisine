package repository

import dto.Cuisine
import dto.Restaurant
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import java.io.BufferedReader
import java.io.File

class RestaurantRepository(val fileName : File) {

    fun getRestaurantData() : MutableList<Restaurant> {
        val bufferedReaderRestaurant: BufferedReader = fileName.bufferedReader()

        val csvParserRestaurant = CSVParser(
            bufferedReaderRestaurant, CSVFormat.DEFAULT
                .withFirstRecordAsHeader()
                .withIgnoreHeaderCase()
                .withTrim()
        );

        var restaurantList: MutableList<Restaurant> = mutableListOf<Restaurant>()
        for (csvRecord in csvParserRestaurant) {
            val name = csvRecord.get("name")
            val customeRating = csvRecord.get("customer_rating")
            val distance = csvRecord.get("distance")
            val price = csvRecord.get("price")
            var cuisineId = csvRecord.get("cuisine_id")

            var restaurant: Restaurant = Restaurant()

            restaurant.name = name.lowercase()
            restaurant.customerRating = customeRating
            restaurant.distance = distance
            restaurant.price = price
            restaurant.cuisineId = cuisineId

            restaurantList.add(restaurant)
        }
        return restaurantList
    }
}