package view

import controller.FoodController
import dto.Restaurant
import utils.MessageUtils

class FoodView {

    fun init() {
    val foodController : FoodController = FoodController()

    print("Enter restaurant name [3 letters minimum]: ")
    val stringRestaurantName: String? = readLine()?.lowercase()

    val restaurantDataName = foodController.validateName(stringRestaurantName)

    var cuisineDataName : String = ""


    showResult(restaurantDataName, cuisineDataName, MessageUtils.valueRestaurantNameSearchResult)

    if (restaurantDataName.size > 0) {
        print("Enter the customer rating (1 star ~ 5 stars): ")
        val customerRating: String? = readLine()

        val restaurantDataCustomerRating = foodController.validateCustomerRating(customerRating, restaurantDataName)
        showResult(restaurantDataName, cuisineDataName, MessageUtils.valueRestaurantCustomerRatingSearchResult )

        print("Enter the distance in miles: ")
        val distance: String? = readLine()

        val restaurantDataDistance = foodController.validateDistance(distance, restaurantDataCustomerRating)
        showResult(restaurantDataName, cuisineDataName, MessageUtils.valueRestaurantDistanceSearch )

        println("Enter the price (above $1): ")
        val price: String? = readLine()

        val restaurantDataPrice = foodController.validatePrice(price, restaurantDataDistance)
        showResult(restaurantDataCustomerRating, cuisineDataName, MessageUtils.valueRestaurantPriceSearch)

        println("Enter the type of cuisine of the food. Ex.: American, Chinese, etc: ")
        val cuisine: String? = readLine()
        val cuisineDataType = foodController.validateCuisineExistence(cuisine)

        val cuisineDataName = foodController.getCuisineName(cuisineDataType)

        val finalResultSearch = foodController.getCuisineType(cuisineDataType, restaurantDataPrice)

        showResult(finalResultSearch, cuisineDataName, MessageUtils.valueRestaurantFinalSearch)
    }
}

fun showResult(restaurantData: MutableList<Restaurant>, cuisineDataName: String, message : String) {
    println(message)
    for (item in restaurantData) {
        println("Restaurant Name = " + item.name)
        println("Customer Rating = " + item.customerRating)
        println("Distance = " + item.distance)
        println("Price = $" + item.price)
        println("Cuisine = " + cuisineDataName )

        println("---------------------------")
    }
}

}