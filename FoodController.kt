package controller

import dto.Restaurant
import service.FoodService
import java.lang.Integer.*

class FoodController {

    private val foodService : FoodService = FoodService()
    val restaurantData = foodService.getRestaurantService()
    val cuisineData = foodService.getCuisinesService()

    val resultData : MutableList<Restaurant> = mutableListOf()

    fun validateName(restaurantName : String?): MutableList<Restaurant> {
        for (item in restaurantData) {
            if (restaurantName?.length!! < 3) {
                throw Exception("Please, type at least 3 letters for searching!")
            }

            if (restaurantName?.substring(0, 2) == item.name.substring(0, 2)) {
               resultData.add(item)
            }
        }
        return resultData
    }

    fun validateCustomerRating(customerRating: String?, restaurantDataName : MutableList<Restaurant>) : MutableList<Restaurant> {
        val resultCustomerRatingFilter : MutableList<Restaurant> = mutableListOf()
        var count : Int = 1

        if (parseInt(customerRating) < 1 || (parseInt(customerRating)) > 5) {
            throw java.lang.Exception("Value is out of the allowed range!")
        }

        for (item in restaurantDataName) {
           if (parseInt(customerRating) in 1..5) {
              if (parseInt(item.customerRating) >= parseInt(customerRating)) {
                  resultCustomerRatingFilter.add(item)
              }
           }
       }
       return resultCustomerRatingFilter;
    }

    fun validateDistance(distance: String?, restaurantDataCustomerRating : MutableList<Restaurant>) :
            MutableList<Restaurant> {

        val resultDistanceFilter : MutableList<Restaurant> = mutableListOf()
        if (parseInt(distance) < 1) {
            throw java.lang.Exception("The distance must be greater or equals 1 mile!")
        }

        for (item in restaurantDataCustomerRating) {
            if (parseInt(distance) >= Integer.parseInt(item.distance)) {
                resultDistanceFilter.add(item)
            }
        }
        return resultDistanceFilter;
    }

    fun validatePrice(price : String? , restaurantDataDistance: MutableList<Restaurant>) : MutableList<Restaurant> {
        val resultPriceFilter : MutableList<Restaurant> = mutableListOf()
        if (Integer.parseInt(price) < 1) {
            throw Exception("The price must be greater or equals $1!")
        }

        for (item in restaurantDataDistance) {
            if (Integer.parseInt(price) >= Integer.parseInt(item.price)) {
                resultPriceFilter.add(item)
            }
        }
        return resultPriceFilter;
    }

    fun validateCuisineExistence(cuisine : String?) :
            String {
        val resultCuisineFilter : MutableList<Restaurant> = mutableListOf()
        var strBuilder : StringBuilder = StringBuilder()
        var valueCuisineId : String = ""
        for (item in cuisineData) {
            if (cuisine.equals(item.name)) {
                valueCuisineId = item.id;
            }
        }

        return valueCuisineId;

    }

    fun getCuisineName(cuisineId : String?) : String {
        var cuisineName: String = ""

        for (item in cuisineData) {
            if (cuisineId.equals(item.id)) {
                cuisineName = item.name
            }
        }

        return cuisineName;
    }


    fun getCuisineType(cuisineId: String?, restaurantDataPrice: MutableList<Restaurant>) :
            MutableList<Restaurant> {
        var finalResult : MutableList<Restaurant> = mutableListOf()

        for (item in restaurantDataPrice) {
            if (cuisineId.equals(item.cuisineId)) {
                finalResult.add(item)
            }
        }
        return finalResult
    }

    fun getAllRestaurantsController() : MutableList<Restaurant> {
        return foodService.getRestaurantService()
    }

}

